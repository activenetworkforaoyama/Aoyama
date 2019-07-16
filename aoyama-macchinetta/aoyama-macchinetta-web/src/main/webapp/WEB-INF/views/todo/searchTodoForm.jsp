
<div>
     <p  id="Search">Todo Data Search</p>
			
    <form:form action="${pageContext.request.contextPath}/todo/list" method="get"
        modelAttribute="todoForm">
        <form:input path="todoTitle" />
        <form:button>Search</form:button>
        <br>
        <c:choose>
	        <c:when test="${page != null && page.totalPages != 0}">
	
			    <table id="maintable">
			        <thead>
			            <tr>
			                <th id="no">No</th>
			                <th id="todoId">TodoId</th>
			                <th id="todoTitle">TodoTitle</th>
			            </tr>
			        </thead>
			        <c:forEach var="article" items="${page.content}" varStatus="rowStatus">
			            <tr>
			                <td id="no">
			                    ${(page.number * page.size) + rowStatus.count}
			                </td>
			                <td id="todoId">
			                    ${f:h(article.todoId)}
			                </td>
			                <td id="todoTitle">
			                    ${f:h(article.todoTitle)}
			                </td>
			            </tr>
			        </c:forEach>
			
			    </table>
			</c:when>
        <c:otherwise>
        
        </c:otherwise>
        </c:choose>

    </form:form>
    

</div>
