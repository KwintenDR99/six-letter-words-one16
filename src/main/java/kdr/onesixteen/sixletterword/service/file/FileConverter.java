package kdr.onesixteen.sixletterword.service.file;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

import java.util.List;
import kdr.onesixteen.sixletterword.service.exception.FileExtensionNotSupportedException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class FileConverter {

  private final static String PLAIN_TEXT_FILE_EXTENSION = ".txt";

  private final FileReader plainTextFileReader;

  public List<String> convertFile(MultipartFile file) {
    String fileExtension = requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));

    if (PLAIN_TEXT_FILE_EXTENSION.equals(fileExtension)) {
      return plainTextFileReader.readFile(file);
    } else {
      throw new FileExtensionNotSupportedException(format("The file extension %s is not supported.", fileExtension));
    }
  }
}
