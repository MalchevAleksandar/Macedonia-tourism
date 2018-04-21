package finki.wp.turizam.service;


import finki.wp.turizam.model.exceptions.CategoryInUseException;
import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.TmestoDetails;
import finki.wp.turizam.model.jpa.TmestoPicture;
import finki.wp.turizam.model.jpa.Category;

import java.sql.SQLException;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface MestaManagementService {


  Category createTopLevelCategory(String name);

  Category createCategory(
          String name,
         Long parentId
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

  Tmesto createMesto(
          String name,
          Long categoryId,
          String description

  );

  TmestoDetails createdetails(

          String detali,
          Tmesto mesto
  );


  Tmesto updateMesto(
          Long bookId,
          String name

  );

  Tmesto updateMestoCategory(
          Long bookId,
          Long newCategoryId
  );

  TmestoPicture addMestoPicture(Long bookId, byte[] bytes, String contentType) throws SQLException;
}
