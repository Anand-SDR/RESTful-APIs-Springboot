package com.anand.restapi.exception;
import com.anand.restapi.dto.ApiResponse;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<ApiResponse<Map<String,String>>> handleValidation(MethodArgumentNotValidException exception){
  Map<String,String> errors=new LinkedHashMap<>();
  exception.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
  return ResponseEntity.badRequest().body(new ApiResponse<>(false,"Validation failed",errors,Instant.now()));
 }
 @ExceptionHandler(Exception.class)
 public ResponseEntity<ApiResponse<Void>> handleUnexpected(Exception exception){ return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.failure("An unexpected error occurred")); }
}
