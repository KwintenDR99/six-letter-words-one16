package kdr.onesixteen.sixletterword.service;

import static java.lang.String.format;

import java.util.List;
import kdr.onesixteen.sixletterword.model.WordCombination;
import kdr.onesixteen.sixletterword.repository.WordCombinationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Log
@AllArgsConstructor
public class WordCombinationService {

  private final WordCombinationRepository wordCombinationRepository;

  public void saveAllWordCombinations(List<WordCombination> wordCombinations) {
    wordCombinations.forEach(wc -> {
      try {
        wordCombinationRepository.save(wc);
      } catch(DataIntegrityViolationException ex) {
        log.info(format("Word combination %s is already present in the database.", wc));
      }
    });
  }

}
