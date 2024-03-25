package com.example.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<User> users;
	
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
	
	
	public String retriveUsers() {
		
		try {
			
			connection = DBUtils.getConnection();
			
			String query = "SELECT * FROM user";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet result = statement.executeQuery();
			
			users = new ArrayList<>();
			
			log.info("all users "+result.toString());
			while(result.next()) {
				User user = new User();
				
                user.setEnrollmentId(result.getInt("enrollment_id"));
                user.setName(result.getString("name"));
                user.setAge(result.getInt("age"));
                user.setGender(result.getString("gender"));
                user.setOccupation(result.getString("occupation"));
                user.setEmail(result.getString("email"));
                user.setPhoneNumber(result.getString("phone_number"));
                user.setCity(result.getString("city"));
                user.setState(result.getString("state"));
                
                log.info("fetched user data : "+user.toString());

                
                HealthHistory history = new HealthHistory();
                
    			String query2 = "SELECT * FROM health_history WHERE enrollment_id = ?";
    			PreparedStatement statement2 = connection.prepareStatement(query2);
    			statement2.setInt(1, user.getEnrollmentId());
    			log.info("fetching id, "+result.getInt("enrollment_id"));
    			
    			ResultSet resultSet = statement2.executeQuery();

    			
    			while(resultSet.next()) {
    				history.setHypertension(resultSet.getBoolean("hypertension"));
    				history.setDiabetes(resultSet.getBoolean("diabetes"));
    				history.setAllergy(resultSet.getBoolean("allergy"));
    				history.setSurgery(resultSet.getBoolean("surgery"));
    				history.setFamilyMedicalHistory(resultSet.getBoolean("family_medical_history"));
    				
    				user.setHealthHistory(history);
    			}

                
                log.info("user data : "+user.toString());
                users.add(user);
			}
			
			if(!users.isEmpty()) {
				return "success";
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return "failed";
	}

	public String newEnrollment() {

	    try {
	        connection = DBUtils.getConnection();
	        connection.setAutoCommit(false); // when we want to manage transactions manually, especially when we need to execute multiple SQL statements as part of a single transaction. This allows us to ensure data consistency and integrity by committing or rolling back the entire transaction as needed.

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

	                healthHistoryStatement.setInt(1, enrolmentId);
	                healthHistoryStatement.setBoolean(2, healthHistory.isHypertension());
	                healthHistoryStatement.setBoolean(3, healthHistory.isDiabetes());
	                healthHistoryStatement.setBoolean(4, healthHistory.isAllergy());
	                healthHistoryStatement.setBoolean(5, healthHistory.isSurgery());
	                healthHistoryStatement.setBoolean(6, healthHistory.isFamilyMedicalHistory());

	                int rows2 = healthHistoryStatement.executeUpdate();
	                if (rows2 > 0) {
	                    connection.commit();
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
