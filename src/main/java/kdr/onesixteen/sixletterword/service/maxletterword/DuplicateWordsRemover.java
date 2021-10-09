package kdr.onesixteen.sixletterword.service.maxletterword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DuplicateWordsRemover {

  public List<String> removeDuplicateWords (List<String> words) {
     return new ArrayList<>(new HashSet<>(words));
  }

}
