<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <%@ page import="imcs.core.mo --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>



	<c:choose>
		<c:when test="${requestScope.pageType eq 'updateOperFrmDept'}">
			<form:form action="${contextPath}/employee/updateEmployee"
				modelAttribute="empForm" method="post">
				<table class="table table-hover">
					<tr style="display: none">
						<th>Hidden Val to go for Dept</th>
						<td><input class="requiredAttr" name="hiddenValForDept"
							id="hiddenValForDept" type="text" value="empFormToDept"></td>
					</tr>

					<tr style="display: none">
						<th>ID</th>
						<td><input class="requiredAttr" name="id" id="uid"
							type="text" value="${eInfo.id}"></td>
					</tr>

					<tr>
						<th>Name</th>
						<td><input class="requiredAttr" name="name" id="uname"
							type="text" value="${eInfo.name}" required></td>
					</tr>

					<tr>
						<th>UserName</th>
						<td><input class="requiredAttr" name="username" id="username"
							type="text" value="${eInfo.username}" required></td>
					</tr>

					<tr style="display: none">
						<th>Password</th>
						<td><input class="requiredAttr" name="password" id="password"
							type="password" value="${eInfo.password}" required></td>
					</tr>



					<tr>
						<th>Age</th>
						<td><input class="requiredAttr" name="age" id="uage"
							type="number" value="${eInfo.age}" required></td>
					</tr>
					<tr>
						<th>DOB</th>
						<td><input class="requiredAttr" type="date"
							name="dateOfBirth" id="udob"
							value=<fmt:formatDate pattern='yyyy-MM-dd' value='${eInfo.dateOfBirth}'/>
							required></td>
					</tr>

					<tr>
						<th>DOJ</th>
						<td><input class="requiredAttr" type="date"
							name="dateOfJoining" id="udoj"
							value=<fmt:formatDate pattern='yyyy-MM-dd' value='${eInfo.dateOfJoining}'/>
							required></td>
					</tr>

					<tr>
						<th>Salary</th>
						<td><input class="requiredAttr" type="number" name="salary"
							id="usalary" value="${eInfo.salary}" required></td>
					</tr>
					<tr>
						<th>Salary Grade</th>
						<td><input class="requiredAttr" type="number"
							name="salaryGrade" id="usalarygrade" value="${eInfo.salaryGrade}"
							required></td>

					</tr>

					<tr>
						<th>Dept ID</th>
						<td><input class="requiredAttr" type="number" name="deptId"
							id="udeptid" value="${eInfo.deptId}" required></td>
					</tr>
					<%-- <tr>
						<th>Dept Name</th>
						<td><input class="requiredAttr" type="text" name="udeptname"
							id="udeptname" value="${requestScope.eInfo.deptName}" required></td>
					</tr> --%>

					<tr>

						<td><input id="save" type="submit" class="btn btn-info"
							value="Save"></td>
					</tr>


				</table>
			</form:form>

			<c:if test="${status}">
				<form action="${contextPath}/employee/delete" method="post">
					<div style="display: none">
						<tr style="display: none">
							<td><input class="requiredAttr" name="hiddenValForDelete"
								id="hiddenValForDelete" type="text" value="empFormDeptDelete"></td>
						</tr>
					</div>

					<div style="display: none">
						<tr>
							<td><input class="requiredAttr" name="deleteId"
								id="deleteId" type="text" value="${eInfo.id}"></td>
						</tr>
					</div>

					<div style="display: none">
						<tr>
							<th>Dept ID</th>
							<td><input class="requiredAttr" type="number" name="deptId"
								id="deptId" value="${eInfo.deptId}" required></td>
						</tr>
					</div>

					<div id="deletediv" class="col-sm-6">
						<tr>
							<input id="delete" type="submit" class="btn btn-info"
								value="Delete">
						</tr>
					</div>
				</form>

			</c:if>



		</c:when>
		<c:otherwise>
			<form:form action="${contextPath}/employee/updateEmployee"
				commandName="updateForm" method="post">

				<table class="table table-hover">

					<tr>
						<td><input type="hidden" id="hiddenValForDept"
							name="hiddenValForDept" value="hiddenValForEmp" />
						<td>
					</tr>

					<tr style="display: none">
						<th>ID</th>
						<td><input class="requiredAttr" name="id" id="uid"
							type="text" value="${eInfo.id}"></td>
					</tr>

					<tr>
						<th>Name</th>
						<td><input class="requiredAttr" name="name" id="uname"
							type="text" value="${eInfo.name}" disabled="disabled" required></td>
					</tr>

					<tr>
						<th>UserName</th>
						<td><input class="requiredAttr" name="username" id="username"
							type="text" value="${eInfo.username}" disabled="disabled"
							required></td>
					</tr>

					<tr style="display: none">
						<th>Password</th>
						<td><input class="requiredAttr" name="password" id="password"
							type="password" value="${eInfo.password}" required></td>
					</tr>

					<tr>
						<th>Age</th>
						<td><input class="requiredAttr" name="age" id="uage"
							type="number" value="${eInfo.age}" disabled="disabled" required></td>
					</tr>
					<tr>
						<th>DOB</th>
						<td><input class="requiredAttr" type="date"
							name="dateOfBirth" id="udob"
							value=<fmt:formatDate pattern='yyyy-MM-dd' value='${eInfo.dateOfBirth}'/>
							disabled="disabled" required></td>
					</tr>

					<tr>
						<th>DOJ</th>
						<td><input class="requiredAttr" type="date"
							name="dateOfJoining" id="udoj"
							value=<fmt:formatDate pattern='yyyy-MM-dd' value='${eInfo.dateOfJoining}'/>
							disabled="disabled" required></td>
					</tr>

					<tr>
						<th>Salary</th>
						<td><input class="requiredAttr" type="number" name="salary"
							id="usalary" value="${eInfo.salary}" disabled="disabled" required></td>
					</tr>
					<tr>
						<th>Salary Grade</th>
						<td><input class="requiredAttr" type="number"
							name="salaryGrade" id="usalarygrade" value="${eInfo.salaryGrade}"
							disabled="disabled" required></td>

					</tr>

					<tr>
						<th>Dept ID</th>
						<td><input class="requiredAttr" type="number" name="deptId"
							id="udeptid" value="${eInfo.deptId}" disabled="disabled" required></td>
					</tr>
					<%-- 	<tr>
						<th>Dept Name</th>
						<td><input class="requiredAttr" type="text" name="udeptname"
							id="udeptname" value="${requestScope.eInfo.deptName}"
							disabled="disabled" required></td>
					</tr>
 --%>
					<tr>

						<td><input id="save" style="display: none" type="submit"
							class="btn btn-info" value="Save"></td>
					</tr>

					<tr>
						<td><label id="update" class="btn btn-info">Update</label></td>
					</tr>


				</table>


			</form:form>

		</c:otherwise>
	</c:choose>


	<c:if test="${status}">
		<form action="${contextPath}/employee/delete" method="post">

			<tr>
				<td><input type="hidden" class="requiredAttr"
					name="hiddenValForDelete" id="hiddenValForDelete" value="xyz"></td>
			</tr>
			<div style="display: none">
				<tr>
					<td><input class="requiredAttr" name="deleteId" id="deleteId"
						type="text" value="${requestScope.eInfo.id}"></td>
				</tr>
			</div>
			<div style="display: none">
				<tr>
					<th>Dept ID</th>
					<td><input class="requiredAttr" type="number" name="deptId"
						id="deptId" value="${eInfo.deptId}" required></td>
				</tr>
			</div>


			<div id="deletediv" style="display: none" class="col-sm-6">
				<tr>
					<input id="delete" type="submit" class="btn btn-info"
						value="Delete">
				</tr>
			</div>
		</form>

	</c:if>




</body>

<script>
	$(document).ready(function() {
		$("#update").click(function() {
			$("#uname").removeAttr("disabled")
			$("#username").removeAttr("disabled")
			$("#uage").removeAttr("disabled")
			$("#udob").removeAttr("disabled")
			$("#udoj").removeAttr("disabled")
			$("#usalary").removeAttr("disabled")
			$("#usalarygrade").removeAttr("disabled")
			$("#udeptid").removeAttr("disabled")
			$("#udeptname").removeAttr("disabled")
			$("#save").show()
			$("#deletediv").show()
			$("#update").hide()

		});
	});
</script>
</html>