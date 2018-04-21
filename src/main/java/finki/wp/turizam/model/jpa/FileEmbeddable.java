package finki.wp.turizam.model.jpa;

import javax.persistence.Embeddable;
import java.sql.Blob;

/**
 * Created by Aleksandar on 25.06.2017.
 */
@Embeddable
public class FileEmbeddable {

  public Blob data;

  public String fileName;

  public String contentType;

  public int size;
}
