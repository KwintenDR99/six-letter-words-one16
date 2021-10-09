package kdr.onesixteen.sixletterword.service.maxletterword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import kdr.onesixteen.sixletterword.model.WordCombination;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordOverlapFinderTest {

  @InjectMocks
  private WordOverlapFinder wordOverlapFinder;

  @Test
  void testFindOverlaps() {
    List<String> testWords = List.of("ab", "cd", "po");
    List<WordCombination> testWordCombinations = List.of(new WordCombination("a", "b"),
        new WordCombination("b", "a"),
        new WordCombination("d", "e"),
        new WordCombination("e", "d"),
        new WordCombination("p", "o"),
        new WordCombination("o", "p"));

    List<WordCombination> returnedWordCombinations = wordOverlapFinder.findOverlaps(testWords, testWordCombinations);

    assertEquals(2, returnedWordCombinations.size());
    assertEquals("ab", returnedWordCombinations.get(0).getCombinedWord());
    assertEquals("po", returnedWordCombinations.get(1).getCombinedWord());
  }
}
