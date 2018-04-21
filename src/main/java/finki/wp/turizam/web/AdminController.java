package finki.wp.turizam.web;

import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.Category;
import finki.wp.turizam.service.MestaManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Controller
public class AdminController {

  MestaManagementService storeManagementService;




  @Autowired
  public AdminController(MestaManagementService storeManagementService) {
    this.storeManagementService = storeManagementService;
  }

  @RequestMapping(value = {"/admin/category"}, method = RequestMethod.GET)
  public String addCategory(Model model) {
    Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
    if(authentication.isAuthenticated()) {
      UserDetails details= (UserDetails) authentication.getPrincipal();
    }
    model.addAttribute("pageFragment", "addCategory");
    return "index";
  }

  @RequestMapping(value = {"/admin/book"}, method = RequestMethod.GET)
  public String addProduct(Model model) {
    model.addAttribute("pageFragment", "addBook");
    //model.addAttribute("authors", authorsRepository.findAll());
    return "index";
  }


  @RequestMapping(value = {"/admin/category"}, method = RequestMethod.POST)
  public String createCategory(Model model,
                               @RequestParam String categoryName) {
    Category category = storeManagementService.createTopLevelCategory(categoryName);
    return "redirect:/tvojpredlog";
   // return "index";
  }


  @RequestMapping(value = {"/admin/book"}, method = RequestMethod.POST)
  public String createProduct(Model model,
                              @RequestParam String name,
                              @RequestParam Long categoryId,
                              @RequestParam String description,
                              MultipartFile picture) throws IOException, SQLException {

    Tmesto product = storeManagementService.createMesto(
      name,
      categoryId,
            description
    );
    storeManagementService.addMestoPicture(product.id, picture.getBytes(), picture.getContentType());

   // storeManagementService.createdetails(description,product);

    model.addAttribute("product", product);
    return "index";
  }


}
