package com.agiledots.springboot.security.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/***
 * 统一的异常处理类
 * 
 * @author ZHONG
 *
 */

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(Exception exception, WebRequest request) {
		// error页面
		ModelAndView modelAndView = new ModelAndView("/common/error");
		modelAndView.addObject("errorMessage", exception.getMessage());
		modelAndView.addObject("stackTrace", exception.getStackTrace());
		modelAndView.addObject("exception", exception);
		modelAndView.addObject("url", request.getContextPath());
		return modelAndView;

	}
}
