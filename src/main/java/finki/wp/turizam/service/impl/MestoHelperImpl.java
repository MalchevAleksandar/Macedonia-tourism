package finki.wp.turizam.service.impl;

import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.*;
import finki.wp.turizam.persistence.TmestoDetailsRepository;
import finki.wp.turizam.persistence.TmestoPictureRepository;
import finki.wp.turizam.persistence.TmestoRepository;
import finki.wp.turizam.persistence.CategoryRepository;
import finki.wp.turizam.service.MestoServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Service
public class MestoHelperImpl implements MestoServiceHelper {

  /**
   * TODO: move this into book details helper
   */
  @Autowired
  TmestoPictureRepository mestoPictureRepository;
  private CategoryRepository categoryRepository;
  private TmestoRepository mestoRepository;
  private TmestoDetailsRepository mestodetailsRepository;


  @Autowired
  public MestoHelperImpl(
    CategoryRepository categoryRepository,
    TmestoRepository mestoRepository,
    TmestoDetailsRepository mestodetailsRepository
  ) {
    this.categoryRepository = categoryRepository;
    this.mestoRepository = mestoRepository;
    this.mestodetailsRepository=mestodetailsRepository;

  }

  @Override
  public List<Tmesto> getBooksInCategory(Long categoryId) {
    return null;
  }

  @Override
  public TmestoDetails getBookDetails(Long mestoId) {
    return null;
  }

  @Override
  public Tmesto createMesto(String name, Long categoryId,String description) {
    Tmesto mesto = new Tmesto();
    mesto.name = name;
    mesto.category = categoryRepository.findOne(categoryId);
    mesto.description=description;

    return mestoRepository.save(mesto);
  }
  @Override
  public TmestoDetails createdetails(String detali,Tmesto mestoo){

    TmestoDetails mestod=new TmestoDetails();
    mestod.description=detali;
    mestod.mesto=mestoo;

   return mestodetailsRepository.save(mestod);
  }

    @Override
  public Tmesto updateMesto(Long mestoId, String name) {
    return null;
  }

  @Override
  public Tmesto updateMestoCategory(Long mestoId, Long newCategoryId) {
    return null;
  }

  @Override
  public TmestoPicture addMestoPicture(Long mestoId, byte[] bytes, String contentType) throws SQLException {
    TmestoPicture mestoPicture = new TmestoPicture();
      mestoPicture.mesto = mestoRepository.findOne(mestoId);
    FileEmbeddable picture = new FileEmbeddable();
    picture.contentType = contentType;
    picture.data = new SerialBlob(bytes);
    picture.size = bytes.length;
    picture.fileName = mestoPicture.mesto.name;
    mestoPicture.picture = picture;
    return mestoPictureRepository.save(mestoPicture);
  }

}
