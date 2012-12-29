package com.jason.blog.interfaces.support;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.jason.blog.interfaces.filter.FlashModel;
import com.jason.blog.interfaces.filter.FlashModel.Message;
import com.jason.blog.interfaces.filter.FlashModel.MessageType;


public abstract class ControllerSupport extends MultiActionController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Redirect Success
	 * @param success
	 */
	public final void success(String success) {
		FlashModel.setSuccessMessage(success);
	}

	/**
	 * Redirect Error
	 * @param error
	 */
	public final void error(String error) {
		FlashModel.setErrorMessage(error);
	}
	/**
	 * Forward Error
	 * @param error
	 * @param model
	 */
	public final void error(Model model,String error) {
		model.addAttribute(FlashModel.MESSAGE_KEY,new Message(MessageType.error, error));
	}

	/**
	 * Redirect Warning
	 * @param warning
	 */
	public final void warning(String warning) {
		FlashModel.setWarningMessage(warning);
	}

	/**
	 * Redirect Info
	 * @param info
	 */
	public final void info(String info) {
		FlashModel.setInfoMessage(info);
	}

	/**
	 * Binder Date
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
