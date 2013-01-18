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
            
          <section>
              <div class="page-header">
                <h2>${article.title}</h2>
              </div>
    
              <p>
                <!-- content start-->
                ${article.content}
                <!-- content end-->
              </p>
          </section>
          
          <!-- pager:previous and next -->
          <ul class="pager">
            <#if prev?exists>
               <li class="previous">
                <a href="${ctx}/article/${prev.id}">&larr; Older</a>
               </li>
            <#else>
               <li class="previous disabled">
                <a href="javascript:;">&larr; Older</a>
               </li>
            </#if>
            
            <#if next?exists>
               <li class="next">
                <a href="${ctx}/article/${next.id}">Newer &rarr;</a>
              </li>
            <#else>
               <li class="next disabled">
                <a href="javascript:;">Newer &rarr;</a>
              </li>
            </#if>
           </ul>

        
        </div>
        <!--left end-->
        
        <!--right start-->
        <div class="span4">

            <div class="thumbnail">
                  <img class="img-polaroid" src="${ctx}/resources/images/me.png" alt="">
                  <div class="caption">
                    <h3>${article.user.username}</h3>
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
