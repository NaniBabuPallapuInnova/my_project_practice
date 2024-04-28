<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Enrollment Form</title>
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<s:form action="cancelUserEnrollment" method="POST">
    <s:hidden name="enrollmentId" value="%{enrollmentId}" />
    <s:radio label="Do you want to proceed with cancel enrollment?" name="choice" list="#{'true':'Yes','false':'No'}"/>
    <s:submit value="Submit"/>
</s:form>

</body>
</html>