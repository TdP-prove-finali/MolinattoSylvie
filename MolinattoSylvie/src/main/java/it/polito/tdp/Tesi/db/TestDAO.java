package it.polito.tdp.Tesi.db;


public class TestDAO {
	
	public static void main(String[] args) {
	GenderGapDAO dao = new GenderGapDAO();
	System.out.println(dao.getAll().size());
	System.out.println(dao.getJobTitles());
	
	}
}
