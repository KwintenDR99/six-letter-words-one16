package kdr.onesixteen.sixletterword.controller.exception;

import static java.util.logging.Level.SEVERE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import kdr.onesixteen.sixletterword.service.exception.FileContainsNoWordsException;
import kdr.onesixteen.sixletterword.service.exception.FileExtensionNotSupportedException;
import kdr.onesixteen.sixletterword.service.exception.FileUnreadableException;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log
public class ControllerExceptionHandler {

  @ExceptionHandler({FileContainsNoWordsException.class, FileExtensionNotSupportedException.class, FileUnreadableException.class})
  public ResponseEntity<ClientErrorInfo> onServiceBadRequest(Exception ex) {
    log.log(SEVERE, ex.getMessage());
    return new ResponseEntity<>(ClientErrorInfo.builder().errorStatus(BAD_REQUEST.toString()).errorMessage(ex.getMessage()).build(), BAD_REQUEST);
  }
}
