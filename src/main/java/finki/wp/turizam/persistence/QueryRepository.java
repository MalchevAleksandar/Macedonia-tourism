package finki.wp.turizam.persistence;

import finki.wp.turizam.model.jpa.Tmesto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */

public interface QueryRepository  {

  Page<Tmesto> findMestaByCategoryPaged(Long categoryId, int page, int pageSize);

  Page<Tmesto> findPromotedBooks(int page, int pageSize);

   Iterable<Tmesto> findsite();

//  Page<Tmesto> findsite(Pageable p);

//  Page<Tmesto> findAll(Pageable p);


}
