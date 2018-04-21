package finki.wp.turizam.model.jpa;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;


@Entity
@Table(name = "turisticki_mesta")
@Indexed
@AnalyzerDef(name = "emtAnalyser", tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
    @TokenFilterDef(factory = LowerCaseFilterFactory.class)
  })
public class Tmesto extends BaseEntity {

  @Field(index = Index.YES, store = Store.NO, analyze = Analyze.YES)
  @Analyzer(definition = "emtAnalyser")
  @Boost(2f)
  public String name;

  @Column(length = 5000)
  public String description;


  @ManyToOne
  @IndexedEmbedded
  public Category category;


}
