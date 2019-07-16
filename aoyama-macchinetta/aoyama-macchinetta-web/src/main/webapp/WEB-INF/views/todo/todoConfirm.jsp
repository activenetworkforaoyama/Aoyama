<script type="text/javascript">

var contextPath = $("meta[name='contextPath']").attr("content");

$(document).ready(function(){
	  $("#create").click(function(){

		alert("cr");
		$("#todoForm)").attr('action', contextPath + '/todo/create?form');

	  });
	  $("#delete").click(function(){

		alert("del");
		$("#todoForm)").attr('action', contextPath + '/todo/delete/${todoForm.todoId}');

	  });

	  $("#update").click(function(){

		alert("up");
		$("#todoForm)").attr('action', contextPath + '/todo/update/${todoForm.todoId}');

	  });

	});

</script>
<form:form modelAttribute="todoForm" method="post" action="${pageContext.request.contextPath}/todo/create?form">
		<div>
			<p  id="Confirm">Confirm gamen </p>
		</div>
		<table>
		
			<tr>
				<td>TodoId:</td>
				<td>
					<form:label path="todoId">${todoForm.todoId}</form:label>
        			<form:hidden path="todoId"/>
        			<br>
				</td>
			</tr>
			<tr>
				<td>TodoTitle:</td>
				<td>
					<form:label path="todoTitle">${todoForm.todoTitle}</form:label>
        			<form:hidden path="todoTitle"/>
        			<br>
				</td>
			</tr>
			<tr>
				<td><form:button name="confirm">Confirm</form:button></td>
			</tr>
		</table>

</form:form>


