package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,value = HttpStatus.BAD_REQUEST)
public class CompagnonException extends RuntimeException {

}
