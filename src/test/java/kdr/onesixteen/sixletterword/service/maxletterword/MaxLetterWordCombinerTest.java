package kdr.onesixteen.sixletterword.service.maxletterword;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import kdr.onesixteen.sixletterword.model.WordCombination;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MaxLetterWordCombinerTest {

  @InjectMocks
  private MaxLetterWordCombiner maxLetterWordCombiner;

  @Test
  void testCombineWordsToMaxLetterWords() {
    List<String> testWords = of("a", "b", "ab", "c", "dc");

    List<WordCombination> returnedWordCombinations = maxLetterWordCombiner.combineWordsToMaxLetterWords(2, testWords);

    assertEquals(9, returnedWordCombinations.size());
    assertEquals("aa", returnedWordCombinations.get(0).getCombinedWord());
    assertEquals("ab", returnedWordCombinations.get(1).getCombinedWord());
    assertEquals("ba", returnedWordCombinations.get(2).getCombinedWord());
    assertEquals("ac", returnedWordCombinations.get(3).getCombinedWord());
    assertEquals("ca", returnedWordCombinations.get(4).getCombinedWord());
    assertEquals("bb", returnedWordCombinations.get(5).getCombinedWord());
    assertEquals("bc", returnedWordCombinations.get(6).getCombinedWord());
    assertEquals("cb", returnedWordCombinations.get(7).getCombinedWord());
    assertEquals("cc", returnedWordCombinations.get(8).getCombinedWord());
  }
}
