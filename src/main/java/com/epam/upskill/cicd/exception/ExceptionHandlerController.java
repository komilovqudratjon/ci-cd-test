package com.epam.upskill.cicd.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @date: 20 October 2023 $
 * @time: 6:54 PM 33 $
 * @author: Qudratjon Komilov
 */
@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ExceptionHandlerController {

    // Handling specific exception
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        // Logging the exception
        log.error("Entity not found exception: ", ex);

        // Preparing error details
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("error", "Entity Not Found");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));  // false to exclude "uri=" prefix

        // Return response entity
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

     @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex, WebRequest request) {
        // Logging the exception
        log.error("Internal server error: ", ex);

        // Preparing error details
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("error", "Internal Server Error");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));

        // Return response entity
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
