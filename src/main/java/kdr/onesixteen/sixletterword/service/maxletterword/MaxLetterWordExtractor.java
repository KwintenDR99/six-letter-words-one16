package kdr.onesixteen.sixletterword.service.maxletterword;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MaxLetterWordExtractor {

  /**
   * Extracts all words that are maxWordLength long and removes those words from the words list.
   * @return list that contains all words that are maxWordLength long.
   */
  public List<String> extractMaxLetterWords(int maxWordLength, List<String> words) {
    List<String> maxLetterWords = new ArrayList<>();

    Iterator<String> wordsIterator = words.iterator();
    while(wordsIterator.hasNext()) {
      String word = wordsIterator.next();

      if(word.length() == maxWordLength) {
        maxLetterWords.add(word);
        wordsIterator.remove();
      }
    }

    return maxLetterWords;
  }
}
