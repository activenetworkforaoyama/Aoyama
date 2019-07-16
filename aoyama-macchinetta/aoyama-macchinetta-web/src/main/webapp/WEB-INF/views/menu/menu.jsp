<sec:authentication property="principal.myUser" var="myUser" />
<spring:eval var="sessionContent" expression="@sessionContent" />
<ul class="nav navbar-nav">
	<c:choose>
		<c:when test="${myUser.authority == '01'}">
		    <li>
	        <a href="${pageContext.request.contextPath}/orderlist/init"> <i class="menu-icon fa fa-th-list"></i>オーダー一覧</a>
	    	</li>
	    	<c:choose>
		    	<c:when test="${sessionContent.category == 'PO'}">
				    <li>
				        <a href="${pageContext.request.contextPath}/order/orderPo"> <i class="menu-icon fa fa-edit"></i>オーダー登録(PO)</a>
				    </li>
			    </c:when>
		    	<c:when test="${sessionContent.category == 'CO'}">
				    <li>
				        <a href="${pageContext.request.contextPath}/order/orderCo"> <i class="menu-icon fa fa-edit"></i>オーダー登録(CO)</a>
				    </li>
			    </c:when>
		    </c:choose>
		    <li>
		        <a href="${pageContext.request.contextPath}/accounting/init"> <i class="menu-icon fa fa-lock"></i>会計一覧</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/stock/init"> <i class="menu-icon fa fa-list"></i>在庫確認</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/password/init"> <i class="menu-icon fa fa-lock"></i>パスワード管理</a>
		    </li>
		    <%-- <li>
		        <a href="${pageContext.request.contextPath}/warn/init"> <i class="menu-icon fa fa-lock"></i>未登録データ提示一覧</a>
		    </li> --%>
		</c:when>
		<c:when test="${myUser.authority == '02'}">
		    <li>
		        <a href="${pageContext.request.contextPath}/orderlist/init"> <i class="menu-icon fa fa-th-list"></i>オーダー一覧</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/accounting/init"> <i class="menu-icon fa fa-lock"></i>会計一覧</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/password/init"> <i class="menu-icon fa fa-lock"></i>パスワード管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/fabric/init"> <i class="menu-icon fa fa-camera"></i>生地管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/brand/init"> <i class="menu-icon fa fa-print"></i>生地ブランド管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/stock/init"> <i class="menu-icon fa fa-list"></i>在庫管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/delivery/init"> <i class="menu-icon fa fa-pencil"></i>納期管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/piece/init"> <i class="menu-icon fa fa-tint"></i>下代価格管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/shop/init"> <i class="menu-icon fa fa-arrows"></i>店舗管理</a>
		    </li>
		    <li>
		       <a href="${pageContext.request.contextPath}/factory/init"> <i class="menu-icon fa fa-eject"></i>工場管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/maker/init"> <i class="menu-icon fa fa-info-circle"></i>メーカー管理</a>
		    </li>
		    
		</c:when>
		<c:when test="${myUser.authority == '03'}">
		    <li>
		        <a href="${pageContext.request.contextPath}/orderlist/init"> <i class="menu-icon fa fa-th-list"></i>オーダー一覧</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/password/init"> <i class="menu-icon fa fa-lock"></i>パスワード管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/maker/init"> <i class="menu-icon fa fa-info-circle"></i>メーカー管理</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/stock/init"> <i class="menu-icon fa fa-list"></i>在庫管理</a>
		    </li>
		</c:when>
		<c:otherwise>
		    <li>
		        <a href="${pageContext.request.contextPath}/orderlist/init"> <i class="menu-icon fa fa-th-list"></i>オーダー一覧</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/password/init"> <i class="menu-icon fa fa-lock"></i>パスワード管理</a>
		    </li>
		</c:otherwise>
	</c:choose>
</ul>
