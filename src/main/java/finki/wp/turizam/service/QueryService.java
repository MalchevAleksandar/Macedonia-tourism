package finki.wp.turizam.service;

import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.TmestoPicture;
import finki.wp.turizam.model.jpa.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface QueryService {

  Page<Tmesto> getMestaInCategory(Long categoryId, int page, int pageSize);

    Page<Tmesto> getPromotedBooks(int page, int pageSize);

   List<Category> findTopLevelCategories();

    List<Category> findCategories();

  TmestoPicture getByMestoId(Long bookId);

  List<Tmesto> searchMesto(String query);

    Iterable<Tmesto> findsite();

   // Page<Tmesto> findsite(Pageable p);
}
