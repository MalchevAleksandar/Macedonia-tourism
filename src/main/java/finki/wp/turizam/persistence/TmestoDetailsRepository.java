package finki.wp.turizam.persistence;

import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.model.jpa.TmestoDetails;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Aleksandar on 28.08.2017.
 */
public interface TmestoDetailsRepository extends CrudRepository<TmestoDetails, Long>,
        JpaSpecificationExecutor<TmestoDetails> {

    TmestoDetails save(TmestoDetails tmesto);
}
