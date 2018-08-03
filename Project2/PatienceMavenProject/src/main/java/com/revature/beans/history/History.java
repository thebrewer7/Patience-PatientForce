package com.revature.beans.history;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.revature.enums.BpCategories;

@Entity
public class History {
	@Id
	@SequenceGenerator(sequenceName = "history_seq", name = "history_seq")
	@GeneratedValue(generator = "history_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToOne
	private BloodPressure bloodPressure;

	@OneToMany
	private List<Treatment> treatments;
	@OneToMany
	private List<Diagnosis> diagnoses;
	@OneToMany
	private List<Medication> medication;
	@OneToMany
	private List<Vaccination> vaccinations;

	private Integer age;
	private Integer weight;
	private Integer height;
	private String bpCondition;

	public History() {
		super();
	}

	/**
	 * 
	 * @param age Integer
	 * @param weight Integer
	 * @param height Integer
	 * @param bloodPressure BloodPressure
	 * @param bpCondition BpConditions
	 * @param treatments Treatment
	 * @param diagnoses Diagnosis
	 * @param medication Medication
	 * @param vaccinations Vaccination
	 */
	public History(Integer age, Integer weight, Integer height, BloodPressure bloodPressure, BpCategories bpCondition,
			List<Treatment> treatments, List<Diagnosis> diagnoses, List<Medication> medication,
			List<Vaccination> vaccinations) {
		super();
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.bloodPressure = bloodPressure;
		this.bpCondition = bpCondition.toString();
		this.treatments = treatments;
		this.diagnoses = diagnoses;
		this.medication = medication;
		this.vaccinations = vaccinations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public BloodPressure getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(BloodPressure bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getBloodPressureCondition() {
		return bpCondition;
	}

	public void setBloodPressureCondition(String bloodPressureCondition) {
		this.bpCondition = bloodPressureCondition;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public List<Diagnosis> getDiagnoses() {
		return diagnoses;
	}

	public void setDiagnoses(List<Diagnosis> diagnoses) {
		this.diagnoses = diagnoses;
	}

	public List<Medication> getMedication() {
		return medication;
	}

	public void setMedication(List<Medication> medication) {
		this.medication = medication;
	}

	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", age=" + age + ", weight=" + weight + ", height=" + height + ", bloodPressure="
				+ bloodPressure + ", bloodPressureCondition=" + bpCondition + ", treatments=" + treatments
				+ ", diagnoses=" + diagnoses + ", medication=" + medication + ", vaccinations=" + vaccinations + "]";
	}

}
