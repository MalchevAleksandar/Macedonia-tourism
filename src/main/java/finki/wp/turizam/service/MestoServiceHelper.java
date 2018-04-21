package finki.wp.turizam.service;

import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.TmestoDetails;
import finki.wp.turizam.model.jpa.TmestoPicture;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface MestoServiceHelper {

  List<Tmesto> getBooksInCategory(Long categoryId);

  TmestoDetails getBookDetails(Long bookId);




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


  TmestoPicture addMestoPicture(
          Long bookId,
          byte[] bytes,
          String contentType) throws SQLException;

}
