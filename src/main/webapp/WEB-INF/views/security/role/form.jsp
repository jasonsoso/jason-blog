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
			    <a href="${ctx }/security/role/list">角色管理</a> <span class="divider">/</span>
			  </li>
			  <li id="breadcrumb_active" class="active">新增/修改</li>
			</ul>
			<!-- 操作 -->
			<ul class="nav nav-tabs">
	          <li title="列表"  class="icon index_collection_link ">
	            <a class="pjax" href="${ctx }/security/role/list">
	              <i class="icon-th-list"></i>
	              <span>列表</span>
	            </a>
	          </li>
	          <se:authorize ifAnyGranted="A_SECURITY_ROLE_EDIT">
	          <li id="createId" title="新增"  class="icon new_collection_link active">
	            <a class="pjax" href="${ctx }/security/role/create">
	              <i class="icon-plus"></i>
	              <span>新增</span>
	            </a>
	          </li>
	          <li id="editId" title="编辑"  class="icon new_collection_link active">
	            <a class="pjax" href="${ctx }/security/role/edit">
	              <i class="icon-pencil"></i>
	              <span>编辑</span>
	            </a>
	          </li>
	          </se:authorize>
			</ul>
			<!--  form 表单  -->
			<form:form  class="form-horizontal" method="post" modelAttribute="role">
				<input type="hidden" name="_method" value="${_method}"></input>
			  <div class="control-group">
			    <label class="control-label" for="name">*角色</label>
			    <div class="controls">
			        <form:input path="name"  placeholder="name"/>
			    	<p class="help-block">必填.</p>
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="descr">描述</label>
			    <div class="controls">
			      <form:input path="descr"  placeholder="descr"/>
			    </div>
			  </div>
			  <div class="control-group boolean optional">
			    <label class="control-label" for="priority">资源</label>
			    <div class="controls">
			        <c:forEach var="authority" items="${authorityList }">
						<form:checkbox path="authorityMap[${authority.id }]" value="${authority.id}" label="  ${authority.displayName }" />
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
			$('#role_list').addClass('active');
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
