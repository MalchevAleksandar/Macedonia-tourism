package finki.wp.turizam.persistence;

import java.util.List;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface SearchRepository {

  <T> List<T> searchKeyword(Class<T> entityClass, String text, String... fields);

  <T> List<T> searchPhrase(Class<T> entityClass, String text, String... fields);
}
