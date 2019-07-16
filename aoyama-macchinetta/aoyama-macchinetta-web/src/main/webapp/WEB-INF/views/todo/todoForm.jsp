<form:form modelAttribute="todoForm" method="post"
        action="${pageContext.request.contextPath}/todo/confirm">
		<div>
			<p  id="todoId">Create gamen </p>
		
		</div>
        <form:label path="todoId">TodoId:</form:label>
        <form:input path="todoId" />
        <br>
        <form:label path="todoTitle">TodoTitle:</form:label>
        <form:input path="todoTitle" />

        <br>
        <form:button name="confirm">Confirm</form:button>
</form:form>


