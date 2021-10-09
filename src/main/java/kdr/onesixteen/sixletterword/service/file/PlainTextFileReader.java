package kdr.onesixteen.sixletterword.service.file;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import kdr.onesixteen.sixletterword.service.exception.FileUnreadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PlainTextFileReader implements FileReader {

  @Override
  public List<String> readFile(MultipartFile file) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), UTF_8))) {
      return br.lines().collect(toList());
    } catch (IOException ex) {
      throw new FileUnreadableException("The file could not be read.", ex);
    }
  }
}
