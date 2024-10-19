package com.excelia.spaceships.shared;

import com.excelia.spaceships.application.exceptions.SpaceshipNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private static final String PROBLEM_MESSAGE = "A problem has occurred '{}'. Request info: HTTP Method = {}, URI = {}";

    @ExceptionHandler(SpaceshipNotFoundException.class)
    public ProblemDetail spaceshipNotFoundExceptionHandler(HttpServletRequest request, Exception ex) {
        logProblem(request, ex);
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail fallbackExceptionHandler(HttpServletRequest request, Exception ex) {
        logProblem(request, ex);
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private static void logProblem(HttpServletRequest request, Exception ex) {
        log.warn(PROBLEM_MESSAGE, ex.getMessage(), request.getMethod(), request.getRequestURI());
    }

}