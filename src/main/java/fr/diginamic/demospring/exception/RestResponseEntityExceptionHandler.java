package fr.diginamic.demospring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
	@ExceptionHandler({ AnomalieException.class })
	protected ResponseEntity<String> transformerAnomalie(AnomalieException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());

	}
}
