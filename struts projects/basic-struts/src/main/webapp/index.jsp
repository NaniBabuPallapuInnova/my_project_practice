<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
	<h1>This is first Struts Application! Click below link to view
		message</h1>

	<p>
		<a href="<s:url action='hello'/>">View Message</a>
	</p>

    <a href="enrollForm">New Enrollment</a>
    <a href="updateForm">Update Enrollment</a>
    <a href="deleteForm">Delete Enrollment</a>


</body>
</html>