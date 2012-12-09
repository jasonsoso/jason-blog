<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/taglibs.jsp"%>
<%@include file="/common/common-header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	$(function(){
		$("#add").click(function(){
			location.href = "${ctx}/security/user/create";
		});
		
		$("#del").click(function(){
			var items = youboy.select();
			if(items && items.length > 0){
				$('input[name="_method"]').remove();
				$("#myForm").attr("action", "${ctx}/security/user/delete")
							.attr("method","post")
							.append('<input type="hidden" name="_method" value="DELETE" />')
							.submit();
				
				return;
			}
			
			alert("请先选择要删除的内容");
		});
	});
</script>
</head>
<body>
<form id="myForm" action="${ctx }/security/user/list" method="get">
 <!--content start-->
<div class="content">
<div class="table">
  <div class="contentNav"><h1><span class="allIco2 ico_6"></span>用户信息管理</h1></div>

  <!--内容 start-->

<se:authorize ifAnyGranted="A_SECURITY_USER_EDIT">
<div class="function">
<ul>
  <li id="liNav">你可以：</li>
  <li><a id="add" href="#">新增</a></li>
  <li><a id="del" href="#">删除</a></li>
  </ul>
  <div class="clear"></div>
  </div>   
</se:authorize>
  
  
   <!--信息搜索 start-->
    <div class="search"><ul>
    <li>名称： <input type="text" class="input1" /></li>
   <li>
    <div class="searcBbutton"><input id="search" name="search" type="submit" value="提交" class="button1" id="OK" />&nbsp;<input id="reset" name="reset" type="button" value="清空" class="button1" id="Reset" /></div></li>
    </ul>
    <div class="clear"></div>
    </div>
        <!--信息搜索 end--> 
   
<div class="addList">
  <table cellpadding="1" cellspacing="1"  class="table_bj">
    <tr class="table_top">
      <td width="5%"><jsp:include page="/common/checkall.jsp"></jsp:include>&nbsp;</td>
      <td>登陆名</td>
      <td>真实姓名</td>
      <td>角色</td>
      <td>操作</td>
    </tr>
    <c:choose>
		<c:when test="${not empty page.result}">
			<c:forEach items="${page.result}" var="user">
				<tr class="table_con">
					<td><input type="checkbox" name="items" id="checkbox" value="${user.id}"/></td>
					<td>${user.username }&nbsp;</td>
					<td>${user.truename }&nbsp;</td>
					<td>${user.rolesAsString }&nbsp;</td>
					<td>
					<se:authorize ifAnyGranted="A_SECURITY_USER_EDIT">
						<a href="${ctx }/security/user/${user.id}/edit">编辑</a>
					</se:authorize>
					&nbsp;	
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr class="table_con"><td colspan="5" align="center"><b>暂无内容</b></td></tr>
		</c:otherwise>
	</c:choose>
  </table>
</div> 

<!--list end--> 

<div class="contactBbutton">
	<jsp:include page="/common/page.jsp" />
</div>
<!--内容 end--> 
  
</div></div>
</form>
  <!--content end-->
</body>
</html>
