<#include "common-taglibs.ftl" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>杰森博客</title>
    <#include "common-header.ftl" />
    
 </head>
  <body>
    <#include "header.ftl" /><!--head-->
    
    <div class="container">
      <div class="row-fluid">
        
        <!--left start-->
        <div class="span8">
            
           <#list page.result as article>
   
<div class="list-widget" style="padding: 12px;">
    <a target="_blank" href="${ctx}/${article.user.username}" title="${article.user.username}">
        <img src="${ctx}/resources/images/me.png" width="42" height="42" class="avatar" style="float:left">
    </a>
    <div class="list-head">
        <h3><a target="_blank" href="${ctx}/article/${article.id}">${article.title}</a></h3>
        <div class="list-meta">by <a target="_blank" href="${ctx}/${article.user.username}">${article.user.username}</a></div>
    </div>
    <div>
        ${article.summary}
    </div>
</div>

           </#list>
           <div class="pagination pagination-centered">
               <#assign pagingUrl="${ctx}/${user.username}">
               <#include  "page.ftl">
           </div>
          
        </div>
        <!--left end-->
        
        <!--right start-->
        <div class="span4">

            <div class="thumbnail bg-white">
                  <img class="img-polaroid" src="${ctx}/resources/images/me.png" alt="">
                  <div class="caption">
                    <h3><a href="${ctx}/${user.username}">${user.username}</a></h3>
                    <p>Love a person is not easy</p>
                    <p><a href="#" class="btn">关注我</a></p>
                  </div>
                </div>

        </div>
        <!--right end-->
        
        
      </div>
      
      
    <hr/>
<#include "footer.ftl" /><!--foot-->
    </div>

<#include "common-footer.ftl" />
<script type="text/javascript">

$(function(){
    
    init_masonry();
    
    function init_masonry(){
        var $container = $('#content');
        var gutter = 15;
        var min_width = 350;
        $container.imagesLoaded( function(){
            $container.masonry({
                itemSelector : '.list-widget',
                gutterWidth: gutter,
                isAnimated: true,
                  columnWidth: function( containerWidth ) {
                    var num_of_boxes = (containerWidth/min_width | 0);
                    var box_width = (((containerWidth - (num_of_boxes-1)*gutter)/num_of_boxes) | 0) ;
                    if (containerWidth < min_width) {
                        box_width = containerWidth;
                    }
                    $('.list-widget').width(box_width);
                    return box_width;
                  }
            });
        });
    }

    
    //代码高亮
    SyntaxHighlighter.highlight();
    //调整左右对齐
    for(var i=0,di;di=SyntaxHighlighter.highlightContainers[i++];){
            var tds = di.getElementsByTagName('td');
            for(var j=0,li,ri;li=tds[0].childNodes[j];j++){
                ri = tds[1].firstChild.childNodes[j];
               ri.style.height = li.style.height = ri.offsetHeight + 'px';
           }
     }
});
</script>
  </body>
</html>
