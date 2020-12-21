package com.example.simplecrudproject.exception;

import com.example.simplecrudproject.view.ResultView;
import org.apache.coyote.Response;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;

/**
 * Перехватчик исключений
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * Обрабатывает исключение {@link NoResultException}
     * @param e исключение
     * @return {@link ResultView} с сообщением об ошибке
     */
    @ExceptionHandler(value = {NoResultException.class})
    public ResponseEntity<Object> handleNoResultException(NoResultException e) {
        ResultView resultView = new ResultView();
        resultView.result = e.getMessage();
        return  new ResponseEntity<>(resultView, HttpStatus.NOT_FOUND);
    }

    /**
     * Обрабатывает исключение {@link DataIntegrityViolationException}
     * @param e исключение
     * @return {@link ResultView} c сообщением об ошибке
     */
    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleNotUniqueException(DataIntegrityViolationException e) {
        ResultView resultView = new ResultView();
        resultView.result = "item with current name is already exists";
        return  new ResponseEntity<>(resultView, HttpStatus.BAD_REQUEST);
    }
}
