package finki.wp.turizam.service.impl;

import finki.wp.turizam.model.exceptions.CategoryInUseException;
import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.TmestoDetails;
import finki.wp.turizam.model.jpa.TmestoPicture;
import finki.wp.turizam.model.jpa.Category;
import finki.wp.turizam.service.MestaManagementService;
import finki.wp.turizam.service.MestoServiceHelper;
import finki.wp.turizam.service.CategoryServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Service
@Secured(value = "ROLE_ADMIN")
public class MestaManagementServiceImpl implements MestaManagementService {

  @Autowired
  private CategoryServiceHelper categoryServiceHelper;

  @Autowired
  private MestoServiceHelper mestaServiceHelper;


  @Override
  public Category createTopLevelCategory(String name) {
    return categoryServiceHelper.createTopLevelCategory(name);
  }

  @Override
  public Category createCategory(String name,Long id) {
    return categoryServiceHelper.createCategory(name,id);
  }

  @Override
  public Category updateCategoryName(Long id, String newName) {
    return categoryServiceHelper.updateCategoryName(id, newName);
  }

//  @Override
//  public Category changeCategoryParent(Long id) {
//    return categoryServiceHelper.changeCategoryParent(id);
//  }

  @Override
  public void removeCategory(Long id) throws CategoryInUseException {
    categoryServiceHelper.removeCategory(id);
  }

  @Override
  public Tmesto createMesto(String name, Long categoryId,String description) {
    return mestaServiceHelper.createMesto(name, categoryId,description);
  }

  @Override
  public TmestoDetails createdetails(String description,Tmesto mesto){

    return mestaServiceHelper.createdetails(description,mesto);
  }

  @Override
  public Tmesto updateMesto(Long mestoId, String name) {
    return mestaServiceHelper.updateMesto(mestoId, name);
  }


  @Override
  public Tmesto updateMestoCategory(Long bookId, Long newCategoryId) {
    return mestaServiceHelper.updateMestoCategory(bookId, newCategoryId);
  }


  @Override
  public TmestoPicture addMestoPicture(Long mestoId, byte[] bytes, String contentType) throws SQLException {
    return mestaServiceHelper.addMestoPicture(mestoId, bytes, contentType);
  }
}
