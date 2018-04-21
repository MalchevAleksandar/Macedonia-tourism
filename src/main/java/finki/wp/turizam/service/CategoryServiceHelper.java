package finki.wp.turizam.service;

import finki.wp.turizam.model.exceptions.CategoryInUseException;
import finki.wp.turizam.model.jpa.Category;

import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface CategoryServiceHelper {

  List<Category> getTopLevelCategories();

  List<Category> getSubCategories(Long categoryId);

  Category createTopLevelCategory(String name);

  Category createCategory(
          String name,
          long parentId
  );

  Category updateCategoryName(
          Long id,
          String newName
  );

//  Category changeCategoryParent(
//          Long id
//      //    Long parentId
//  );

  void removeCategory(Long id)
    throws CategoryInUseException;

}
