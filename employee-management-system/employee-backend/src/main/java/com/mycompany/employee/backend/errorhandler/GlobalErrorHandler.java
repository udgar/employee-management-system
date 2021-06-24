package com.mycompany.employee.backend.errorhandler;

import javax.security.auth.login.AccountNotFoundException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity<?> handleUnauthorize(Exception exception) {
        return ResponseEntity.status(403).body("The user is not authorize");
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<?> handleUnAuthenticated(Exception exception) {
        return ResponseEntity.status(401).body("The user is not authorize");
    }

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNotFound(Exception exception) {
        return ResponseEntity.status(404).body("The user is not authorize");
    }
    
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleInternalServer(Exception exception){
        return ResponseEntity.status(500).body("Internal server has occured in the backend");
    }

}
