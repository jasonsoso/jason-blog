package com.jason.blog.interfaces.directive.freemarker;

import java.io.IOException;
import java.util.Map;


import com.jason.blog.domain.PhotoConf.ThumbType;
import com.jason.blog.infrastruture.util.FilesHelper;
import com.jason.blog.infrastruture.util.PropertiesUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

/**
 * UserIcon URL Directive(Tags)
 * eg:<img src="<@jason_user_icon path="${user.photo}" type="130_130"/>">
 * @author Jason
 * @date 2013-2-13 下午01:03:06
 */
public class UserIconDirective extends FreemarkerDirectiveSupport{
	
	public final static String TYPE_PARAM = "type";
	public final static String PATH_PARAM = "path";
	
	@Override
	protected void doExecute(Environment env, Map<String, ?> params,
			TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		TemplateScalarModel typeModel = (TemplateScalarModel)params.get(TYPE_PARAM);
		TemplateScalarModel pathModel = (TemplateScalarModel)params.get(PATH_PARAM);
		String type = ThumbType.THUMB_SOURCE.asType();//默认源文件
		if(super.isNotBlankScalarModel(typeModel)){
			type = typeModel.getAsString();
		}
		String path = "resources/images/default.jpg";
		if(super.isNotBlankScalarModel(pathModel)){
			path = pathModel.getAsString();
		}
		String truefileName = FilesHelper.insertStringForPath(path, type);
		String photoServerDomain = PropertiesUtils.getEntryValue("photoServer.domain");
		
		StringBuilder sb = new StringBuilder();
		sb.append(photoServerDomain).append(truefileName);
		
		env.getOut().write(sb.toString());
		/*if(null!=body){
			body.render(env.getOut());
		}*/
	}
	
	@Override
	protected boolean beforeExecute(Environment env, Map<String, ?> params,
			TemplateModel[] loopVars) {
		if(params.containsKey(PATH_PARAM)){
			return true;
		}else{
			super.logger.debug(String.format("Must have this %s", PATH_PARAM));
		}
		return false;
	}




}
