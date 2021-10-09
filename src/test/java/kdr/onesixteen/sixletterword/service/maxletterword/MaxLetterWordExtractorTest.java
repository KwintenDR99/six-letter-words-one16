package kdr.onesixteen.sixletterword.service.maxletterword;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MaxLetterWordExtractorTest {

  @InjectMocks
  private MaxLetterWordExtractor maxLetterWordExtractor;

  @Test
  void testExtractMaxLetterWords() {
    List<String> testWords = new ArrayList<>(of("a", "b", "ab", "c", "dc"));

    List<String> returnedWords = maxLetterWordExtractor.extractMaxLetterWords(2, testWords);

    assertEquals(2, returnedWords.size());
    assertEquals("ab", returnedWords.get(0));
    assertEquals("dc", returnedWords.get(1));


    assertEquals(3, testWords.size());
    assertEquals("a", testWords.get(0));
    assertEquals("b", testWords.get(1));
    assertEquals("c", testWords.get(2));
  }
}
