package com.jason.blog.interfaces.support;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public abstract class ControllerSupport extends MultiActionController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * @param success
	 */
	public final void success(String success) {
		FlashModel.setSuccessMessage(success);
	}

	/**
	 * @param error
	 */
	public final void error(String error) {
		FlashModel.setErrorMessage(error);
	}

	/**
	 * @param warning
	 */
	public final void warning(String warning) {
		FlashModel.setWarningMessage(warning);
	}

	/**
	 * @param info
	 */
	public final void info(String info) {
		FlashModel.setInfoMessage(info);
	}

	/**
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setIgnoreInvalidFields(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), false));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.multiaction.MultiActionController#bind(javax.servlet.http.HttpServletRequest,
	 * java.lang.Object)
	 */
	@Override
	protected void bind(HttpServletRequest request, Object command) throws Exception {
		super.bind(request, command);
	}
}
