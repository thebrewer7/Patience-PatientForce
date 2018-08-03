package com.revature.beans.history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BloodPressure {
	@Id
	@SequenceGenerator(sequenceName = "bloodPressure_seq", name = "bloodPressure_seq")
	@GeneratedValue(generator = "bloodPressure_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private Integer systolic_top;
	private Integer diastolic_bottom;

	public BloodPressure() {
		super();
	}

	public BloodPressure(Integer systolic_top, Integer diastolic_bottom) {
		this.systolic_top = systolic_top;
		this.diastolic_bottom = diastolic_bottom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSystolic_top() {
		return systolic_top;
	}

	public void setSystolic_top(Integer systolic_top) {
		this.systolic_top = systolic_top;
	}

	public Integer getDiastolic_bottom() {
		return diastolic_bottom;
	}

	public void setDiastolic_bottom(Integer diastolic_bottom) {
		this.diastolic_bottom = diastolic_bottom;
	}

	@Override
	public String toString() {
		return "BloodPressure [id=" + id + ", systolic_top=" + systolic_top + ", diastolic_bottom=" + diastolic_bottom
				+ "]";
	}
}
