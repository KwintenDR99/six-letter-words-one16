package kdr.onesixteen.sixletterword.service.maxletterword;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DuplicateWordsRemoverTest {

  @InjectMocks
  private DuplicateWordsRemover duplicateWordsRemover;

  @Test
  void testRemoveDuplicateWords() {
    List<String> testWords = of("wordA", "wordB", "wordC", "wordB", "wordA", "wordD");

    List<String> returnedWords = duplicateWordsRemover.removeDuplicateWords(testWords);

    assertEquals(4, returnedWords.size());
    assertTrue(returnedWords.contains("wordA"));
    assertTrue(returnedWords.contains("wordB"));
    assertTrue(returnedWords.contains("wordC"));
    assertTrue(returnedWords.contains("wordD"));
  }
}
