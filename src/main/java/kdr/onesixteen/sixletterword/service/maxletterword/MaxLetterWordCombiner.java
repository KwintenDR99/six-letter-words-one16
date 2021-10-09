package kdr.onesixteen.sixletterword.service.maxletterword;

import java.util.ArrayList;
import java.util.List;
import kdr.onesixteen.sixletterword.model.WordCombination;
import org.springframework.stereotype.Service;

@Service
public class MaxLetterWordCombiner {

  public List<WordCombination> combineWordsToMaxLetterWords(int maxWordLength, List<String> words) {
    List<WordCombination> wordCombinations = new ArrayList<>();

    for(int i = 0; i < words.size(); i++) {
      String firstWord = words.get(i);

      for(int y = i; y < words.size(); y++) {
        String secondWord = words.get(y);

        if(firstWord.concat(secondWord).length() == maxWordLength) {
          wordCombinations.add(new WordCombination(firstWord, secondWord));

          if(!firstWord.equals(secondWord)) {
            wordCombinations.add(new WordCombination(secondWord, firstWord));
          }
        }
      }
    }

    return wordCombinations;
  }

}
