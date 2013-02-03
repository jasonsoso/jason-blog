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
      <!--
      <div class="row-fluid">-->
        
        <!--left start-->
        <!--
        <div class="span8">
        
            <div class="bs-docs-example">
              <div id="myCarousel" class="carousel slide">
                <div class="carousel-inner">
                  <div class="item">
                    <img src="http://wrongwaycn.github.com/bootstrap/docs/assets/img/bootstrap-mdo-sfmoma-03.jpg" alt="">
                    <div class="carousel-caption">
                      <h4>First Thumbnail label</h4>
                      <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    </div>
                  </div>
                  <div class="item active">
                    <img src="http://wrongwaycn.github.com/bootstrap/docs/assets/img/bootstrap-mdo-sfmoma-01.jpg" alt="">
                    <div class="carousel-caption">
                      <h4>Second Thumbnail label</h4>
                      <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    </div>
                  </div>
                  <div class="item">
                    <img src="http://wrongwaycn.github.com/bootstrap/docs/assets/img/bootstrap-mdo-sfmoma-02.jpg" alt="">
                    <div class="carousel-caption">
                      <h4>Third Thumbnail label</h4>
                      <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    </div>
                  </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
              </div>
            </div>
              
              
        </div>-->
        <!--left end-->
        
        <!--right start-->
        <!---
        <div class="span4">

            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade in active" id="home">
              
                    <ol>
                      <li>記錄Oracle常用SQL </li>
                      <li>MongoDB学习(五、所谓的高级更新) </li>
                      <li>作出艰难的决定 </li>
                      <li>《我为何而生》 </li>
                      <li>Nulla volutpat aliquam velit</li>
                      <li>Faucibus porta lacus fringilla vel</li>
                      <li>Aenean sit amet erat nunc</li>
                      <li>Eget porttitor lorem</li>
                    </ol>
                    
              </div>
              <div class="tab-pane fade" id="profile">
                <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. </p>
              </div>
              <div class="tab-pane fade" id="dropdown1">
                <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
              </div>
              <div class="tab-pane fade" id="dropdown2">
                <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
              </div>
            </div>


        </div>-->
        <!--right end-->
        
       <!--
      </div>-->
        <div id="content" class="row-fluid">
             
             
             <#list page.result as article>
<div class="list-widget list-init" style="padding: 5px;">
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
            
           


        </div>
        
        <div class="pagination pagination-centered">
             <#assign pagingUrl="${ctx}/article">
             <#include  "page.ftl">
        </div>
           
           
    <hr/>
<#include "footer.ftl" /><!--foot-->
    </div>

<#include "common-footer.ftl" />
<script src="${ctx }/resources/js/jquery.masonry.min.js"></script>
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
