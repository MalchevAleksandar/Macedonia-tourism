package finki.wp.turizam.service;

import finki.wp.turizam.model.jpa.User;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface UserService {

  User createCustomer(String username, String password);

  User createAdmin(String username, String password);


}
