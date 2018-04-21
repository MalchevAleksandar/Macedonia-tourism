package finki.wp.turizam.persistence;

import finki.wp.turizam.model.jpa.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

  List<Category> findByParentIsNull();

  List<Category> findByParentId(Long categoryId);

  List<Category> findByNameNotNull();

}
