package finki.wp.turizam.security;

import finki.wp.turizam.model.enums.UserType;
import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.context.SecurityContext;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public class ClientBookPolicy implements Policy {


  @Override
  public boolean shouldApply(SecurityContext context, JpaSpecificationExecutor repo, Class repoGenericType) {

    boolean applicableForRepository = repoGenericType.isAssignableFrom(Tmesto.class);


    if (context == null
      || context.getAuthentication() == null
      || context.getAuthentication().isAuthenticated() == false)
      return false;

    User user = (User) context.getAuthentication().getPrincipal();

    boolean applicableForUser = user.type.equals(UserType.ROLE_CUSTOMER);

    return applicableForUser && applicableForRepository;
  }

  @Override
  public Specification getSpecification() {

    return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(
      root.get("quantityInStock"),
      0
    );

  }
}
