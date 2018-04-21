package finki.wp.turizam.persistence;

import finki.wp.turizam.model.jpa.TmestoPicture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Repository
public interface TmestoPictureRepository extends CrudRepository<TmestoPicture, Long> {

  TmestoPicture findByMestoId(Long id);
}
