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
                ${article.content}
              </p>
          </section>
        
        </div>
        <!--left end-->
        
        <!--right start-->
        <div class="span4">

            <div class="thumbnail">
                  <img src="http://placehold.it/300x200" alt="">
                  <div class="caption">
                    <h3>Thumbnail label</h3>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a href="#" class="btn btn-primary">Action</a> <a href="#" class="btn">Action</a></p>
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
