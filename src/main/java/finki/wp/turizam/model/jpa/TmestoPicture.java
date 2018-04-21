package finki.wp.turizam.model.jpa;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Aleksandar on 25.06.2017.
 */
@Entity
@Table(name = "tmesto_pictures")
public class TmestoPicture extends BaseEntity {

  @Embedded
  public FileEmbeddable picture;

  @ManyToOne
  public Tmesto mesto;

}
