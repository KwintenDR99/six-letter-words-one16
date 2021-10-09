package kdr.onesixteen.sixletterword.service.file;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface FileReader {

  List<String> readFile(MultipartFile file);
}
