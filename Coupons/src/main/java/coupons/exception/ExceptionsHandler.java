package coupons.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(Throwable.class)
	public void handleError(Throwable throwable, HttpServletResponse response) throws Throwable {

		if (throwable instanceof ApplicationException) {

			ApplicationException myException = (ApplicationException) throwable;

			if (myException.getIsCritical())
				myException.printStackTrace();

		}

		throw new Throwable();

	}

}
