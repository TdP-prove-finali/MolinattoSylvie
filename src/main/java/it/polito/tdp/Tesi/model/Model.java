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
	private double percFemale1;
	private double percFemale2;
	private double percFemale3;
	private double percFemale4;
	private double percFemale5;
	private double percMale1;
	private double percMale2;
	private double percMale3;
	private double percMale4;
	private double percMale5;
	private double percFemaleSen1;
	private double percFemaleSen2;
	private double percFemaleSen3;
	private double percFemaleSen4;
	private double percFemaleSen5;
	private double percMaleSen1;
	private double percMaleSen2;
	private double percMaleSen3;
	private double percMaleSen4;
	private double percMaleSen5;
	private List<Utente> best;
	List<Utente> utenti;
	List<Professione> professioniRicercate;
	List<String> education;
	List<Integer> seniority;
	
	public Model() {
		this.gpgDAO = new GenderGapDAO();
		this.utenti = new ArrayList<Utente>();
		this.professioniRicercate = new ArrayList<Professione>();
		this.education = this.gpgDAO.getEducations();
		this.seniority = this.gpgDAO.getSeniorities();
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
		this.percFemale1 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Female",1))/(double)(this.femaleNumber)*100;
		this.percFemale2 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Female",2))/(double)(this.femaleNumber)*100;
		this.percFemale3 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Female",3))/(double)(this.femaleNumber)*100;
		this.percFemale4 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Female",4))/(double)(this.femaleNumber)*100;
		this.percFemale5 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Female",5))/(double)(this.femaleNumber)*100;
		this.percMale1 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Male",1))/(double)(this.maleNumber)*100;
		this.percMale2 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Male",2))/(double)(this.maleNumber)*100;
		this.percMale3 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Male",3))/(double)(this.maleNumber)*100;
		this.percMale4 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Male",4))/(double)(this.maleNumber)*100;
		this.percMale5 = (double)(this.gpgDAO.getNumPerfEvScore(jobTitle,"Male",5))/(double)(this.maleNumber)*100;
		this.percFemaleSen1 = (double)(this.gpgDAO.getNumSeniority(jobTitle, "Female", 1))/(double)(this.femaleNumber)*100;
		this.percFemaleSen2 = (double)(this.gpgDAO.getNumSeniority(jobTitle, "Female", 2))/(double)(this.femaleNumber)*100;
		this.percFemaleSen3 = (double)(this.gpgDAO.getNumSeniority(jobTitle, "Female", 3))/(double)(this.femaleNumber)*100;
		this.percFemaleSen4 = (double)(this.gpgDAO.getNumSeniority(jobTitle, "Female", 4))/(double)(this.femaleNumber)*100;
		this.percFemaleSen5 = (double)(this.gpgDAO.getNumSeniority(jobTitle, "Female", 5))/(double)(this.femaleNumber)*100;
		this.percMaleSen1 = (double)(this.gpgDAO.getNumSeniority(jobTitle,"Male",1))/(double)(this.maleNumber)*100;
		this.percMaleSen2 = (double)(this.gpgDAO.getNumSeniority(jobTitle,"Male",2))/(double)(this.maleNumber)*100;
		this.percMaleSen3 = (double)(this.gpgDAO.getNumSeniority(jobTitle,"Male",3))/(double)(this.maleNumber)*100;
		this.percMaleSen4 = (double)(this.gpgDAO.getNumSeniority(jobTitle,"Male",4))/(double)(this.maleNumber)*100;
		this.percMaleSen5 = (double)(this.gpgDAO.getNumSeniority(jobTitle,"Male",5))/(double)(this.maleNumber)*100;
	}
	
	public List<Utente> cercaTeamWork(List<Professione> professioniRicercate) {
		
		this.utenti = this.gpgDAO.getAll();
		this.best=new ArrayList<Utente>();
		List<Utente> parziale = new ArrayList<Utente>();
		this.professioniRicercate = professioniRicercate;
		List<Professione> professioniRicercateModificabile = new ArrayList<Professione>(professioniRicercate);
		Iterator<Utente> itr = utenti.iterator();
		
		while(itr.hasNext()) {
			Utente u = itr.next();
			if(!professioniRicercate.contains(new Professione(u.getJobTitle(),u.getSeniority(),u.getEducation()))) {
				itr.remove();
			}
		}
		
		Collections.sort(utenti);
		System.out.println("Numero utenti : "+this.utenti.size()+"\n");
		ricorsione(parziale, professioniRicercateModificabile,0);
		System.out.println("Ricorsione terminata!\n");
		for(Utente u : this.best) {
			System.out.println(u+"\n");
		}
		return best;
	}
	
	private void ricorsione(List<Utente> parziale, List<Professione> professioniRicercateModificabile, int livello){
		
		// condizione di terminazione
		if(professioniRicercateModificabile.size()==0) {
			// controllo se tale soluzione è la migliore
			if(calcolaTotScore(parziale)>calcolaTotScore(best)) {
				this.best = new ArrayList<Utente>(parziale);
				System.out.println(calcolaTotScore(best)+"\n");
				for(Utente u : this.best) {
					System.out.println(u+"\n");
				}
			}
			return;
		}
		
		if(this.utenti.size()==livello) {
			return;
		}
		
		if(calcolaTotScore(best)==(this.professioniRicercate.size())*5) {
			return;
			
		} 
		
		if(professioniRicercateModificabile.contains(new Professione(utenti.get(livello).getJobTitle(),utenti.get(livello).getSeniority(),utenti.get(livello).getEducation())) && !parziale.contains(utenti.get(livello))) {
			//provo ad aggiungere
			parziale.add(utenti.get(livello));
			professioniRicercateModificabile.remove(new Professione(utenti.get(livello).getJobTitle(),utenti.get(livello).getSeniority(),utenti.get(livello).getEducation()));
			ricorsione(parziale,professioniRicercateModificabile, livello+1);
			
			// provo a non aggiungere
			professioniRicercateModificabile.add(new Professione(parziale.get(parziale.size()-1).getJobTitle(),parziale.get(parziale.size()-1).getSeniority(), parziale.get(parziale.size()-1).getEducation()));
			parziale.remove(parziale.size()-1);
			ricorsione(parziale,professioniRicercateModificabile,livello+1);
		}
		
		ricorsione(parziale,professioniRicercateModificabile,livello+1);
	}
	
	
	public List<Utente> cercaTeamWorkEquo(List<Professione> professioniRicercate) {
		
		this.utenti = this.gpgDAO.getAll();
		this.best=new ArrayList<Utente>();
		List<Utente> parziale = new ArrayList<Utente>();
		this.professioniRicercate = professioniRicercate;
		List<Professione> professioniRicercateModificabile = new ArrayList<Professione>();
		professioniRicercateModificabile.addAll(professioniRicercate);
		utenti.clear();
		utenti = this.gpgDAO.getAll();
		Iterator<Utente> itr = utenti.iterator();
		
		while(itr.hasNext()) {
			Utente u = itr.next();
			if(!professioniRicercate.contains(new Professione(u.getJobTitle(),u.getSeniority(),u.getEducation()))) {
				itr.remove();
			}
		}
		
		//Collections.sort(utenti);
		System.out.println("Numero utenti : "+this.utenti.size()+"\n");
		ricorsioneEqua(parziale, professioniRicercateModificabile,0);
		System.out.println("Ricorsione terminata!\n");
		for(Utente u : this.best) {
			System.out.println(u+"\n");
		}
		return best;
	}
	
	private void ricorsioneEqua(List<Utente> parziale, List<Professione> professioniRicercateModificabile, int livello){
		
		// condizione di terminazione
		if(professioniRicercateModificabile.size()==0) {
			int score = calcolaTotScore(parziale);
			// controllo se tale soluzione è la migliore
			if(score>calcolaTotScore(best) && soluzioneEqua(parziale)) {
				this.best = new ArrayList<Utente>(parziale);
				System.out.println(calcolaTotScore(best)+"\n");
				for(Utente u : this.best) {
					System.out.println(u+"\n");
				}
				
			}
			return;
		}
		
		if(this.utenti.size()==livello) {
			return;
		}
		
		if(calcolaTotScore(best)==(this.professioniRicercate.size()*5) /*&& soluzioneEqua(parziale)*/) {
			return;
		} 
		
		if(professioniRicercateModificabile.contains(new Professione(utenti.get(livello).getJobTitle(),utenti.get(livello).getSeniority(),utenti.get(livello).getEducation())) && !parziale.contains(utenti.get(livello))) {
			//provo ad aggiungere
			parziale.add(utenti.get(livello));
			professioniRicercateModificabile.remove(new Professione(utenti.get(livello).getJobTitle(),utenti.get(livello).getSeniority(),utenti.get(livello).getEducation()));
			ricorsioneEqua(parziale,professioniRicercateModificabile, livello+1);
			
			// provo a non aggiungere
			professioniRicercateModificabile.add(new Professione(parziale.get(parziale.size()-1).getJobTitle(),parziale.get(parziale.size()-1).getSeniority(), parziale.get(parziale.size()-1).getEducation()));
			parziale.remove(parziale.size()-1);
			ricorsioneEqua(parziale,professioniRicercateModificabile,livello+1);
		}
		
		ricorsioneEqua(parziale,professioniRicercateModificabile,livello+1);
	
	}
	
	private boolean soluzioneEqua(List<Utente> parziale) {
		
		int numDonne=0;
		
		for(Utente u : parziale) {
			if(u.getGender().equals("Female")) {
				numDonne++;
			}
		}
		
		if(numDonne==parziale.size()/2) {
				return true;
		}
		else {
				return false;
			}
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

	public List<String> getEducation() {
		return education;
	}

	public void setEducation(List<String> education) {
		this.education = education;
	}

	public List<Integer> getSeniority() {
		return seniority;
	}

	public void setSeniority(List<Integer> seniority) {
		this.seniority = seniority;
	}

	public double getPercFemale1() {
		return  Math.round(percFemale1*100.0)/100.0;
	}

	public double getPercFemale2() {
		return  Math.round(percFemale2*100.0)/100.0;
	}

	public double getPercFemale3() {
		return  Math.round(percFemale3*100.0)/100.0;
	}

	public double getPercFemale4() {
		return  Math.round(percFemale4*100.0)/100.0;
	}

	public double getPercFemale5() {
		return  Math.round(percFemale5*100.0)/100.0;
	}


	public double getPercMale1() {
		return  Math.round(percMale1*100.0)/100.0;
	}

	public double getPercMale2() {
		return  Math.round(percMale2*100.0)/100.0;
	}

	public double getPercMale3() {
		return  Math.round(percMale3*100.0)/100.0;
	}

	public double getPercMale4() {
		return  Math.round(percMale4*100.0)/100.0;
	}

	public double getPercMale5() {
		return  Math.round(percMale5*100.0)/100.0;
	}
	
	public double getPercFemaleSen1() {
		return  Math.round(percFemaleSen1*100.0)/100.0;
	}

	public double getPercFemaleSen2() {
		return  Math.round(percFemaleSen2*100.0)/100.0;
	}

	public double getPercFemaleSen3() {
		return  Math.round(percFemaleSen3*100.0)/100.0;
	}

	public double getPercFemaleSen4() {
		return  Math.round(percFemaleSen4*100.0)/100.0;
	}

	public double getPercFemaleSen5() {
		return  Math.round(percFemaleSen5*100.0)/100.0;
	}


	public double getPercMaleSen1() {
		return  Math.round(percMaleSen1*100.0)/100.0;
	}

	public double getPercMaleSen2() {
		return  Math.round(percMaleSen2*100.0)/100.0;
	}

	public double getPercMaleSen3() {
		return  Math.round(percMaleSen3*100.0)/100.0;
	}

	public double getPercMaleSen4() {
		return  Math.round(percMaleSen4*100.0)/100.0;
	}

	public double getPercMaleSen5() {
		return  Math.round(percMale5*100.0)/100.0;
	}

}
