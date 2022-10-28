package it.polito.tdp.Tesi.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import it.polito.tdp.Tesi.db.GenderGapDAO;

public class Model {
	
	private GenderGapDAO gpgDAO;
	private int totalNumber;
	private int femaleNumber;
	private int maleNumber;
	private double percentualeFemminile;
	private double percentualeMaschile;
	private double avgFemalePay;
	private double avgMalePay;
	private double avgFemaleBonus;
	private double avgMaleBonus;
	private double avgFemaleAge;
	private double avgMaleAge;
	private double avgFemaleSeniority;
	private double avgMaleSeniority;
	private double percFemaleCollege;
	private double percMaleCollege;
	private double percFemaleHighSchool;
	private double percMaleHighSchool;
	private double percFemaleMasters;
	private double percMaleMasters;
	private double percFemalePhD;
	private double percMalePhD;
	private List<Utente> best;
	List<Utente> utenti;
	List<String> professioniRicercate;
	
	public Model() {
		this.gpgDAO = new GenderGapDAO();
		this.utenti = this.gpgDAO.getAll();
		this.professioniRicercate = new ArrayList<String>();
	}
	
	
	public void Analizza(String jobTitle) {
		
		this.totalNumber = this.gpgDAO.getTotalNumber(jobTitle);
		this.femaleNumber = this.gpgDAO.getFemaleNumber(jobTitle);
		this.maleNumber = this.gpgDAO.getMaleNumber(jobTitle);
		this.percentualeFemminile = ((double)(femaleNumber)/(double)(totalNumber))*100;
		this.percentualeMaschile = ((double)(maleNumber)/(double)(totalNumber))*100;
		this.avgFemalePay = this.gpgDAO.getAvgFemalePay(jobTitle).get(0);
		this.avgMalePay = this.gpgDAO.getAvgMalePay(jobTitle).get(0);
		this.avgFemaleBonus = this.gpgDAO.getAvgFemalePay(jobTitle).get(1);
		this.avgMaleBonus = this.gpgDAO.getAvgMalePay(jobTitle).get(1);
		this.avgFemaleAge = this.gpgDAO.getAvgFemaleAge(jobTitle);
		this.avgMaleAge = this.gpgDAO.getAvgMaleAge(jobTitle);
		this.avgFemaleSeniority = this.gpgDAO.getAvgFemaleSeniority(jobTitle);
		this.avgMaleSeniority = this.gpgDAO.getAvgMaleSeniority(jobTitle);
		this.percFemaleCollege = (double)(this.gpgDAO.getNumberFemaleEducation(jobTitle, "College"))/(double)(this.femaleNumber)*100;
		this.percMaleCollege = (double)(this.gpgDAO.getNumberMaleEducation(jobTitle, "College"))/(double)(this.maleNumber)*100;
		this.percFemaleHighSchool = (double)(this.gpgDAO.getNumberFemaleEducation(jobTitle, "High School"))/(double)(this.femaleNumber)*100;
		this.percMaleHighSchool = (double)(this.gpgDAO.getNumberMaleEducation(jobTitle, "High School"))/(double)(this.maleNumber)*100;
		this.percFemaleMasters = (double)(this.gpgDAO.getNumberFemaleEducation(jobTitle, "Masters"))/(double)(this.femaleNumber)*100;
		this.percMaleMasters = (double)(this.gpgDAO.getNumberMaleEducation(jobTitle, "Masters"))/(double)(this.maleNumber)*100;
		this.percFemalePhD = (double)(this.gpgDAO.getNumberFemaleEducation(jobTitle, "PhD"))/(double)(this.femaleNumber)*100;
		this.percMalePhD = (double)(this.gpgDAO.getNumberMaleEducation(jobTitle, "PhD"))/(double)(this.maleNumber)*100;
	}
	
