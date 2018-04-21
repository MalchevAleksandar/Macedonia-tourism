package finki.wp.turizam.model.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Aleksandar on 25.06.2017.
 */
@Entity
@Table(name = "contact_info")
public class ContactInfo extends BaseEntity {

  public String firstName;

  public String lastName;

  public String phone;


}
