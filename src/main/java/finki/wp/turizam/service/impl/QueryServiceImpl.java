package finki.wp.turizam.service.impl;

import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.TmestoPicture;
import finki.wp.turizam.persistence.TmestoPictureRepository;
import finki.wp.turizam.model.jpa.Category;
import finki.wp.turizam.persistence.CategoryRepository;
import finki.wp.turizam.persistence.QueryRepository;
import finki.wp.turizam.persistence.SearchRepository;
import finki.wp.turizam.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Service
public class QueryServiceImpl implements QueryService {

  QueryRepository queryRepository;

  CategoryRepository categoryRepository;

  TmestoPictureRepository bookPictureRepository;

  @Autowired
  SearchRepository searchRepository;

  @Autowired
  public QueryServiceImpl(
    QueryRepository bookRepository,
    CategoryRepository categoryRepository,
    TmestoPictureRepository bookPictureRepository
  ) {
    this.queryRepository = bookRepository;
    this.categoryRepository = categoryRepository;
    this.bookPictureRepository = bookPictureRepository;
  }

  @Override
  public Page<Tmesto> getMestaInCategory(Long categoryId, int page, int pageSize) {
    return queryRepository.findMestaByCategoryPaged(categoryId, page, pageSize);
  }

  @Override
  public Page<Tmesto> getPromotedBooks(int page, int pageSize) {
    return queryRepository.findPromotedBooks(page, pageSize);

  }

  @Override
  public List<Category> findTopLevelCategories() {    return categoryRepository.findByParentIsNull();
 }

@Override
public List<Category> findCategories() {    return categoryRepository.findByNameNotNull();
}


  @Override
  public TmestoPicture getByMestoId(Long bookId) {
    return bookPictureRepository.findByMestoId(bookId);
  }

  @Override
  public List<Tmesto> searchMesto(String query) {
    return searchRepository.searchPhrase(
      Tmesto.class,
      query,
      "name",  "category.name");
  }



@Override
 public  Iterable<Tmesto> findsite(){

    return queryRepository.findsite();

  }
//@Override
//public Page<Tmesto> findsite(Pageable p){
//
//  return queryRepository.findsite(p);
//
//}


}
