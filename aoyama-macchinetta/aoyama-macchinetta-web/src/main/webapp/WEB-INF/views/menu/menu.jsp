<sec:authentication property="principal.myUser" var="myUser" />
<spring:eval var="sessionContent" expression="@sessionContent" />
<ul class="nav navbar-nav">
	<form:form id="menu" method="post">
	<c:choose>
		<c:when test="${myUser.authority == '01'}">
		    <li>
	        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/orderlist/init')"> <i class="menu-icon fas fa-th-list"></i>オーダー一覧</a>
	    	</li>
	    	<c:choose>
		    	<c:when test="${sessionContent.category == 'PO'}">
				    <li>
				        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/order/orderPo')"> <i class="menu-icon fas fa-edit"></i>オーダー登録(PO)</a>
				    </li>
			    </c:when>
		    	<c:when test="${sessionContent.category == 'CO'}">
				    <li>
				        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/orderCo/toOrderCoInit')"> <i class="menu-icon fas fa-edit"></i>オーダー登録(CO)</a>
				    </li>
			    </c:when>
		    </c:choose>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/accounting/init')"> <i class="menu-icon fas fa-cash-register"></i>会計一覧</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/stock/init')"> <i class="menu-icon fas fa-warehouse"></i>在庫確認</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/password/init')"> <i class="menu-icon fas fa-lock"></i>パスワード管理</a>
		    </li>
		    <%-- <li>
		        <a href="${pageContext.request.contextPath}/warn/init"> <i class="menu-icon fa fa-lock"></i>未登録データ提示一覧</a>
		    </li> --%>
		</c:when>
		<c:when test="${myUser.authority == '02'}">
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/orderlist/init')"> <i class="menu-icon fas fa-th-list"></i>オーダー一覧</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/accounting/init')"> <i class="menu-icon fas fa-cash-register"></i>会計一覧</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/password/init')"> <i class="menu-icon fas fa-lock"></i>パスワード管理</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/fabric/init')"> <i class="menu-icon fab fa-cotton-bureau"></i>生地管理</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/brand/init')"> <i class="menu-icon fas fa-tags"></i>生地ブランド管理</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/stock/init')"> <i class="menu-icon fas fa-warehouse"></i>在庫管理</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/delivery/init')"> <i class="menu-icon fas fa-calendar-alt"></i>納期管理</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/piece/init')"> <i class="menu-icon fas fa-dollar-sign"></i>下代価格管理</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/shop/init')"> <i class="menu-icon fas fa-store"></i>店舗管理</a>
		    </li>
		    <li>
		       <a href="javascript:menuSubmit('${pageContext.request.contextPath}/factory/init')"> <i class="menu-icon fas fa-industry"></i>工場管理</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/maker/init')"> <i class="menu-icon fas fa-building"></i>メーカー管理</a>
		    </li>
		    
		</c:when>
		<c:when test="${myUser.authority == '03'}">
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/orderlist/init')"> <i class="menu-icon fas fa-th-list"></i>オーダー一覧</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/password/init')"> <i class="menu-icon fas fa-lock"></i>パスワード管理</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/stock/init')"> <i class="menu-icon fas fa-warehouse"></i>在庫管理</a>
		    </li>
		</c:when>
		<c:otherwise>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/orderlist/init')"> <i class="menu-icon fas fa-th-list"></i>オーダー一覧</a>
		    </li>
		    <li>
		        <a href="javascript:menuSubmit('${pageContext.request.contextPath}/password/init')"> <i class="menu-icon fas fa-lock"></i>パスワード管理</a>
		    </li>
		    <c:choose>
		    	<c:when test="${sessionContent.category == 'PO'}">
				   	<li>
				       	<a href="javascript:menuSubmit('${pageContext.request.contextPath}/print/init')"> <i class="menu-icon fas fa-print"></i>注文内容確認書印刷</a>
				   	</li>
				</c:when>
			</c:choose>
		</c:otherwise>
	</c:choose>
	</form:form>
</ul>
<script>
function menuSubmit(action) {
    document.getElementById('menu').action = action;
    document.getElementById('menu').submit();
}
</script>
