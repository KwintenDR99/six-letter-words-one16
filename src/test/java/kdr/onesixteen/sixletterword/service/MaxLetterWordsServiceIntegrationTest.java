package kdr.onesixteen.sixletterword.service;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import kdr.onesixteen.sixletterword.service.exception.FileContainsNoWordsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
public class MaxLetterWordsServiceIntegrationTest {

  @Autowired
  private MaxLetterWordsService maxLetterWordsService;

  @Test
  void testHandleMaxLetterWordFileUpload() {
    MockMultipartFile testFile = new MockMultipartFile("data", "filename.txt", "text/plain", "a\nb\nab\ndc\na\nd\ndcd\npolp\nc\npo".getBytes(UTF_8));

    List<String> returnedCombinations = maxLetterWordsService.handleMaxLetterWordsFileUpload(2, testFile);

    assertEquals(2, returnedCombinations.size());
    assertTrue(returnedCombinations.contains("a+b=ab"));
    assertTrue(returnedCombinations.contains("d+c=dc"));
  }

  @Test
  void testHandleMaxLetterWordFileUploadEmptyFile() {
    MockMultipartFile testFile = new MockMultipartFile("data", "filename.txt", "text/plain", "".getBytes(UTF_8));

    assertThrows(FileContainsNoWordsException.class, () -> maxLetterWordsService.handleMaxLetterWordsFileUpload(2, testFile));
  }
}
