package kdr.onesixteen.sixletterword.service.maxletterword;

import static java.util.stream.Collectors.toList;

import java.util.List;
import kdr.onesixteen.sixletterword.model.WordCombination;
import org.springframework.stereotype.Service;

@Service
public class WordOverlapFinder {

  public List<WordCombination> findOverlaps(List<String> words, List<WordCombination> wordCombinations) {
      return wordCombinations.stream().filter(wc -> words.contains(wc.getCombinedWord())).collect(toList());
  }
}
