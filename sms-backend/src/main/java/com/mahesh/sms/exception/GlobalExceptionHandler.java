package com.mahesh.sms.exception;

import com.mahesh.sms.dto.response.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Object>>
    handleDuplicate(DuplicateResourceException ex){

        ApiResponse<Object> response =
                ApiResponse.builder()

                        .success(false)

                        .message(ex.getMessage())

                        .timestamp(
                                java.time.LocalDateTime.now().toString())

                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.CONFLICT);
    }

}