package finki.wp.turizam.model.jpa;

import javax.persistence.*;

/**
 * Created by Aleksandar on 25.06.2017.
 */
@Entity
@Table(name = "tmesto_details")
public class TmestoDetails extends BaseEntity {

  @Column(length = 10000)
  public String description;

  @OneToOne
  public Tmesto mesto;

  @Embedded
  public FileEmbeddable downloadFile;


}
