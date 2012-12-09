<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>杰森博客 管理后台</title>
    <%@include file="/common/taglibs.jsp" %>
	<%@include file="/common/common-header.jsp" %>
 </head>

  <body>
	<%@include file="/WEB-INF/views/admin/header.jsp" %>

    <div class="container-fluid">
      <div class="row-fluid">
        <%@include file="/WEB-INF/views/admin/left.jsp" %>
        <div class="span9">
          	<!-- <div class="page-header">
					<h3>资源管理</h3>
			</div> -->
			<!-- 面包屑 -->
			<ul class="breadcrumb">
			  <li>
			    <a href="${ctx }/admin">首页</a> <span class="divider">/</span>
			  </li>
			  <li>
			    <a href="${ctx }/security/authority/list">权限管理</a> <span class="divider">/</span>
			  </li>
			  <li id="breadcrumb_active" class="active">新增/修改</li>
			</ul>
			<!-- 操作 -->
			<ul class="nav nav-tabs">
	          <li title="列表"  class="icon index_collection_link ">
	            <a class="pjax" href="${ctx }/security/authority/list">
	              <i class="icon-th-list"></i>
	              <span>列表</span>
	            </a>
	          </li>
	          <li id="createId" title="新增"  class="icon new_collection_link active">
	            <a class="pjax" href="${ctx }/security/authority/create">
	              <i class="icon-plus"></i>
	              <span>新增</span>
	            </a>
	          </li>
	          <li id="editId" title="编辑"  class="icon new_collection_link active">
	            <a class="pjax" href="${ctx }/security/authority/edit">
	              <i class="icon-pencil"></i>
	              <span>编辑</span>
	            </a>
	          </li>
			</ul>

			<!-- 搜索 
			<form class="well form-search" accept-charset="UTF-8" action="/admin/plan" method="get">
			  <input type="text" name="query" class="input-medium search-query" placeholder="筛选">
			  <button type="submit" class="btn">搜索</button>
			</form>-->
			
			<!-- <form class="form-horizontal">
			  <div class="control-group error">
			    <label class="control-label" for="inputEmail">Email</label>
			    <div class="controls">
			        <input type="text" id="inputEmail" placeholder="Email">
			    	<span class="help-inline">Password can't be blank</span>
			    	<p class="help-block">Required. Length of 6-128.</p>
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="inputPassword">Password</label>
			    <div class="controls">
			      <input class="input-large" type="password" id="inputPassword" placeholder="Password">
			    </div>
			  </div>
			  <div class="control-group">
			    <div class="controls">
			      <label class="checkbox">
			        <input type="checkbox"> Remember me
			      </label>
			      <button type="submit" class="btn">Sign in</button>
			    </div>
			  </div>
			</form> -->
			

			<form:form  class="form-horizontal" method="post" modelAttribute="authority">
				<input type="hidden" name="_method" value="${_method}"></input>
			  <div class="control-group">
			    <label class="control-label" for="name">*名称</label>
			    <div class="controls">
			        <form:input path="name"  placeholder="name"/>
			    	<p class="help-block">必填.</p>
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="displayName">显示名称</label>
			    <div class="controls">
			        <form:input path="displayName"  placeholder="displayName"/>
			    	<p class="help-block">必填.</p>
			    </div>
			  </div>
			  <div class="control-group boolean optional">
			    <label class="control-label" for="priority">资源</label>
			    <div class="controls">
			        <c:forEach var="resource" items="${resourceList }">
						<form:checkbox cssStyle="display: inline" cssClass="checkbox" path="resourceMap[${resource.id }]" value="${resource.id}" label="  ${resource.name }"/>
					</c:forEach>
			    </div>
			  </div>
			  <div class="control-group">
			    <div class="controls">
			      <button type="submit" class="btn">提交</button>
			      <button type="button" class="btn" onclick="javascript:history.go(-1);">返回</button>
			    </div>
			  </div>
			</form:form>
          
        </div>
      </div>
	<%@include file="/WEB-INF/views/admin/footer.jsp" %>
    </div>
<%@include file="/common/common-footer.jsp" %>
<script type="text/javascript">
	$(function(){
		load();
		function load(){
			$('#authority_list').addClass('active');
			var _method = $('input[name="_method"]').val();
			if(_method == 'put'){
				//当 _method == 'put' 的时候 为edit编辑
				$('#breadcrumb_active').text("编辑");
				$('#createId').hide();
			}else{
				//否则为新增
				$('#breadcrumb_active').text("新增");
				$('#editId').hide();
				
			}
		};
		
	});
</script>
  </body>
</html>
