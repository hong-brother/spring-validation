package com.hsnam.validation.web;

import com.hsnam.validation.model.ErrorModel;
import com.hsnam.validation.model.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
@RestController
public class AdviceController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseMessage> processValidationError(MethodArgumentNotValidException exception) {
        log.info("error");
        log.error(exception.getMessage());
        ResponseMessage res = ResponseMessage.builder().build();
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();

        res.setMessage("입력값이 올바르지 않습니다.");
        List<ErrorModel> errorModelList = errors.parallelStream().map(error-> ErrorModel.builder()
                .reason(error.getDefaultMessage())
                .field(error.getField())
                .value(error.getRejectedValue().toString()).build()).collect(Collectors.toList());

        res.setError(errorModelList);
        return ResponseEntity.ok(res);
    }
}
