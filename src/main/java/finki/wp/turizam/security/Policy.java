package finki.wp.turizam.security;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.context.SecurityContext;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface Policy<T> {

  boolean shouldApply(SecurityContext context, JpaSpecificationExecutor repo, Class repoGenericType);

  Specification getSpecification();


}
