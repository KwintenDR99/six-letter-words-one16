package kdr.onesixteen.sixletterword.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "WordCombinations", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"wordOne", "wordTwo"})
})
@Data
@NoArgsConstructor
public class WordCombination {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private String wordOne;
  private String wordTwo;

  public WordCombination(String wordOne, String wordTwo) {
    this.wordOne = wordOne;
    this.wordTwo = wordTwo;
  }

  public String getCombinedWord() {
    return this.wordOne.concat(this.wordTwo);
  }

  @Override
  public String toString() {
    return String.format("%s+%s=%s", this.wordOne, this.wordTwo, this.getCombinedWord());
  }
}
