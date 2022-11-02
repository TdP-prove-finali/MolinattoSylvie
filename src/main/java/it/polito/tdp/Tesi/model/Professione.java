package it.polito.tdp.Tesi.model;

import java.util.Objects;

public class Professione {
	
	String jobTtitle;
	int seniority;
	String education;
	
	public Professione(String jobTtitle, int seniority, String education) {
		super();
		this.jobTtitle = jobTtitle;
		this.seniority = seniority;
		this.education = education;
	}

	public String getJobTtitle() {
		return jobTtitle;
	}
	public void setJobTtitle(String jobTtitle) {
		this.jobTtitle = jobTtitle;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public int hashCode() {
		return Objects.hash(education, jobTtitle, seniority);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professione other = (Professione) obj;
		return Objects.equals(education, other.education) && Objects.equals(jobTtitle, other.jobTtitle)
				&& seniority == other.seniority;
	}

}