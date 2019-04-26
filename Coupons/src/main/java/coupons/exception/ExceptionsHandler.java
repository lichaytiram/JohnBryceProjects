package coupons.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler
	public void handleError(Throwable throwable, HttpServletResponse response) {

		if (throwable instanceof ApplicationException) {

			ApplicationException myException = (ApplicationException) throwable;

			if (myException.getIsCritical())
				myException.printStackTrace();

		}

	}

}
