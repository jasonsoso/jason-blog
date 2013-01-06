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
			    <a href="${ctx }/article/list">文章管理</a> <span class="divider">/</span>
			  </li>
			  <li class="active">列表</li>
			</ul>
			<!-- 操作 -->
			<ul class="nav nav-tabs">
	          <li title="列表"  class="icon index_collection_link active">
	            <a class="pjax" href="${ctx }/article/list">
	              <i class="icon-th-list"></i>
	              <span>列表</span>
	            </a>
	          </li>
	          <li title="新增"  class="icon new_collection_link ">
	            <a class="pjax" href="${ctx }/article/create">
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
			</ul>

			<form id="myForm" action="${ctx }/article/list" method="get">
			<!-- 搜索 -->
			  <input type="text" name="title" class="input-small search-query" placeholder="标题">
			  <button type="submit" class="btn">搜索</button>
			
			<table class="table table-striped ">
					<thead>
						<tr>
							<th width="7%"><jsp:include page="/common/checkall.jsp"></jsp:include>&nbsp;</th>
							<th class="sortable"><a href="#">标题</a></th>
							<th class="sortable"><a href="#">是否置顶</a></th>
							<th class="sortable"><a href="#">状态</a></th>
							<th class="sortable"><a href="#">创建时间</a></th>
							<th class="sortable"><a href="#">最近更新时间</a></th>
							<th class="sortable"><a href="#">作者</a></th>
							<th class="header">操作</th>
						</tr>
					</thead>
					<tbody>
						    <c:choose>
								<c:when test="${not empty page.result}">
									<c:forEach items="${page.result}" var="article">
										<tr class="table_con">
											<td><input type="checkbox" name="items" id="checkbox" value="${article.id}"/></td>
											<td>${article.title}&nbsp;</td>
											<td>
											     <c:choose>
											         <c:when test="${article.onTop}">
											             是
											         </c:when>
											         <c:otherwise>
											           否  
											         </c:otherwise>
											     </c:choose>
											 &nbsp;</td>
											<td>${article.status}&nbsp;</td>
											<td>
											     <fmt:formatDate value="${article.createdAt}" pattern="yyyy-MM-dd hh:mm"/>
											 &nbsp;</td>
											<td>
											     <fmt:formatDate value="${article.updatedAt}" pattern="yyyy-MM-dd hh:mm"/>
											&nbsp;</td>
                                            <td>
                                                ${article.userInfo.username}
                                            &nbsp;</td>
											<td  class="link">
													<a class="btn btn-small" href="${ctx }/article/${article.id}/edit"><i class="icon-pencil"></i> 编辑</a>
													<a class="btn btn-small" href="javascript:;"  onclick="deleteRow('${article.id}')" ><i class="icon-remove"></i> 删除</a>
												&nbsp;	
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr class=""><td colspan="7" align="center"><b>暂无内容</b></td></tr>
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
			$('#article_list').addClass('active');
		};
		
		$("#add").click(function(){
			location.href = "${ctx}/article/create";
		});
		
		$("#deleteId").click(function(){
			var items = jason.select();
			if(items && items.length > 0){
				if(confirm("确定要清空数据吗？")){
					$("#myForm").attr("action", "${ctx}/article/delete")
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
			$("#myForm").attr("action", "${ctx}/article/"+value+"/delete")
				.attr("method","post")
				.append('<input type="hidden" name="_method" value="DELETE" />')
				.submit();
		}
	};
	
</script>
  </body>
</html>
