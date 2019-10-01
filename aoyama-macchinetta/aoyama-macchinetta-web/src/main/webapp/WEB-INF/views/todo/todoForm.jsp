
<style>

.error-message-list {
    color: #b94a48;
    padding:5px 10px;
    background-color: #fde9f3;
    border:1px solid #c98186;
    border-radius:5px;
    margin-bottom: 10px;
    }
.form-horizontal input {
    display: block;
    float: left;
}

.form-horizontal label {
    display: block;
    float: left;
    text-align: right;
    float: left;
}

.form-horizontal br {
    clear: left;
}

.error-label {
    color: #b94a48;
}

.error-input {
    border-color: #b94a48;
    margin-left: 5px;
}
</style>
<spring:nestedPath path="todoForm">
    <form:errors path="*" element="div"
        cssClass="error-message-list" />
</spring:nestedPath>
<form:form modelAttribute="todoForm" method="post"
        action="${pageContext.request.contextPath}/todo/confirm">
		<div>
			<p  id="todoId">Create gamen </p>
		
		</div>
		
        <form:label path="todoId">TodoId:</form:label>
        <form:input path="todoId" />
        <br>
        <form:label path="todoTitle">TodoTitle:</form:label>
        <form:input path="todoTitle"/>
        <br>
        <form:label path="adjustJacketStandardInfo.corJkBodySize">corJkBodySize:</form:label>
        <form:input path="adjustJacketStandardInfo.corJkBodySize"/>
        <form:button name="confirm">Confirm</form:button>
</form:form>


