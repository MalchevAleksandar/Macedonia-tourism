package finki.wp.turizam.persistence;

import finki.wp.turizam.model.jpa.Tmesto;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface TmestoRepository extends CrudRepository<Tmesto, Long>,
        JpaSpecificationExecutor<Tmesto> {

    Tmesto save(Tmesto tmesto);


}
