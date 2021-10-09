package kdr.onesixteen.sixletterword.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

import kdr.onesixteen.sixletterword.model.WordCombination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class WordCombinationRepositoryIntegrationTest {

  @Autowired
  private WordCombinationRepository wordCombinationRepository;

  @Test
  void testSaveDuplicateWordCombination() {
    WordCombination originalWordCombination = new WordCombination("a", "b");
    WordCombination duplicateWordCombination = new WordCombination("a", "b");

    wordCombinationRepository.save(originalWordCombination);

    assertThrows(DataIntegrityViolationException.class, () -> wordCombinationRepository.save(duplicateWordCombination));
  }
}
