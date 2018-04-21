package finki.wp.turizam.events;

import finki.wp.turizam.model.jpa.User;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public class UserRegisteredEvent extends ApplicationEvent {
  public UserRegisteredEvent(User user) {
    super(user);
  }

  public User getUser() {
    return (User) getSource();
  }

}
