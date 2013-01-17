<#include "/common/front/taglibs.ftl" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>杰森博客</title>
    <#include "/common/front/common-header.ftl" />
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/js/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css"/>
    
 </head>
  <body>
    


    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="/" style="padding: 5px 20px 5px;">
            <img class="img-rounded" width="30" height="30" alt="" src="${ctx}/resources/bootstrap/ico/login.png">
            杰森博客 后台管理
          </a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
                 亲！欢迎你:<a href="#" class="navbar-link">abc军</a>
                &nbsp; | &nbsp;
                <a href="${ctx}/j_spring_security_logout" data-method="delete" rel="nofollow"><span class="label label-important">退出</span></a>
            </p>
            <ul class="nav">
              <li class="active"><a href="#">首页</a></li>
              <li><a href="#about">关于</a></li>
              <li><a href="#contact">联系我</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    
    
    
    <div class="container-fluid">
      <div class="row-fluid">
        
        
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
               <li class="nav-header"><i class="icon-user"></i>系统管理</li>
               <li id="user_list" ><a href="${ctx }/security/user/list"><i class="icon-list"></i>用户管理</a></li>
               <li id="role_list" ><a href="${ctx }/security/role/list"><i class="icon-list"></i>角色管理</a></li>
               <li id="authority_list" ><a href="${ctx }/security/authority/list"><i class="icon-list"></i>权限管理</a></li>
               <li id="resource_list"><a href="${ctx }/security/resource/list"><i class="icon-list"></i>资源管理</a></li>
               <li id="article_list"><a href="${ctx }/article/list"><i class="icon-list"></i>文章管理</a></li>
             </ul>
          </div>
        </div>
        
        
        
        <div class="span9">
           
            <ul class="breadcrumb">
              <li>
                <a href="${ctx }/admin">首页</a> <span class="divider">/</span>
              </li>
              <li>
                <a href="${ctx }/article/list">文章管理</a> <span class="divider">/</span>
              </li>
              <li id="breadcrumb_active" class="active">查看</li>
            </ul>
            
            
              <div class="control-group">
                <div class="controls">
                   ${article.title}
                </div>
              </div>
              <div class="control-group">
                <div class="controls">
                 ${article.content}
                </div>
              </div>

          
        </div>
      </div>
    
    
    
    <footer>
        <p>&copy; Company 2012 www.jasonsoso.com 杰森工作室</p>
    </footer>


    </div>


<script src="${ctx }/resources/bootstrap/js/jquery.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-transition.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-alert.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-modal.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-dropdown.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-scrollspy.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-tab.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-tooltip.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-popover.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-button.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-collapse.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-carousel.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap-typeahead.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx }/resources/js/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<script src="${ctx }/resources/js/admin.js"></script>


<script type="text/javascript">
    $(function(){
    SyntaxHighlighter.highlight();
    //调整左右对齐
    //for(var i=0,di;di=SyntaxHighlighter.highlightContainers[i++];){
    //        var tds = di.getElementsByTagName('td');
    //        for(var j=0,li,ri;li=tds[0].childNodes[j];j++){
    //            ri = tds[1].firstChild.childNodes[j];
    //           ri.style.height = li.style.height = ri.offsetHeight + 'px';
    //       }
    // }
    });
</script>
  </body>
</html>
