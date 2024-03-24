package com.example.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.model.HealthHistory;
import com.example.model.User;
import com.example.utils.DBUtils;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private static final Logger log = LogManager.getLogger(UserAction.class);
	  

	private User user;

	private HealthHistory healthHistory;

	Connection connection = null;
	
	public UserAction() {
		
	}

	public UserAction( User user, HealthHistory healthHistory) {
		this.user = user;
		this.healthHistory = healthHistory;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HealthHistory getHealthHistory() {
		return healthHistory;
	}

	public void setHealthHistory(HealthHistory healthHistory) {
		this.healthHistory = healthHistory;
	}

	public String newEnrollment() {

	    try {
	        connection = DBUtils.getConnection();
	        connection.setAutoCommit(false); // Disable autocommit

	        String query = "INSERT INTO user (name, age, gender, occupation, email, phone_number, city, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

	        log.info("user details " + user.toString());
	        preparedStatement.setString(1, user.getName());
	        preparedStatement.setInt(2, user.getAge());
	        preparedStatement.setString(3, user.getGender());
	        preparedStatement.setString(4, user.getOccupation());
	        preparedStatement.setString(5, user.getEmail());
	        preparedStatement.setString(6, user.getPhoneNumber());
	        preparedStatement.setString(7, user.getCity());
	        preparedStatement.setString(8, user.getState());

	        int rows = preparedStatement.executeUpdate();
	        if (rows > 0) {
	            ResultSet result = preparedStatement.getGeneratedKeys();
	            int enrolmentId = -1;
	            if (result.next()) {
	                enrolmentId = result.getInt(1);
	                String healthHistoryQuery = "INSERT INTO health_history (enrollment_id, hypertension, diabetes, allergy, surgery, family_medical_history) VALUES (?, ?, ?, ?, ?, ?)";
	                PreparedStatement healthHistoryStatement = connection.prepareStatement(healthHistoryQuery);

	                healthHistoryStatement.setInt(1, enrolmentId); // Use enrolmentId obtained from user insertion
	                healthHistoryStatement.setBoolean(2, healthHistory.isHypertension());
	                healthHistoryStatement.setBoolean(3, healthHistory.isDiabetes());
	                healthHistoryStatement.setBoolean(4, healthHistory.isAllergy());
	                healthHistoryStatement.setBoolean(5, healthHistory.isSurgery());
	                healthHistoryStatement.setBoolean(6, healthHistory.isFamilyMedicalHistory());

	                int rows2 = healthHistoryStatement.executeUpdate();
	                if (rows2 > 0) {
	                    connection.commit();
	                    DBUtils.closeConnection(connection);
	                    return "success";
	                }
	            }
	        }
	    } catch (SQLException e) {
	        try {
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (connection != null) {
	                connection.setAutoCommit(true);
	                DBUtils.closeConnection(connection);
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    return "failure";
	}


}
