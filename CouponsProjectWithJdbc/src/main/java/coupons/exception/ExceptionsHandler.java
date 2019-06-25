package coupons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import coupons.beans.ErrorBean;
import coupons.enums.ErrorType;

/**
 * This class handling with exceptions
 * 
 * @author Lichay
 *
 */
@RestControllerAdvice
public class ExceptionsHandler {

	/**
	 * @param e Receive an applicationException
	 * @return This function return a ResponseEntity<ErrorBean>
	 */
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorBean> handleError(ApplicationException e) {

		if (e.getIsCritical())
			e.printStackTrace();

		ErrorBean errorBean = new ErrorBean(500, e.getErrorType(), e.getMessage());

		return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * @param e Receive a throwable
	 * @return This function return a ResponseEntity<ErrorBean>
	 */
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ErrorBean> handleError(Throwable e) {

		e.printStackTrace();

		ErrorBean errorBean = new ErrorBean(600, ErrorType.INTERNAL_SERVER_ERROR,
				ErrorType.INTERNAL_SERVER_ERROR.getMessage());

		return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
