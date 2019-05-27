package coupons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import coupons.beans.ErrorBean;
import coupons.enums.ErrorType;

@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorBean> handleError(ApplicationException e) {

		if (e.getIsCritical())
			e.printStackTrace();

		ErrorBean errorBean = new ErrorBean(500, e.getErrorType(), e.getMessage());

		return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ErrorBean> handleError(Throwable e) {

		e.printStackTrace();

		ErrorBean errorBean = new ErrorBean(600, ErrorType.INTERNAL_SERVER_ERROR,
				ErrorType.INTERNAL_SERVER_ERROR.getMessage());

		return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
