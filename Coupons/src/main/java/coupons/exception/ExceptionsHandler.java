package coupons.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import coupons.beans.ErrorBean;

@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(Throwable.class)
	public ErrorBean handleError(Throwable throwable, HttpServletResponse response) throws Throwable {

		if (throwable instanceof ApplicationException) {

			ApplicationException myException = (ApplicationException) throwable;

			if (myException.getIsCritical())
				myException.printStackTrace();

			return new ErrorBean(501, myException.getErrorType(), myException.getMessage());
		}

		return new ErrorBean();

	}

}
