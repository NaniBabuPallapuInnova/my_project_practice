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

	private int enrollmentId;

	private boolean choice;

	private User user;

	private HealthHistory healthHistory;

	Connection connection = null;

	public List<User> users;

	public UserAction() {

	}

	public UserAction(User user, HealthHistory healthHistory) {
		this.user = user;
		this.healthHistory = healthHistory;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public boolean isChoice() {
		return choice;
	}

	public void setChoice(boolean choice) {
		this.choice = choice;
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

			log.info("all users " + result.toString());
			while (result.next()) {
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

				log.info("fetched user data : " + user.toString());

				HealthHistory history = new HealthHistory();

				String query2 = "SELECT * FROM health_history WHERE enrollment_id = ?";
				PreparedStatement statement2 = connection.prepareStatement(query2);
				statement2.setInt(1, user.getEnrollmentId());
				log.info("fetching id, " + result.getInt("enrollment_id"));

				ResultSet resultSet = statement2.executeQuery();

				while (resultSet.next()) {
					history.setHypertension(resultSet.getBoolean("hypertension"));
					history.setDiabetes(resultSet.getBoolean("diabetes"));
					history.setAllergy(resultSet.getBoolean("allergy"));
					history.setSurgery(resultSet.getBoolean("surgery"));
					history.setFamilyMedicalHistory(resultSet.getBoolean("family_medical_history"));

					user.setHealthHistory(history);
				}

				log.info("user data : " + user.toString());
				users.add(user);
			}

			if (!users.isEmpty()) {
				return "success";
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return "failed";
	}

	public String newEnrollment() {

		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false); // when we want to manage transactions manually, especially when we need to
												// execute multiple SQL statements as part of a single transaction. This
												// allows us to ensure data consistency and integrity by committing or
												// rolling back the entire transaction as needed.

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

		return "failed";
	}

	public String loadUserByEnrollmentId() {
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false); // when we want to manage transactions manually, especially when we need to
												// execute multiple SQL statements as part of a single transaction. This
												// allows us to ensure data consistency and integrity by committing or
												// rolling back the entire transaction as needed.

			String query = "SELECT * FROM user WHERE enrollment_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, enrollmentId);
			log.info("enrollment id printing : " + enrollmentId);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new User();
				user.setEnrollmentId(result.getInt("enrollment_id"));
				user.setName(result.getString("name"));
				user.setAge(result.getInt("age"));
				user.setGender(result.getString("gender"));
				user.setOccupation(result.getString("occupation"));
				user.setEmail(result.getString("email"));
				user.setPhoneNumber(result.getString("phone_number"));
				user.setCity(result.getString("city"));
				user.setState(result.getString("state"));

				log.info("fetched user information based on Id : " + user.toString());

				HealthHistory history = new HealthHistory();

				String query2 = "SELECT * FROM health_history WHERE enrollment_id = ?";
				PreparedStatement statement2 = connection.prepareStatement(query2);
				statement2.setInt(1, user.getEnrollmentId());
				log.info("fetching id, " + result.getInt("enrollment_id"));

				ResultSet resultSet = statement2.executeQuery();

				while (resultSet.next()) {
					history.setHypertension(resultSet.getBoolean("hypertension"));
					history.setDiabetes(resultSet.getBoolean("diabetes"));
					history.setAllergy(resultSet.getBoolean("allergy"));
					history.setSurgery(resultSet.getBoolean("surgery"));
					history.setFamilyMedicalHistory(resultSet.getBoolean("family_medical_history"));

					user.setHealthHistory(history);
					log.info("print total user info to update " + user.toString());
				}
			}

			return "success";

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

		return "failed";
	}

	public String updateUserEnrollement() {
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false); // when we want to manage transactions manually, especially when we need to
												// execute multiple SQL statements as part of a single transaction. This
												// allows us to ensure data consistency and integrity by committing or
												// rolling back the entire transaction as needed.

			String query = "UPDATE user SET name = ?, age = ?, gender = ?, occupation = ?, email = ?, phone_number = ?, city = ?, state = ? WHERE enrollment_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			log.info("user details " + user.toString());
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getGender());
			preparedStatement.setString(4, user.getOccupation());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPhoneNumber());
			preparedStatement.setString(7, user.getCity());
			preparedStatement.setString(8, user.getState());
			preparedStatement.setInt(9, user.getEnrollmentId());

			int rows = preparedStatement.executeUpdate();
			log.info("User is updated " + user.toString() + " rows updated " + rows);
			if (rows >= 0) {
				String healthHistoryQuery = "UPDATE health_history SET hypertension=? , diabetes = ?, allergy = ?, surgery = ?, family_medical_history = ? WHERE enrollment_id = ? ";
				PreparedStatement healthHistoryStatement = connection.prepareStatement(healthHistoryQuery);

				log.info("health history details : " + user.getHealthHistory().toString());
				healthHistoryStatement.setBoolean(1, user.getHealthHistory().isHypertension());
				healthHistoryStatement.setBoolean(2, user.getHealthHistory().isDiabetes());
				healthHistoryStatement.setBoolean(3, user.getHealthHistory().isAllergy());
				healthHistoryStatement.setBoolean(4, user.getHealthHistory().isSurgery());
				healthHistoryStatement.setBoolean(5, user.getHealthHistory().isFamilyMedicalHistory());
				healthHistoryStatement.setInt(6, user.getEnrollmentId());

				int rows2 = healthHistoryStatement.executeUpdate();
				if (rows2 >= 0) {
					log.info("User's Health History is also updated  " + user.getHealthHistory().toString()
							+ " rows updated " + rows2);

					connection.commit();
					return "success";
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

		return "failed";
	}

	public String cancelEnrollementOfUser() {
		try {

			log.info("Choice "+isChoice());
			
			if (isChoice()) {

				connection = DBUtils.getConnection();
				connection.setAutoCommit(false); // when we want to manage transactions manually, especially when we
													// need to
													// execute multiple SQL statements as part of a single transaction.
													// This
													// allows us to ensure data consistency and integrity by committing
													// or
													// rolling back the entire transaction as needed.

				String query = "DELETE FROM health_history WHERE enrollment_id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				log.info("DELETING Health History Of User details " + enrollmentId);
				preparedStatement.setInt(1, enrollmentId);

				int rows = preparedStatement.executeUpdate();
				if (rows >= 0) {
					log.info(" User's Health History Has been deleted " + " rows updated " + rows);

					String healthHistoryQuery = "DELETE FROM user WHERE enrollment_id = ?";
					PreparedStatement statement = connection.prepareStatement(healthHistoryQuery);

					log.info("Deleting User's Info : " + " enrollment Id " + enrollmentId);

					statement.setInt(1, enrollmentId);
					int rows2 = statement.executeUpdate();

					if (rows2 >= 0) {
						log.info("User's Health History is also updated  "
								+ " rows updated " + rows2);

						connection.commit();
						return "success";
					}

				}
			} else {
				return "no";
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

		return "failed";
	}

}
