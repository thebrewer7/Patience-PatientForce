package com.revature.beans;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "History")
public class History {
	@Id
	@Column(name = "history_id")
	@SequenceGenerator(sequenceName = "history_seq", name = "history_seq")
	@GeneratedValue(generator = "history_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "history_age")
	private Integer age;
	@Column(name = "history_weight")
	private Integer weight;
	@Column(name = "history_height")
	private Integer height;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "history_id")
	private BloodPressure bloodPressure;
	@Column(name = "history_bloodPressureCondition")
	private String bloodPressureCondition;
	@Column(name = "history_treatments")
	private List<String> treatments;
	@Column(name = "history_diagnoses")
	private List<String> diagnoses;
	@Column(name = "history_medication")
	private List<String> medication;
	@Column(name = "history_vaccinations")
	private List<String> vaccinations;

	public static final List<String> bpCategories = Arrays.asList("Normal", "Elevated",
			"High Blood Pressure (HyperTension) Stage 1", "High Blood Pressure (Hypertension) Stage 2",
			"Hypertensive Crisis");

	public History() {
		super();
	}

	public History(Integer id, Integer age, Integer weight, Integer height, BloodPressure bloodPressure,
			String bloodPressureCondition, List<String> treatments, List<String> diagnoses, List<String> medication,
			List<String> vaccinations) {
		super();
		this.id = id;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.bloodPressure = bloodPressure;
		this.bloodPressureCondition = bloodPressureCondition;
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
		return bloodPressureCondition;
	}

	public void setBloodPressureCondition(String bloodPressureCondition) {
		this.bloodPressureCondition = bloodPressureCondition;
	}

	public List<String> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<String> treatments) {
		this.treatments = treatments;
	}

	public List<String> getDiagnoses() {
		return diagnoses;
	}

	public void setDiagnoses(List<String> diagnoses) {
		this.diagnoses = diagnoses;
	}

	public List<String> getMedication() {
		return medication;
	}

	public void setMedication(List<String> medication) {
		this.medication = medication;
	}

	public List<String> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<String> vaccinations) {
		this.vaccinations = vaccinations;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", age=" + age + ", weight=" + weight + ", height=" + height + ", bloodPressure="
				+ bloodPressure + ", bloodPressureCondition=" + bloodPressureCondition + ", treatments=" + treatments
				+ ", diagnoses=" + diagnoses + ", medication=" + medication + ", vaccinations=" + vaccinations + "]";
	}

	
}
