package kdr.onesixteen.sixletterword.service.file;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;
import kdr.onesixteen.sixletterword.service.exception.FileUnreadableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
public class PlainTextFileReaderTest {

  @Mock
  private MockMultipartFile multipartFileMock;

  @InjectMocks
  private PlainTextFileReader plainTextFileReader;

  @Test
  void testReadFile() {
    MockMultipartFile testFile = new MockMultipartFile("data", "filename.txt", "text/plain", "a line\nanother line".getBytes(UTF_8));

    List<String> returnedLines = plainTextFileReader.readFile(testFile);

    assertEquals(2, returnedLines.size());
    assertEquals("a line", returnedLines.get(0));
    assertEquals("another line", returnedLines.get(1));
  }

  @Test
  void testReadFileNotReadable() throws IOException {
    when(multipartFileMock.getInputStream()).thenThrow(FileUnreadableException.class);

    assertThrows(FileUnreadableException.class, () -> plainTextFileReader.readFile(multipartFileMock));
  }
}
