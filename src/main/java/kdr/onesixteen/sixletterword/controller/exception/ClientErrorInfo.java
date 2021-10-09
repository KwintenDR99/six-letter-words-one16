package kdr.onesixteen.sixletterword.controller.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientErrorInfo {

  private String errorStatus;
  private String errorMessage;
}
