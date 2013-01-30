<#assign totalPages="${(page.totalPages gt 2000)?string('2000',page.totalPages)}" >
<ul>
<#if totalPages?number gt 1>
	<#if (page.pageNo?number) gt 1>
		<li><a href="${pagingUrl}/page/${((page.pageNo?number-1) gt 0)?string(page.pageNo?number-1,page.pageNo?number)}">&lt; 上一页</a></li>
	</#if>
	<#if page.pageNo?number == 1>
		<li class="active"><a>1</a></li>
	<#else>
		<li><a href="${pagingUrl }/page/1">1</a></li>
	</#if>
	<#if totalPages?number gt 0>
		<#if page.pageNo?number lt 10>
			<#if page.pageNo?number gte 2>
			<#list 2..page.pageNo?number as i>
				<#if page.pageNo?number==i>
					<li class="active"><a>${i}</a></li>
				<#else>
					<li><a href="${pagingUrl }/page/${i}">${i}</a></li>
				</#if>
			</#list>
			</#if>
		<#else>
			  ...&nbsp;  
			  <#list page.pageNo?number-4..page.pageNo?number as i>
				<#if page.pageNo?number==i>
					<li class="active"><a>${i}</a></li>
				<#else>
					<li><a href="${pagingUrl }/page/${i}">${i}</a></li>
				</#if>
			  </#list>
		</#if>
		<#if page.pageNo?number gte totalPages?number-4 || totalPages?number-4 lte 0>
			<#if page.pageNo?number+1 lte totalPages?number>
			<#list page.pageNo?number+1..totalPages?number as i>
				<li><a href="${pagingUrl }/page/${i}">${i}</a></li>
				<#if page.pageNo?number == i>
					<li class="active"><a>${i}</a></li>
				</#if>
			</#list>
			</#if>
		<#else>
			<#list page.nextPage..page.pageNo?number+4 as i>
				<#if page.pageNo?number == i>
					<li class="active"><a>${i}</a></li>
				<#else>
					<li><a href="${pagingUrl }/page/${i}">${i}</a></li>
				</#if>
			</#list>
			  ...&nbsp;  
			  <li><a href="${pagingUrl }/page/${totalPages}">${totalPages}</a></li>
		</#if>
		<#if page.pageNo?number lt totalPages?number>
			<li><a href="${pagingUrl }/page/${((page.nextPage) lt totalPages?number)?string(page.nextPage,totalPages?number)}">下一页 &gt;</a></li>
		</#if>
	</#if>
	
</#if>

</ul>
