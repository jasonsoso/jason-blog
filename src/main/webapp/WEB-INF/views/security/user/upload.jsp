<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>上传头像 杰森博客 管理后台</title>
    <%@include file="/common/taglibs.jsp" %>
	<%@include file="/common/common-header.jsp" %>
	<link href="${ctx }/resources/js/imgareaselect/css/imgareaselect-default.css" rel="stylesheet">

<style type="text/css">
.demo {
  background: #eee;
  border: solid 2px #ddd;
  border-radius: 4px;
  padding: 0.6em;
}
.demo p {
    padding: 0.3em 0.6em;
    margin: 0.3em auto;
}
.demo p.instructions {
    font-family: serif;
    font-style: italic;
    /* font-size: 90%; */
    color: #666;
    line-height: 130%;
}
.demo table td {
    /* width: 6.5em; */
}
.demo table td {
    padding-left: 1em;
}
.demo table td input {
    width: 4em;
    text-align: right;
}
div.frame {
    background: #fff;
    padding: 0.8em;
    border: solid 2px #ddd;
}
</style>

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
			
			<ul class="breadcrumb"><!-- 面包屑 -->
			  <li>
			    <a href="${ctx }/admin">首页</a> <span class="divider">/</span>
			  </li>
			  <li>
			    <a href="${ctx }/security/user/list">用户管理</a> <span class="divider">/</span>
			  </li>
			  <li id="breadcrumb_active" class="active">上传头像</li>
			</ul>
			<!-- 操作 -->
			<ul class="nav nav-tabs">
	          <li title="列表"  class="icon index_collection_link ">
	            <a class="pjax" href="${ctx }/security/user/list">
	              <i class="icon-th-list"></i>
	              <span>列表</span>
	            </a>
	          </li>
	          <li id="createId" title="新增"  class="icon new_collection_link active">
	            <a class="pjax" href="${ctx }/security/user/create">
	              <i class="icon-plus"></i>
	              <span>新增</span>
	            </a>
	          </li>
	          <li id="editId" title="编辑"  class="icon new_collection_link active">
	            <a class="pjax" href="${ctx }/security/user/edit">
	              <i class="icon-pencil"></i>
	              <span>编辑</span>
	            </a>
	          </li>
			</ul>
            
			<form id="uploadForm"  action="${ctx }/security/user/upload" enctype="multipart/form-data">
			     <div class="control-group">
	                <label class="control-label" for="username">*上传图片</label>
	                <div class="controls">
	                    <input id="file" type="file" name="file" />
						<input id="upload" type="submit" value="上传" />
	                    <p class="help-block">必填</p>
	                </div>
	              </div>
	              
	              <div class="progress">
				        <div class="bar"></div >
				        <div class="percent">0%</div >
				    </div>
				    <div id="status"></div>
				    <%-- <img id="myImg" src="${ctx}/resources/images/me.png" width="180" height="180"> --%>
				    
<div class="container demo">
  <div style="float: left; width: 50%;">
    <p class="instructions">
      Click and drag on the image to select an area. 
    </p>
 
    <div class="frame" style="margin: 0 0.3em; width: 300px; height: 300px;">
      <img id="photo" src="${ctx}/resources/images/me.png">
    </div>
  </div>
 
  <div style="float: left; width: 50%;">
    <p style="font-size: 110%; font-weight: bold; padding-left: 0.1em;">
      Selection Preview
    </p>
  
    <div class="frame" style="margin: 0 1em; width: 100px; height: 100px;">
      <div id="preview" style="width: 100px; height: 100px; overflow: hidden;">
        <img src="${ctx}/resources/images/me.png" style="width: 173px; height: 173px; margin-left: -23px; margin-top: -17px; ">
      </div>
    </div>

    <table style="margin-top: 1em;">
      <thead>
        <tr>
          <th colspan="2" style="font-size: 110%; font-weight: bold; text-align: left; padding-left: 0.1em;">
            Coordinates
          </th>
          <th colspan="2" style="font-size: 110%; font-weight: bold; text-align: left; padding-left: 0.1em;">
            Dimensions
          </th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td style="width: 10%;"><b>X<sub>1</sub>:</b></td>
              <td style="width: 30%;"><input type="text" id="x1" value="-"></td>
              <td style="width: 20%;"><b>Width:</b></td>
            <td><input type="text" value="-" id="w"></td>
        </tr>
        <tr>
          <td><b>Y<sub>1</sub>:</b></td>
          <td><input type="text" id="y1" value="-"></td>
          <td><b>Height:</b></td>
          <td><input type="text" id="h" value="-"></td>
        </tr>
        <tr>
          <td><b>X<sub>2</sub>:</b></td>
          <td><input type="text" id="x2" value="-"></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td><b>Y<sub>2</sub>:</b></td>
          <td><input type="text" id="y2" value="-"></td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
			</form>
          
        </div>
      </div>
	<%@include file="/WEB-INF/views/admin/footer.jsp" %>
    </div>
<%@include file="/common/common-footer.jsp" %>
<script src="${ctx }/resources/js/jquery.form.js"></script>
<script src="${ctx }/resources/js/imgareaselect/js/jquery.imgareaselect.pack.js"></script>
<script type="text/javascript">
	$(function(){
		$('img#photo').imgAreaSelect({ 
			aspectRatio: '1:1', 
			handles: true,
	        fadeSpeed: 200, 
	        onSelectChange: preview 
	    });
		function preview(img, selection) {
		    if (!selection.width || !selection.height)
		        return;
		    
		    var scaleX = 100 / selection.width;
		    var scaleY = 100 / selection.height;

		    $('#preview img').css({
		        width: Math.round(scaleX * 300),
		        height: Math.round(scaleY * 300),
		        marginLeft: -Math.round(scaleX * selection.x1),
		        marginTop: -Math.round(scaleY * selection.y1)
		    });

		    $('#x1').val(selection.x1);
		    $('#y1').val(selection.y1);
		    $('#x2').val(selection.x2);
		    $('#y2').val(selection.y2);
		    $('#w').val(selection.width);
		    $('#h').val(selection.height);    
		}
		
		load();
		function load(){
			$('#user_list').addClass('active');
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
		
		var bar = $('.bar');
		var percent = $('.percent');
		var status = $('#status');
		   
		$('form').ajaxForm({
		    beforeSend: function() {
		        status.empty();
		        var percentVal = '0%';
		        bar.width(percentVal)
		        percent.html(percentVal);
		    },
		    uploadProgress: function(event, position, total, percentComplete) {
		        var percentVal = percentComplete + '%';
		        bar.width(percentVal)
		        percent.html(percentVal);
		    },
		    complete: function(xhr) {
		        status.html(xhr.responseText);
		        var json = eval('(' + xhr.responseText + ')');
		        if(json.success){
		        	alert(json.root);
		        	//$("#myImg").attr("src","${ctx }"+json.root);
		        }else{
		        	alert(json.root);
		        }
		    }
		}); 
		
		
	});
</script>
  </body>
</html>
