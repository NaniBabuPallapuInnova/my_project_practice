<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Enrollment Form</title>
</head>
<body>
    <h1>New Enrollment Form</h1>
    <s:form action="saveEnrollment">
        <s:textfield label="Name" name="user.name" />
        <s:textfield label="Age" name="user.age" />
        <s:textfield label="Gender" name="user.gender" />
        <s:textfield label="Occupation" name="user.occupation" />
        <s:textfield label="Email" name="user.email" />
        <s:textfield label="Phone Number" name="user.phoneNumber" />
        <s:textfield label="City" name="user.city" />
        <s:textfield label="State" name="user.state" />
        
        <s:radio label="Hypertension" name="healthHistory.hypertension" list="#{'true':'Yes', 'false':'No'}" />
        <s:radio label="Diabetes" name="healthHistory.diabetes" list="#{'true':'Yes', 'false':'No'}" />
        <s:radio label="Allergy" name="healthHistory.allergy" list="#{'true':'Yes', 'false':'No'}" />
        <s:radio label="Surgery" name="healthHistory.surgery" list="#{'true':'Yes', 'false':'No'}" />
        <s:radio label="Family Medical History" name="healthHistory.familyMedicalHistory" list="#{'true':'Yes', 'false':'No'}" />
        
        <s:submit value="Submit" />
    </s:form>
</body>
</html>
