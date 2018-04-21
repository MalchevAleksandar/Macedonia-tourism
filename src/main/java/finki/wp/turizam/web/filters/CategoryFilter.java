package finki.wp.turizam.web.filters;

import finki.wp.turizam.model.jpa.Category;
import finki.wp.turizam.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Component
public class CategoryFilter implements Filter {


    private QueryService service;

    @Autowired
    public CategoryFilter(QueryService service) {
        this.service = service;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(
      ServletRequest servletRequest,
      ServletResponse servletResponse,
      FilterChain filterChain
    ) throws IOException, ServletException {
    //   List<Category> categories = service.findTopLevelCategories();
       List<Category> categories = service.findCategories();

       servletRequest.setAttribute("categories", categories);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
