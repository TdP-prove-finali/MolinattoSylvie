package it.polito.tdp.Tesi.model;

import java.util.Comparator;
import java.util.Objects;

public class Utente implements Comparable<Utente>{

	int id;
	String jobTitle;
	String gender;
	int age;
	int perfEval;
	String education;
	String dept;
	int seniority;
	int basePay;
	int bonus;
	
	
	public Utente(int id, String jobTitle, String gender, int age, int perfEval, String education, String dept,
			int seniority, int basePay, int bonus) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.gender = gender;
		this.age = age;
		this.perfEval = perfEval;
		this.education = education;
		this.dept = dept;
		this.seniority = seniority;
		this.basePay = basePay;
		this.bonus = bonus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPerfEval() {
		return perfEval;
	}
	public void setPerfEval(int perfEval) {
		this.perfEval = perfEval;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public int getBasePay() {
		return basePay;
	}
	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return  id + ", " + jobTitle + ", "+ gender + ", " + age
				+ ", " + perfEval + ", " + education + ", " + dept + ", " + seniority
				+ ", " + basePay + ", " + bonus;
	}

	@Override
	public int compareTo(Utente o) {
		// TODO Auto-generated method stub
		return o.getPerfEval()-this.getPerfEval();
	}
	
	
}
