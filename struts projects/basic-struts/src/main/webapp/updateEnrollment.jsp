<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Enrollment Form</title>
</head>
<body>


    <s:form action="updateUserInfo" method="post">
        <s:textfield  label="Enrollment Id" name="user.enrollmentId"  value="%{user.enrollmentId}" disabled="true" />
        <s:textfield label="Name" name="user.name" value="%{user.name}" />
        <s:textfield label="Age" name="user.age" value="%{user.age}" />
        <s:textfield label="Gender" name="user.gender" value="%{user.gender}" />
        <s:textfield label="Occupation" name="user.occupation" value="%{user.occupation}" />
        <s:textfield label="Email" name="user.email" value="%{user.email}" />
        <s:textfield label="Phone Number" name="user.phoneNumber" value="%{user.phoneNumber}" />
        <s:textfield label="City" name="user.city" value="%{user.city}" />
        <s:textfield label="State" name="user.state"  value="%{user.state}"/>
        
        <s:radio label="Hypertension" name="user.healthHistory.hypertension" value="%{user.healthHistory.hypertension}" list="#{'true':'Yes', 'false':'No'}" />
        <s:radio label="Diabetes" name="user.healthHistory.diabetes" value="%{user.healthHistory.diabetes}" list="#{'true':'Yes', 'false':'No'}" />
        <s:radio label="Allergy" name="user.healthHistory.allergy" value="%{user.healthHistory.allergy}" list="#{'true':'Yes', 'false':'No'}" />
        <s:radio label="Surgery" name="user.healthHistory.surgery" value="%{user.healthHistory.surgery}" list="#{'true':'Yes', 'false':'No'}" />
        <s:radio label="Family Medical History" name="user.healthHistory.familyMedicalHistory" value="%{user.healthHistory.familyMedicalHistory}" list="#{'true':'Yes', 'false':'No'}" />
        
        <s:submit value="Submit" />
    </s:form>

</body>
</html>