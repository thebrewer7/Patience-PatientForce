package com.revature.beans.doctor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Represents a doctors background. It contains a doctor's certifications, medical degrees, and past experience.
 * @author Austin
 *
 */
@Entity
public class DocBackground {

	@Id
	@SequenceGenerator(sequenceName = "docBackground_seq", name = "docBackground_seq")
	@GeneratedValue(generator = "docBackground_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@OneToMany(fetch=FetchType.EAGER)
	private List<DocCerts> certifications;
	@OneToMany(fetch=FetchType.EAGER)
	private List<DocDegree> degrees;
	@OneToMany(fetch=FetchType.EAGER)
	private List<DocExperience> experience;

	/**
	 * No-Args Constructor
	 */
	public DocBackground() {
		super();
	}
	
	/**
	 * 
	 * @param certifications
	 * @param degrees
	 * @param experience
	 */
	public DocBackground(List<DocCerts> certifications, List<DocDegree> degrees, List<DocExperience> experience) {
		super();
		this.certifications = certifications;
		this.degrees = degrees;
		this.experience = experience;
	}

	public List<DocCerts> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<DocCerts> certifications) {
		this.certifications = certifications;
	}

	public List<DocDegree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<DocDegree> degrees) {
		this.degrees = degrees;
	}

	public List<DocExperience> getExperience() {
		return experience;
	}

	public void setExperience(List<DocExperience> experience) {
		this.experience = experience;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "DocBackground [id=" + id + ", certifications=" + certifications + ", degrees=" + degrees
				+ ", experience=" + experience + "]";
	}

}
