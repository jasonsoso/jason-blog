<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@include file="/common/common-header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<form:form method="post" modelAttribute="userInfo">
<input type="hidden" name="_method" value="${_method}"></input>
 <!--content start-->
<div class="content">
<div class="table">
<div class="contentNav"><h1><span class="allIco2 ico_6"></span>用户信息录入</h1></div>
 <div class="tips"><img src="${ctx}/resources/images/tips.gif" align="left" />所有带有<span class="red">*</span>为必填项</div>
<div class="info border">

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tbody>
<tr>
<td width="240" align="right" nowrap="nowrap"><span class="red">*</span>账号：</td>
<td colspan="2">
	<form:input path="username" cssClass="input5 fontMar"/>
</td>
</tr>
<tr>
<td width="240" align="right" nowrap="nowrap">真实姓名：</td>
<td colspan="2">
	<form:input path="truename" cssClass="input5 fontMar"/>
</td>
</tr>
<tr>
<td width="240" align="right" nowrap="nowrap"><span class="red">*</span>密码：</td>
<td colspan="2">
	<form:password path="password" class="input5 fontMar" />
</td>
</tr>
<tr>
<td width="240" align="right" nowrap="nowrap"><span class="red">*</span>密码确认：</td>
<td colspan="2">
	<input id="confirmPassword" name="confirmPassword" type="password" value="${userInfo.password}" class="input5 fontMar"/>
</td>
</tr>
<tr>
<td width="240" align="right" nowrap="nowrap"><span class="red">*</span>Email：</td>
<td colspan="2">
	<form:input path="email" cssClass="input5 fontMar"/>
</td>
</tr>
<tr>
<td width="240" align="right" nowrap="nowrap">角色：</td>
<td colspan="2">
	&nbsp;
	<c:forEach var="role" items="${roleList }">
		<form:checkbox path="roleMap[${role.id }]" value="${role.id}" label="${role.name }"/>
	</c:forEach>
</td>
</tr>
</tbody>
</table>
</div>
<div class="contactBbutton">
<input id="ok" type="submit" value="提交" class="button1" />&nbsp;
<input id=“back” type="button" value="返回" class="button1" onclick="javascript:history.go(-1);"/>
</div>
  
</div></div>
</form:form>
</body>
</html>
