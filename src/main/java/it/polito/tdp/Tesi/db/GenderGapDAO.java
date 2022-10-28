package it.polito.tdp.Tesi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.Tesi.model.Utente;

public class GenderGapDAO {
	
	public List<Utente> getAll(){
		String sql = "SELECT * FROM gender_gap ";
		List<Utente> result = new ArrayList<Utente>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Utente gpg = new Utente(res.getInt("Id"),res.getString("JobTitle"),
						           res.getString("Gender"),res.getInt("Age"),res.getInt("PerfEval"),
						           res.getString("Education"),res.getString("Dept"),
						           res.getInt("Seniority"),res.getInt("BasePay"),res.getInt("Bonus"));
				result.add(gpg);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Utente> getDifferences(){
		String sql = "SELECT * FROM gender_gap ";
		List<Utente> result = new ArrayList<Utente>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Utente gpg = new Utente(res.getInt("Id"),res.getString("JobTitle"),
						           res.getString("Gender"),res.getInt("Age"),res.getInt("PerfEval"),
						           res.getString("Education"),res.getString("Dept"),
						           res.getInt("Seniority"),res.getInt("BasePay"),res.getInt("Bonus"));
				result.add(gpg);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<String> getJobTitles(){
		String sql = "SELECT DISTINCT(jobTitle) FROM gender_gap ORDER BY jobTitle ";
		List<String> result = new ArrayList<String>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				String jobTitle = res.getString("jobTitle");
				result.add(jobTitle);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getTotalNumber(String jobTitle) {
		String sql = "SELECT COUNT(*) as tot FROM gender_gap WHERE jobTitle=? ";
		Connection conn = DBConnect.getConnection();
		int result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getInt("tot");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getFemaleNumber(String jobTitle) {
		String sql = "SELECT COUNT(*) as tot FROM gender_gap WHERE jobTitle=? and Gender='Female' ";
		Connection conn = DBConnect.getConnection();
		int result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getInt("tot");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getMaleNumber(String jobTitle) {
		String sql = "SELECT COUNT(*) as tot FROM gender_gap WHERE jobTitle=? and Gender='Male' ";
		Connection conn = DBConnect.getConnection();
		int result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getInt("tot");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<Double> getAvgFemalePay(String jobTitle) {
		String sql = "SELECT AVG(g.BasePay) as avg, AVG(g.Bonus) as avgB "
				+ "FROM gender_gap g "
				+ "WHERE g.JobTitle=?  AND g.Gender='Female'";
		
		Connection conn = DBConnect.getConnection();
		List<Double> result = new ArrayList<Double>();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result.add(res.getDouble("avg"));
			result.add(res.getDouble("avgB"));
			res.next();
			
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Double> getAvgMalePay(String jobTitle) {
		String sql = "SELECT AVG(g.BasePay) as avg, AVG(g.Bonus) as avgB "
				+ "FROM gender_gap g "
				+ "WHERE g.JobTitle=?  AND g.Gender='Male'";
		
		Connection conn = DBConnect.getConnection();
		List<Double> result = new ArrayList<Double>();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result.add(res.getDouble("avg"));
			result.add(res.getDouble("avgB"));
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public double getAvgFemaleAge(String jobTitle) {
		String sql = "SELECT AVG(g.Age) as avg "
				+ "FROM gender_gap g "
				+ "WHERE g.JobTitle=?  AND g.Gender='Female'";
		
		Connection conn = DBConnect.getConnection();
		double result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getDouble("avg");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public double getAvgMaleAge(String jobTitle) {
		String sql = "SELECT AVG(g.Age) as avg "
				+ "FROM gender_gap g "
				+ "WHERE g.JobTitle=?  AND g.Gender='Male'";
		
		Connection conn = DBConnect.getConnection();
		double result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getDouble("avg");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public double getAvgFemaleSeniority(String jobTitle) {
		String sql = "SELECT AVG(g.Seniority) as avg "
				+ "FROM gender_gap g "
				+ "WHERE g.JobTitle=?  AND g.Gender='Female'";
		
		Connection conn = DBConnect.getConnection();
		double result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getDouble("avg");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public double getAvgMaleSeniority(String jobTitle) {
		String sql = "SELECT AVG(g.Seniority) as avg "
				+ "FROM gender_gap g "
				+ "WHERE g.JobTitle=?  AND g.Gender='Male'";
		
		Connection conn = DBConnect.getConnection();
		double result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getDouble("avg");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	

	public int getNumberMaleEducation(String jobTitle, String education) {
		
		String sql = "SELECT COUNT(*)as count "
				+ "FROM gender_gap g "
				+ "WHERE g.Gender='Male' AND g.JobTitle=? AND g.Education=? ";
		
		Connection conn = DBConnect.getConnection();
		int result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			st.setString(2, education);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getInt("count");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getNumberFemaleEducation(String jobTitle, String education) {
		
		String sql = "SELECT COUNT(*)as count "
				+ "FROM gender_gap g "
				+ "WHERE g.Gender='Female' AND g.JobTitle=? AND g.Education=? ";
		
		Connection conn = DBConnect.getConnection();
		int result;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, jobTitle);
			st.setString(2, education);
			ResultSet res = st.executeQuery();
			res.next();
			result = res.getInt("count");
	        res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}



}
