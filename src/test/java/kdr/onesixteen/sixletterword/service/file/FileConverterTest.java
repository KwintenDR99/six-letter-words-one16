package kdr.onesixteen.sixletterword.service.file;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import kdr.onesixteen.sixletterword.service.exception.FileExtensionNotSupportedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
public class FileConverterTest {

  @Mock
  private FileReader plainTextFileReader;

  @InjectMocks
  private FileConverter fileConverter;

  @Test
  void testConvertFile() {
    MockMultipartFile testFile = new MockMultipartFile("data", "filename.txt", "text/plain", "a line\nanother line".getBytes(UTF_8));

    fileConverter.convertFile(testFile);

    verify(plainTextFileReader).readFile(testFile);
  }

  @Test
  void testConvertFileNotSupportedExtension() {
    MockMultipartFile testFile = new MockMultipartFile("data", "filename.json", "application/json", "some content".getBytes(UTF_8));

    assertThrows(FileExtensionNotSupportedException.class, () -> fileConverter.convertFile(testFile));
  }
}
