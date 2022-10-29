/**
 * Sample Skeleton for 'ScenaRicercaPersonale.fxml' Controller Class
 */

package it.polito.tdp.Tesi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.Tesi.model.Model;
import it.polito.tdp.Tesi.model.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class RicercaPersonaleController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="cmbBoxEducation"
    private ComboBox<String> cmbBoxEducation; // Value injected by FXMLLoader

    @FXML // fx:id="cmbBoxSeniority"
    private ComboBox<Integer> cmbBoxSeniority; // Value injected by FXMLLoader

    @FXML // fx:id="sldDataScientist"
    private Slider sldDataScientist; // Value injected by FXMLLoader

    @FXML // fx:id="sldDriver"
    private Slider sldDriver; // Value injected by FXMLLoader

    @FXML // fx:id="sldFinancialAnalyst"
    private Slider sldFinancialAnalyst; // Value injected by FXMLLoader

    @FXML // fx:id="sldGraphicDesigner"
    private Slider sldGraphicDesigner; // Value injected by FXMLLoader

    @FXML // fx:id="sldIT"
    private Slider sldIT; // Value injected by FXMLLoader

    @FXML // fx:id="sldManager"
    private Slider sldManager; // Value injected by FXMLLoader

    @FXML // fx:id="sldMarketingAssociate"
    private Slider sldMarketingAssociate; // Value injected by FXMLLoader

    @FXML // fx:id="sldSalesAssociate"
    private Slider sldSalesAssociate; // Value injected by FXMLLoader

    @FXML // fx:id="sldSoftwareEngineer"
    private Slider sldSoftwareEngineer; // Value injected by FXMLLoader

    @FXML // fx:id="sldWarehouseAssociate"
    private Slider sldWarehouseAssociate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult1"
    private TextArea txtResult1; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult2"
    private TextArea txtResult2; // Value injected by FXMLLoader

    @FXML
    void cercaTeamWork(ActionEvent event) {
    	

    	txtResult1.clear();
    	int numDataScientist=0;
    	int numDriver=0;
    	int numFinancialAnalyst=0;
    	int numGraphicDesigner=0;
    	int numIT=0;
    	int numManager=0;
    	int numMarketingAssociate=0;
    	int numSalesAssociate=0;
    	int numSoftwareEngineer=0;
    	int numWarehouseAssociate=0;
    	
    
    	if(this.cmbBoxSeniority.getValue()==null) {
    		txtResult1.appendText("Seleziona un livello di 'Seniority'!");
    		return;
    	}
    	
    	int seniority=this.cmbBoxSeniority.getValue();
    	
    	ArrayList<String> professioniRicercate = new ArrayList<String>();
    			  
    	if(this.sldDataScientist.getValue()!=0) {
    	     numDataScientist=(int)(this.sldDataScientist.getValue());
    	     for(int i=0;i<numDataScientist;i++) {
    	    	 professioniRicercate.add("Data Scientist");
    	     }
    	}	
    	if(this.sldDriver.getValue()!=0) {
    		numDriver=(int)(this.sldDriver.getValue());
    		 for(int i=0;i<numDriver;i++) {
    	    	 professioniRicercate.add("Driver");
    	     }
      	} 	
    	if(this.sldFinancialAnalyst.getValue()!=0) {
    		numFinancialAnalyst=(int)(this.sldFinancialAnalyst.getValue());
    		 for(int i=0;i<numFinancialAnalyst;i++) {
    	    	 professioniRicercate.add("Financial Analyst");
    	     }
      	}   	
    	if(this.sldGraphicDesigner.getValue()!=0) {
    		numGraphicDesigner=(int)(this.sldGraphicDesigner.getValue());
    		 for(int i=0;i<numGraphicDesigner;i++) {
    	    	 professioniRicercate.add("Graphic Designer");
    	     }
      	}
    	if(this.sldIT.getValue()!=0) {
    		numIT=(int)(this.sldIT.getValue());
    		 for(int i=0;i<numIT;i++) {
    	    	 professioniRicercate.add("IT");
    	     }
      	}
    	if(this.sldManager.getValue()!=0) {
    		numManager=(int)(this.sldManager.getValue());
    		 for(int i=0;i<numManager;i++) {
    	    	 professioniRicercate.add("Manager");
    	     }
      	}
    	if(this.sldMarketingAssociate.getValue()!=0) {
    		numMarketingAssociate=(int)(this.sldMarketingAssociate.getValue());
    		 for(int i=0;i<numMarketingAssociate;i++) {
    	    	 professioniRicercate.add("Marketing Associate");
    	     }
      	}
    	
    	if(this.sldSalesAssociate.getValue()!=0) {
    		numSalesAssociate=(int)(this.sldSalesAssociate.getValue());
    		 for(int i=0;i<numSalesAssociate;i++) {
    	    	 professioniRicercate.add("Sales Associate");
    	     }
      	}
    	
    	if(this.sldSoftwareEngineer.getValue()!=0) {
    		numSoftwareEngineer=(int)(this.sldSoftwareEngineer.getValue());
    		 for(int i=0;i<numSoftwareEngineer;i++) {
    	    	 professioniRicercate.add("Software Engineer");
    	     }
      	}
    	if(this.sldWarehouseAssociate.getValue()!=0) {
    		numWarehouseAssociate=(int)(this.sldWarehouseAssociate.getValue());
    		 for(int i=0;i<numWarehouseAssociate;i++) {
    	    	 professioniRicercate.add("Warehouse Associate");
    	     }
      	}
    	
    	List<Utente> utenti = model.cercaTeamWork(professioniRicercate, seniority);
    	for(Utente u : utenti) {
    		this.txtResult1.appendText(u+"\n");
    	}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbBoxEducation != null : "fx:id=\"cmbBoxEducation\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbBoxSeniority != null : "fx:id=\"cmbBoxSeniority\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldDataScientist != null : "fx:id=\"sldDataScientist\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldDriver != null : "fx:id=\"sldDriver\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldFinancialAnalyst != null : "fx:id=\"sldFinancialAnalyst\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldGraphicDesigner != null : "fx:id=\"sldGraphicDesigner\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldIT != null : "fx:id=\"sldIT\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldManager != null : "fx:id=\"sldManager\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldMarketingAssociate != null : "fx:id=\"sldMarketingAssociate\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldSalesAssociate != null : "fx:id=\"sldSalesAssociate\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldSoftwareEngineer != null : "fx:id=\"sldSoftwareEngineer\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert sldWarehouseAssociate != null : "fx:id=\"sldWarehouseAssociate\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert txtResult1 != null : "fx:id=\"txtResult1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert txtResult2 != null : "fx:id=\"txtResult2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";

    }
    
    public void setComboBox() {
    	this.cmbBoxEducation.getItems().clear();
    	this.cmbBoxEducation.getItems().addAll(this.model.getEducation());
    	this.cmbBoxSeniority.getItems().clear();
    	this.cmbBoxSeniority.getItems().addAll(this.model.getSeniority());
    }
    
    public void setModel(Model model) {
    	this.model=model;
    	this.setComboBox();
    }


}

