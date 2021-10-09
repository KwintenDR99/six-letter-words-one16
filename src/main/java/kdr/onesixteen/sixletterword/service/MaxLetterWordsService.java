package kdr.onesixteen.sixletterword.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import kdr.onesixteen.sixletterword.model.WordCombination;
import kdr.onesixteen.sixletterword.service.exception.FileContainsNoWordsException;
import kdr.onesixteen.sixletterword.service.file.FileConverter;
import kdr.onesixteen.sixletterword.service.maxletterword.DuplicateWordsRemover;
import kdr.onesixteen.sixletterword.service.maxletterword.MaxLetterWordCombiner;
import kdr.onesixteen.sixletterword.service.maxletterword.MaxLetterWordExtractor;
import kdr.onesixteen.sixletterword.service.maxletterword.WordOverlapFinder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class MaxLetterWordsService {

  private final FileConverter fileConverter;
  private final DuplicateWordsRemover duplicateWordsRemover;
  private final MaxLetterWordExtractor maxLetterWordExtractor;
  private final MaxLetterWordCombiner maxLetterWordCombiner;
  private final WordOverlapFinder wordOverlapFinder;
  private final WordCombinationService wordCombinationService;

  public List<String> handleMaxLetterWordsFileUpload(int maxWordLength, MultipartFile file) {
    List<String> words = duplicateWordsRemover.removeDuplicateWords(fileConverter.convertFile(file));

    if (words.isEmpty()) {
      throw new FileContainsNoWordsException("No words were found in the provided file.");
    }

    List<String> sixLetterWords = maxLetterWordExtractor.extractMaxLetterWords(maxWordLength, words);
    List<WordCombination> sixLetterWordCombinations = maxLetterWordCombiner.combineWordsToMaxLetterWords(maxWordLength, words);
    List<WordCombination> overlapWordCombinations = wordOverlapFinder.findOverlaps(sixLetterWords, sixLetterWordCombinations);

    wordCombinationService.saveAllWordCombinations(overlapWordCombinations);

    return overlapWordCombinations.stream().map(WordCombination::toString).collect(toList());
  }
}
