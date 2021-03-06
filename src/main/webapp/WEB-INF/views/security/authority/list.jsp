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
            <c:if test="${not empty message}">
                 <div class="alert alert-${message.type }">
                    <a class="close" data-dismiss="alert" href="#">×</a>
                     ${message.text }
                </div>
            </c:if>
			<!-- 面包屑 -->
			<ul class="breadcrumb">
			  <li>
			    <a href="${ctx }/admin">首页</a> <span class="divider">/</span>
			  </li>
			  <li>
			    <a href="${ctx }/security/authority/list">权限管理</a> <span class="divider">/</span>
			  </li>
			  <li class="active">列表</li>
			</ul>
			<!-- 操作 -->
			<ul class="nav nav-tabs">
	          <li title="列表"  class="icon index_collection_link active">
	            <a class="pjax" href="${ctx }/security/authority/list">
	              <i class="icon-th-list"></i>
	              <span>列表</span>
	            </a>
	          </li>
	          
	          <se:authorize ifAnyGranted="A_SECURITY_AUTHORITY_EDIT">
	          <li title="新增"  class="icon new_collection_link ">
	            <a class="pjax" href="${ctx }/security/authority/create">
	              <i class="icon-plus"></i>
	              <span>新增</span>
	            </a>
	          </li>
	          <li id="deleteId" title="删除"  class="icon new_collection_link ">
	            <a class="pjax" href="javascript:;">
	              <i class="icon-remove"></i>
	              <span>删除</span>
	            </a>
	          </li>
	          </se:authorize>
			</ul>

			<form id="myForm" action="${ctx }/security/authority/list" method="get">
			<!-- 搜索 -->
			  <input type="text" name="name" class="input-small search-query" placeholder="名称">
			  <button type="submit" class="btn">搜索</button>
			
			<table class="table table-striped ">
					<thead>
						<tr>
							<th width="7%"><jsp:include page="/common/checkall.jsp"></jsp:include>&nbsp;</th>
							<th class="sortable"><a href="#">名称</a></th>
							<th class="sortable"><a href="#">显示名称</a></th>
							<th class="header">操作</th>
						</tr>
					</thead>
					<tbody>
						    <c:choose>
								<c:when test="${not empty page.result}">
									<c:forEach items="${page.result}" var="authority">
										<tr class="table_con">
											<td><input type="checkbox" name="items" id="checkbox" value="${authority.id}"/></td>
											<td>${authority.name}&nbsp;</td>
											<td>${authority.displayName}&nbsp;</td>

											<td  class="link">
												<se:authorize ifAnyGranted="A_SECURITY_AUTHORITY_EDIT">
													<a class="btn btn-small" href="${ctx }/security/authority/${authority.id}/edit"><i class="icon-pencil"></i> 编辑</a>
													<a class="btn btn-small" href="javascript:;"  onclick="deleteRow('${authority.id}')" ><i class="icon-remove"></i> 删除</a>
												</se:authorize>
												&nbsp;	
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr class=""><td colspan="4" align="center"><b>暂无内容</b></td></tr>
								</c:otherwise>
							</c:choose>
					
					</tbody>
				</table>
				</form>
				
				<div class="pagination pagination-centered">
					<%@include file="/common/page.jsp" %>
				</div>
          
        </div>
      </div>
      <hr>
		<%@include file="/WEB-INF/views/admin/footer.jsp" %>
    </div>
<%@include file="/common/common-footer.jsp" %>

<script type="text/javascript">
	$(function(){
		load();
		function load(){
			$('#authority_list').addClass('active');
		};
		
		$("#add").click(function(){
			location.href = "${ctx}/security/authority/create";
		});
		
		$("#deleteId").click(function(){
			var items = jason.select();
			if(items && items.length > 0){
				if(confirm("确定要清空数据吗？")){
					$("#myForm").attr("action", "${ctx}/security/authority/delete")
								.attr("method","post")
								.append('<input type="hidden" name="_method" value="DELETE" />')
								.submit();
					return;
				};
			}else{
				alert("请先选择要删除的内容");
			};
		});
		
	});
	function deleteRow(value){
		if(confirm("确定要清空数据吗？")){
			$("#myForm").attr("action", "${ctx}/security/authority/"+value+"/delete")
				.attr("method","post")
				.append('<input type="hidden" name="_method" value="DELETE" />')
				.submit();
		}
	};
	
</script>
  </body>
</html>
