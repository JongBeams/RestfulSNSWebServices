package io.jongbeom.springboot.intellij.restfulwebsnsservices.exception;

import io.jongbeom.springboot.intellij.restfulwebsnsservices.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

//ExceptionHandler를 선언하는 클래스
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //전역 예외 처리기
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request){ //HTTP 응답을 만들어 반환
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),                                // 에러 발생 시간
                ex.getMessage(),                                // 에러 메시지
                request.getDescription(false));    // 요청 경로
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //404 에러 관련
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request){ //HTTP 응답을 만들어 반환
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),                                // 에러 발생 시간
                ex.getMessage(),                                // 에러 메시지
                request.getDescription(false));    // 요청 경로
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }


}
