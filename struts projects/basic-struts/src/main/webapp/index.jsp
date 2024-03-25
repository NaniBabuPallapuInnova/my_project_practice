<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Basic Struts 2 Application - Welcome</title>

<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.table-wrapper {
	margin-left: 0;
}
</style>
</head>
<body>
	<h1>This is first Struts Application! Click below link to view
		message</h1>

	<p>
		<a href="<s:url action='hello'/>">View Message</a>
	</p>


	<a type="button" class="btn btn-primary" href="enrollForm">New
		Enrollment</a>

	<br>
	<br>
	<h3>All Users Info</h3>
	<div class="container table-wrapper">
		<table class="table table-sm table-bordered table-hover table-striped">

			<thead class="thead-dark">
				<tr>
					<th>Enrollment ID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Occupation</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>City</th>
					<th>State</th>
					<th>HyperTension</th>
					<th>Diabetes</th>
					<th>Allergy</th>
					<th>Surgery</th>
					<th>FMH</th>
					<!-- FamilyMedicalHistory -->
					<th>UPDATE</th>
					<th>DELETE</th>
				</tr>
			</thead>

			<tbody>

				<s:iterator value="users">
					<tr>
						<td><s:property value="enrollmentId" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="age" /></td>
						<td><s:property value="gender" /></td>
						<td><s:property value="occupation" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="phoneNumber" /></td>
						<td><s:property value="city" /></td>
						<td><s:property value="state" /></td>
						<td><s:property value="healthHistory.hypertension" /></td>
						<td><s:property value="healthHistory.diabetes" /></td>
						<td><s:property value="healthHistory.allergy" /></td>
						<td><s:property value="healthHistory.surgery" /></td>
						<td><s:property value="healthHistory.familyMedicalHistory" /></td>
						<td><a class="btn btn-info" href="updateForm?enrollmentId=<s:property value="enrollmentId" />">Update Info</a></td>
						<td><a class="btn btn-danger" href="deleteForm?enrollmentId=<s:property value="enrollmentId" />">Cancel Enrollment</a></td>
					</tr>

				</s:iterator>
			</tbody>
		</table>
	</div>


	<!-- Bootstrap JS (optional, if needed) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>