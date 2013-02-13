package com.jason.blog.interfaces.directive.freemarker;

import java.io.IOException;
import java.util.Map;

import com.jason.blog.infrastruture.util.PropertiesUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;


/**
 * 读取配置文件标签，根据key读取配置文件中的value
 * 必填值key
 * eg:<@jason_properties key="photoServer.domain" default="***"/>
 * @author Jason
 * @date 2013-2-13 下午01:37:33
 */
public class PropertiesDirective extends FreemarkerDirectiveSupport{
	
	public final static String KEY_PARAM = "key";
	public final static String DEFAULT_PARAM = "default";
	
	@Override
	protected void doExecute(Environment env, Map<String, ?> params,
			TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		//接受参数
		TemplateScalarModel keyModel = (TemplateScalarModel)params.get(KEY_PARAM);
		String key = null;
		if(super.isNotBlankScalarModel(keyModel)){
			key = keyModel.getAsString();
		}
		TemplateScalarModel defaultModel = (TemplateScalarModel)params.get(DEFAULT_PARAM);
		String defaultValue = null;
		if(super.isNotBlankScalarModel(defaultModel)){
			defaultValue = defaultModel.getAsString();
		}
		//取数据
		String value = PropertiesUtils.getEntryDefaultValue(key, defaultValue);
		env.getOut().write(value);
	}
	
	@Override
	protected boolean beforeExecute(Environment env, Map<String, ?> params,
			TemplateModel[] loopVars) {
		if(params.containsKey(KEY_PARAM)){
			return true;
		}else{
			super.logger.debug(String.format("Must have this %s", KEY_PARAM));
		}
		return false;
	}




}
