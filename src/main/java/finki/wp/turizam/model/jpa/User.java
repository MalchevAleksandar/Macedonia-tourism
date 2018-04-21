package finki.wp.turizam.model.jpa;


import finki.wp.turizam.model.enums.Provider;
import finki.wp.turizam.model.enums.UserType;

import javax.persistence.*;

/**
 * Created by Aleksandar on 25.06.2017.
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {

  public String username;

  public String password;

  public String email;

  @Enumerated(EnumType.STRING)
  public UserType type;

  @Enumerated(EnumType.STRING)
  public Provider provider;

  @OneToOne
  public ContactInfo contactInfo;

}
