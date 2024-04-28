package com.example.model;

public class HealthHistory {

	private int historyId;
	private int enrollmentId;
	private boolean hypertension;
	private boolean diabetes;
	private boolean allergy;
	private boolean surgery;
	private boolean  familyMedicalHistory;
	
	public HealthHistory() {
		
	}

	public HealthHistory(int historyId, int enrollmentId, boolean hypertension, boolean diabetes, boolean allergy,
			boolean surgery, boolean familyMedicalHistory) {
		super();
		this.historyId = historyId;
		this.enrollmentId = enrollmentId;
		this.hypertension = hypertension;
		this.diabetes = diabetes;
		this.allergy = allergy;
		this.surgery = surgery;
		this.familyMedicalHistory = familyMedicalHistory;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public boolean isHypertension() {
		return hypertension;
	}

	public void setHypertension(boolean hypertension) {
		this.hypertension = hypertension;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isAllergy() {
		return allergy;
	}

	public void setAllergy(boolean allergy) {
		this.allergy = allergy;
	}

	public boolean isSurgery() {
		return surgery;
	}

	public void setSurgery(boolean surgery) {
		this.surgery = surgery;
	}

	public boolean isFamilyMedicalHistory() {
		return familyMedicalHistory;
	}

	public void setFamilyMedicalHistory(boolean familyMedicalHistory) {
		this.familyMedicalHistory = familyMedicalHistory;
	}

	@Override
	public String toString() {
		return "HealthHistory [historyId=" + historyId + ", enrollmentId=" + enrollmentId + ", hypertension="
				+ hypertension + ", diabetes=" + diabetes + ", allergy=" + allergy + ", surgery=" + surgery
				+ ", familyMedicalHistory=" + familyMedicalHistory + "]";
	}

	
	
	
}