	public List<Utente> cercaTeamWork(List<String> professioniRicercate) {
		
		this.best=new ArrayList<Utente>();
		List<Utente> parziale = new ArrayList<Utente>();
		this.professioniRicercate = professioniRicercate;
		List<String> professioniRicercateModificabile = new ArrayList<String>(professioniRicercate);
		Iterator<Utente> itr = utenti.iterator();
		
		while(itr.hasNext()) {
			Utente u = itr.next();
			if(!professioniRicercate.contains(u.getJobTitle())) {
				itr.remove();
			}
		}
		
		Collections.sort(utenti);
		ricorsione(parziale, professioniRicercateModificabile,0);
		
		return best;
	}
	
	private void ricorsione(List<Utente> parziale, List<String> professioniRicercateModificabile, int livello){
		
		
		// condizione di terminazione
		if(professioniRicercateModificabile.size()==0) {
			// controllo se tale soluzione è la migliore
			if(calcolaTotScore(parziale)>calcolaTotScore(best)) {
				this.best = new ArrayList<Utente>(parziale);
				System.out.println(calcolaTotScore(best)+"\n");
			}
		}
		
		if(this.utenti.size()==livello) {
			return;
		}
		
		if(calcolaTotScore(best)==(this.professioniRicercate.size())*5) {
			return;
		}
		
		
		if(professioniRicercateModificabile.contains(utenti.get(livello).getJobTitle()) && utenti.get(livello).getSeniority()>3) {
			//provo ad aggiungere
			parziale.add(utenti.get(livello));
			professioniRicercateModificabile.remove(utenti.get(livello).getJobTitle());
			ricorsione(parziale,professioniRicercateModificabile, livello+1);
			
			// provo a non aggiungere
			professioniRicercateModificabile.add(parziale.get(parziale.size()-1).getJobTitle());
			parziale.remove(parziale.size()-1);
			ricorsione(parziale,professioniRicercateModificabile,livello+1);
		}
		
		ricorsione(parziale,professioniRicercateModificabile,livello+1);
		
	
	}
	
	private int calcolaTotScore(List<Utente> parziale) {
		
		int totScore=0;
		for(Utente u : parziale) {
			totScore+=u.getPerfEval();
		}
		return totScore;
	}


	public List<String> getJobTitles(){
		return this.gpgDAO.getJobTitles();
	}


	public int getTotalNumber() {
		return totalNumber;
	}

	public int getFemaleNumber() {
		return femaleNumber;
	}

	public int getMaleNumber() {
		return maleNumber;
	}

	public double getPercentualeFemminile() {
		return  Math.round(percentualeFemminile*100.0)/100.0;
	}

	public double getPercentualeMaschile() {
		return  Math.round(percentualeMaschile*100.0)/100.0;
	}

	public double getAvgFemalePay() {
		return avgFemalePay;
	}

	public double getAvgMalePay() {
		return avgMalePay;
	}

	public double getAvgFemaleBonus() {
		return avgFemaleBonus;
	}

	public double getAvgMaleBonus() {
		return avgMaleBonus;
	}

	public double getAvgFemaleAge() {
		return avgFemaleAge;
	}

	public double getAvgMaleAge() {
		return avgMaleAge;
	}

	public double getAvgFemaleSeniority() {
		return avgFemaleSeniority;
	}

	public double getAvgMaleSeniority() {
		return avgMaleSeniority;
	}


	public double getPercFemaleCollege() {
		return  Math.round(percFemaleCollege*100.0)/100.0;
	}


	public double getPercMaleCollege() {
		return  Math.round(percMaleCollege*100.0)/100.0;
	}


	public double getPercFemaleHighSchool() {
		return  Math.round(percFemaleHighSchool*100.0)/100.0;
	}


	public double getPercMaleHighSchool() {
		return  Math.round(percMaleHighSchool*100.0)/100.0;
	}


	public double getPercFemaleMasters() {
		return  Math.round(percFemaleMasters*100.0)/100.0;
	}


	public double getPercMaleMasters() {
		return  Math.round(percMaleMasters*100.0)/100.0;
	}


	public double getPercFemalePhD() {
		return  Math.round(percFemalePhD*100.0)/100.0;
	}


	public double getPercMalePhD() {
		return  Math.round(percMalePhD*100.0)/100.0;
	}


}
