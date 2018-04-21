package finki.wp.turizam.web;

import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.TmestoPicture;
import finki.wp.turizam.model.page.PageWrapper;
import finki.wp.turizam.service.QueryService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Controller
public class Kontroler {

    @Autowired
    QueryService queryService;

   @RequestMapping("/kontakt")
    public String kontakt(Model model) {

       model.addAttribute("pageFragment", "kontakt");

        return "index";
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {

      //   model.addAttribute("product",queryService.findsite());

        model.addAttribute("pageFragment", "home");

        return "index";
    }
    @RequestMapping(value = {"/turistickimesta"}, method = RequestMethod.GET)
    public String mesta(Model model) {

        model.addAttribute("product",queryService.findsite());

       // PageWrapper<Tmesto> page = new PageWrapper<Tmesto>
       // (blogService.getAllPublishedPosts(pageable), '/blog');


        model.addAttribute("pageFragment", "mesta" );

        return "index";
    }

    @RequestMapping(value = {"/tvojpredlog"}, method = RequestMethod.GET)
    public String predlog(Model model) {
        model.addAttribute("pageFragment", "tvojpredlog" );

        return "index";
    }

    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public String product(Model model) {

        model.addAttribute("product",queryService.findsite());

        model.addAttribute("pageFragment", "products" );

        return "index";
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, HttpSession session, @RequestParam(required = false) String error) {
        if (session.getAttribute("user") != null) {
            return "redirect:/";
        }
        model.addAttribute("error", error);

        model.addAttribute("pageFragment", "login");
        return "index";
    }

    @RequestMapping(value = {"/galerija"})
    public String galerija(Model model) {

        model.addAttribute("pageFragment", "galerija");
        return "index";
    }

    @RequestMapping(value = {"/book/{id}/picture"}, method = RequestMethod.GET)
    @ResponseBody
    public void index(@PathVariable Long id, HttpServletResponse response) throws IOException, SQLException {
        OutputStream out = response.getOutputStream();

        TmestoPicture bookPicture = queryService.getByMestoId(id);

        String contentDisposition = String.format("inline;filename=\"%s\"",
                bookPicture.picture.fileName + ".png?productId=" + id);

        response.setHeader("Content-Disposition", contentDisposition);
        response.setContentType(bookPicture.picture.contentType);
        response.setContentLength(bookPicture.picture.size);

        IOUtils.copy(bookPicture.picture.data.getBinaryStream(), out);

        out.flush();
        out.close();
    }

    @RequestMapping(value = {"/category/{categoryId}"}, method = RequestMethod.GET)
    public String categoryProducts(
            @PathVariable Long categoryId,
         //  @RequestParam Long categoryId,
            Model model
    ) {
        Page<Tmesto> page = queryService.getMestaInCategory(
                categoryId, 0, 20
        );

        model.addAttribute("product", page);
        model.addAttribute("pageFragment","mesta");
        return "index";
    }


    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
    public String listbyCategory(
            // @PathVariable Long categoryId,
            @RequestParam Long categoryId,
            Model model
    ) {
        Page<Tmesto> page = queryService.getMestaInCategory(
                categoryId, 0, 20
        );

        model.addAttribute("product", page);
        model.addAttribute("pageFragment","mesta");
        return "index";
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String search(
            @RequestParam String query,
            Model model
    ) {
        List<Tmesto> books = queryService.searchMesto(query);

        model.addAttribute("pageFragment","mesta");
        model.addAttribute("product", books);
        model.addAttribute("query", query);

        return "index";
    }


}
