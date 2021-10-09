package kdr.onesixteen.sixletterword.service;

import static java.util.List.of;

import java.util.List;
import kdr.onesixteen.sixletterword.model.WordCombination;
import kdr.onesixteen.sixletterword.repository.WordCombinationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordCombinationServiceTest {

  @Mock
  private WordCombinationRepository wordCombinationRepository;

  @InjectMocks
  private WordCombinationService wordCombinationService;

  @Test
  void testSaveAll() {
    List<WordCombination> testWordCombinations = of(new WordCombination("a", "b"),
        new WordCombination("b", "a"),
        new WordCombination("b", "c"),
        new WordCombination("c", "b"));

    wordCombinationService.saveAllWordCombinations(testWordCombinations);

    testWordCombinations.forEach(wc -> Mockito.verify(wordCombinationRepository).save(wc));
  }

}
