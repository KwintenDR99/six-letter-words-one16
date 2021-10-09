package kdr.onesixteen.sixletterword.controller;

import java.util.List;
import kdr.onesixteen.sixletterword.service.MaxLetterWordsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class SixLetterWordsController {

  private final static int MAX_WORD_LENGTH = 6;

  private final MaxLetterWordsService sixLetterWordService;

  @PostMapping(value = "/file")
  public List<String> fileUpload(@RequestParam("file") MultipartFile file) {
    return sixLetterWordService.handleMaxLetterWordsFileUpload(MAX_WORD_LENGTH, file);
  }

}
