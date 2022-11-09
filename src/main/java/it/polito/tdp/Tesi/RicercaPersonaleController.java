/**
 * Sample Skeleton for 'ScenaRicercaPersonale.fxml' Controller Class
 */

package it.polito.tdp.Tesi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.Tesi.model.Model;
import it.polito.tdp.Tesi.model.Professione;
import it.polito.tdp.Tesi.model.Utente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RicercaPersonaleController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="btnAnalisiDati"
    private Button btnAnalisiDati; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdDS"
    private ComboBox<String> cmbEdDS; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdDriver"
    private ComboBox<String> cmbEdDriver; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdFA"
    private ComboBox<String> cmbEdFA; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdGD"
    private ComboBox<String> cmbEdGD; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdIT"
    private ComboBox<String> cmbEdIT; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdMA"
    private ComboBox<String> cmbEdMA; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdManager"
    private ComboBox<String> cmbEdManager; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdSA"
    private ComboBox<String> cmbEdSA; // Value injected by FXMLLoader
    
    @FXML // fx:id="cmbEdSE"
    private ComboBox<String> cmbEdSE; // Value injected by FXMLLoader

    @FXML // fx:id="cmbEdWA"
    private ComboBox<String> cmbEdWA; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenDS"
    private ComboBox<Integer> cmbSenDS; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenDriver"
    private ComboBox<Integer> cmbSenDriver; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenFA"
    private ComboBox<Integer> cmbSenFA; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenGD"
    private ComboBox<Integer> cmbSenGD; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenIT"
    private ComboBox<Integer> cmbSenIT; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenMA"
    private ComboBox<Integer> cmbSenMA; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenManager"
    private ComboBox<Integer> cmbSenManager; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenSA"
    private ComboBox<Integer> cmbSenSA; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenSE"
    private ComboBox<Integer> cmbSenSE; // Value injected by FXMLLoader

    @FXML // fx:id="cmbSenWA"
    private ComboBox<Integer> cmbSenWA; // Value injected by FXMLLoader


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

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnAge1"
    private TableColumn<Utente, Integer> tableColumnAge1; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnAge2"
    private TableColumn<Utente, Integer> tableColumnAge2; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnDept1"
    private TableColumn<Utente, String> tableColumnDept1; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnDept2"
    private TableColumn<Utente, String> tableColumnDept2; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnEdu1"
    private TableColumn<Utente, String> tableColumnEdu1; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnEdu2"
    private TableColumn<Utente, String> tableColumnEdu2; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnGender1"
    private TableColumn<Utente, String> tableColumnGender1; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnGender2"
    private TableColumn<Utente, String> tableColumnGender2; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnId1"
    private TableColumn<Utente, Integer> tableColumnId1; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnId2"
    private TableColumn<Utente, Integer> tableColumnId2; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnJT1"
    private TableColumn<Utente, String> tableColumnJT1; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnJT2"
    private TableColumn<Utente, String> tableColumnJT2; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnPES1"
    private TableColumn<Utente, Integer> tableColumnPES1; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnPES2"
    private TableColumn<Utente, Integer> tableColumnPES2; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnSen1"
    private TableColumn<Utente, Integer> tableColumnSen1; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnSen2"
    private TableColumn<Utente, Integer> tableColumnSen2; // Value injected by FXMLLoader

    @FXML // fx:id="tableView1"
    private TableView<Utente> tableView1; // Value injected by FXMLLoader

    @FXML // fx:id="tableView2"
    private TableView<Utente> tableView2; // Value injected by FXMLLoader
    
    @FXML // fx:id="pieChartRicorsione1"
    private PieChart pieChartRicorsione1; // Value injected by FXMLLoader

    @FXML // fx:id="pieChartRicorsione2"
    private PieChart pieChartRicorsione2; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtField1"
    private TextField txtField1; // Value injected by FXMLLoader

    @FXML // fx:id="txtField2"
    private TextField txtField2; // Value injected by FXMLLoader

    
    @FXML
    void cercaTeamWork(ActionEvent event) {
    	
    	txtResult.clear();
    	txtField1.clear();
    	txtField2.clear();
    	tableView1.getItems().clear();
    	tableView2.getItems().clear();
    	pieChartRicorsione1.getData().clear();
    	pieChartRicorsione2.getData().clear();
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
    	
    	ArrayList<Professione> professioniRicercate = new ArrayList<Professione>();
    			  
    if(this.sldDataScientist.getValue()!=0) {
   	     numDataScientist=(int)(this.sldDataScientist.getValue());
   	     if(this.cmbEdDS.getValue()==null || this.cmbSenDS.getValue()==null) {
   	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Data Scientist'!");
   	    	 return;
   	     }
   	     String education=this.cmbEdDS.getValue();
   	     int seniority = this.cmbSenDS.getValue();
   	     Professione p = new Professione("Data Scientist",seniority,education);
   	     
   	     for(int i=0;i<numDataScientist;i++) {
   	    	 professioniRicercate.add(p);
   	     }
   	}
    else {
    	this.cmbEdDS.setValue(null);
    	this.cmbSenDS.setValue(null);
    }
   	
   	if(this.sldDriver.getValue()!=0) {
   		numDriver=(int)(this.sldDriver.getValue());
   		if(this.cmbEdDriver.getValue()==null || this.cmbSenDriver.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Driver'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdDriver.getValue();
  	     int seniority = this.cmbSenDriver.getValue();
  	     Professione p = new Professione("Driver",seniority,education);
  	     
  	     for(int i=0;i<numDriver;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     }
   	else {
   		this.cmbEdDriver.setValue(null);
   		this.cmbSenDriver.setValue(null);
   	}
   	
   	if(this.sldFinancialAnalyst.getValue()!=0) {
   		numFinancialAnalyst=(int)(this.sldFinancialAnalyst.getValue());
   		if(this.cmbEdFA.getValue()==null || this.cmbSenFA.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Financial Analyst'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdFA.getValue();
  	     int seniority = this.cmbSenFA.getValue();
  	     Professione p = new Professione("Financial Analyst",seniority,education);
  	     
  	     for(int i=0;i<numFinancialAnalyst;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     } 
   	else {
   		this.cmbEdFA.setValue(null);
   		this.cmbSenFA.setValue(null);
   	}
   	
   	if(this.sldGraphicDesigner.getValue()!=0) {
   		numGraphicDesigner=(int)(this.sldGraphicDesigner.getValue());
   		if(this.cmbEdGD.getValue()==null || this.cmbSenGD.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Graphic Designer'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdGD.getValue();
  	     int seniority = this.cmbSenGD.getValue();
  	     Professione p = new Professione("Graphic Designer",seniority,education);
  	     
  	     for(int i=0;i<numGraphicDesigner;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     }
   	else {
   		this.cmbEdGD.setValue(null);
   		this.cmbSenGD.setValue(null);
   	}
   	
   	if(this.sldIT.getValue()!=0) {
   		numIT=(int)(this.sldIT.getValue());
   		if(this.cmbEdIT.getValue()==null || this.cmbSenIT.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'IT'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdIT.getValue();
  	     int seniority = this.cmbSenIT.getValue();
  	     Professione p = new Professione("IT",seniority,education);
  	     
  	     for(int i=0;i<numIT;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     }
   	else {
   		this.cmbEdIT.setValue(null);
   		this.cmbSenIT.setValue(null);
   	}
   	
   	if(this.sldManager.getValue()!=0) {
   		numManager=(int)(this.sldManager.getValue());
   		if(this.cmbEdManager.getValue()==null || this.cmbSenManager.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Manager'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdManager.getValue();
  	     int seniority = this.cmbSenManager.getValue();
  	     Professione p = new Professione("Manager",seniority,education);
  	     
  	     for(int i=0;i<numManager;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     }
   	else {
   		this.cmbEdManager.setValue(null);
   		this.cmbSenManager.setValue(null);
   	}
   	
   	if(this.sldMarketingAssociate.getValue()!=0) {
   		numMarketingAssociate=(int)(this.sldMarketingAssociate.getValue());
   		if(this.cmbEdMA.getValue()==null || this.cmbSenMA.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Marketing Associate'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdMA.getValue();
  	     int seniority = this.cmbSenMA.getValue();
  	     Professione p = new Professione("Marketing Associate",seniority,education);
  	     
  	     for(int i=0;i<numMarketingAssociate;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     }
   	else {
   		this.cmbEdMA.setValue(null);
   		this.cmbSenMA.setValue(null);
   	}
   	
	if(this.sldSalesAssociate.getValue()!=0) {
   		numSalesAssociate=(int)(this.sldSalesAssociate.getValue());
   		if(this.cmbEdSA.getValue()==null || this.cmbSenSA.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Sales Associate'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdSA.getValue();
  	     int seniority = this.cmbSenSA.getValue();
  	     Professione p = new Professione("Sales Associate",seniority,education);
  	     
  	     for(int i=0;i<numSalesAssociate;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     }
	else {
		this.cmbEdSA.setValue(null);
		this.cmbSenSA.setValue(null);
	}
   	
   	if(this.sldSoftwareEngineer.getValue()!=0) {
   		numSoftwareEngineer=(int)(this.sldSoftwareEngineer.getValue());
   		if(this.cmbEdSE.getValue()==null || this.cmbSenSE.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Software Engineer'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdSE.getValue();
  	     int seniority = this.cmbSenSE.getValue();
  	     Professione p = new Professione("Software Engineer",seniority,education);
  	     
  	     for(int i=0;i<numSoftwareEngineer;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     }
   	else {
   		this.cmbEdSE.setValue(null);
   		this.cmbSenSE.setValue(null);
   	}
   	
   	if(this.sldWarehouseAssociate.getValue()!=0) {
   		numWarehouseAssociate=(int)(this.sldWarehouseAssociate.getValue());
   		if(this.cmbEdWA.getValue()==null || this.cmbSenWA.getValue()==null) {
  	    	 txtResult.appendText("Seleziona 'Education' e 'Seniority' per la posizione 'Warehouse Associate'!");
  	    	 return;
  	     }
  	     String education=this.cmbEdWA.getValue();
  	     int seniority = this.cmbSenWA.getValue();
  	     Professione p = new Professione("Warehouse Associate",seniority,education);
  	     
  	     for(int i=0;i<numWarehouseAssociate;i++) {
  	    	 professioniRicercate.add(p);
  	     }
     }
   	else {
   		this.cmbEdWA.setValue(null);
   		this.cmbSenWA.setValue(null);
   	}
   	
    	
    	List<Utente> utenti = model.cercaTeamWork(professioniRicercate);
    	this.tableView1.setItems(FXCollections.observableArrayList(utenti));
    	if(utenti.size()==0) {
    		txtResult.setText("Non è stato possibile calcolare un team work con le specifiche richieste");
    		txtResult.setStyle("-fx-text-fill: red;");
    		return;
    	}
    	double percDonne1=this.calcolaPercentuali(utenti);
    	double percUomini1=100-percDonne1;
    	ObservableList<PieChart.Data> list1 = FXCollections.observableArrayList(
                new PieChart.Data("Percentuale uomini = "+percUomini1+" %", percUomini1),
                new PieChart.Data("Percentuale donne = "+percDonne1+" %", percDonne1));
        pieChartRicorsione1.setData(list1);
        pieChartRicorsione1.setClockwise(true); 
        pieChartRicorsione1.setLabelsVisible(true);
        pieChartRicorsione1.setStartAngle(180);     
        pieChartRicorsione1.setLegendVisible(true); 
        pieChartRicorsione1.setVisible(true);
        pieChartRicorsione1.setLabelLineLength(10);
        pieChartRicorsione1.setLegendSide(Side.RIGHT);
    	
    	List<Utente> utentiEqui = model.cercaTeamWorkEquo(professioniRicercate);
    	this.tableView2.setItems(FXCollections.observableArrayList(utentiEqui));
    	if(utentiEqui.size()==0) {
    		txtResult.setText("Non è stato possibile calcolare un team work con una rappresentanza di genere equa con le specifiche richieste");
    		txtResult.setStyle("-fx-text-fill: red;");
    		return;
    	}
    	double percDonne2=this.calcolaPercentuali(utentiEqui);
    	double percUomini2=100-percDonne2;
    	ObservableList<PieChart.Data> list2 = FXCollections.observableArrayList(
                new PieChart.Data("Percentuale uomini = "+percUomini2+" %", percUomini2),
                new PieChart.Data("Percentuale donne = "+percDonne2+" %", percDonne2));
        pieChartRicorsione2.setData(list2);
        pieChartRicorsione2.setClockwise(true); 
        pieChartRicorsione2.setLabelsVisible(true);
        pieChartRicorsione2.setStartAngle(180);     
        pieChartRicorsione2.setLegendVisible(true); 
        pieChartRicorsione2.setVisible(true);
        pieChartRicorsione2.setLabelLineLength(10);
        pieChartRicorsione2.setLegendSide(Side.RIGHT);
    	
    	txtField1.appendText("Performance Evaluation Score medio : "+this.calcolaAvgPerfEval(utenti));
    	txtField2.appendText("Performance Evaluation Score medio : "+this.calcolaAvgPerfEval(utentiEqui));
    	

    }
    
    @FXML
    void clear(ActionEvent event) {
    	this.sldDataScientist.setValue(0);
    	this.sldDriver.setValue(0);
    	this.sldFinancialAnalyst.setValue(0);
    	this.sldGraphicDesigner.setValue(0);
    	this.sldIT.setValue(0);
    	this.sldManager.setValue(0);
    	this.sldMarketingAssociate.setValue(0);
    	this.sldSalesAssociate.setValue(0);
    	this.sldSoftwareEngineer.setValue(0);
    	this.sldWarehouseAssociate.setValue(0);
    	
    	this.cmbEdDriver.setValue(null);
    	this.cmbEdDS.setValue(null);
    	this.cmbEdFA.setValue(null);
    	this.cmbEdGD.setValue(null);
    	this.cmbEdIT.setValue(null);
    	this.cmbEdMA.setValue(null);
    	this.cmbEdManager.setValue(null);
    	this.cmbEdSA.setValue(null);
    	this.cmbEdSE.setValue(null);
    	this.cmbEdWA.setValue(null);
    	
    	this.cmbSenDriver.setValue(null);
    	this.cmbSenDS.setValue(null);
    	this.cmbSenFA.setValue(null);
    	this.cmbSenGD.setValue(null);
    	this.cmbSenIT.setValue(null);
    	this.cmbSenMA.setValue(null);
    	this.cmbSenManager.setValue(null);
    	this.cmbSenSA.setValue(null);
    	this.cmbSenSE.setValue(null);
    	this.cmbSenWA.setValue(null);
    	
    	this.tableView1.getItems().clear();
    	this.tableView2.getItems().clear();
    	this.pieChartRicorsione1.getData().clear();
    	this.pieChartRicorsione2.getData().clear();
    	this.txtField1.clear();
    	this.txtField2.clear();
    }
    
    
    @FXML
    void analisiDati(ActionEvent event) {
    	Stage stage = null;
        BorderPane root = null;
        stage = (Stage) btnAnalisiDati.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ScenaAnalisiDati.fxml"));
        try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        AnalisiDatiController controller=loader.getController();
        Model model=new Model(); 
        controller.setModel(model);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public double calcolaAvgPerfEval(List<Utente> utenti) {
    	
    	double somma=0;
    	for(Utente u : utenti) {
    		somma+=u.getPerfEval();
    	}
    	
    	double media = somma/(double)(utenti.size());
    	
    	return Math.round(media*100.0)/100.0;
    }
    
    public double calcolaPercentuali(List<Utente> utenti) {
    	
    	int numDonne=0;
    	for(Utente u : utenti) {
    		if(u.getGender().equals("Female")) {
    			numDonne++;
    		}
    	}
    	double percDonne=100*((double)(numDonne)/(double)(utenti.size()));
    	return Math.round(percDonne*100.0)/100.0;
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert btnAnalisiDati != null : "fx:id=\"btnAnalisiDati\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
    	assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
    	assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
    	assert cmbEdDS != null : "fx:id=\"cmbEdDS\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdDriver != null : "fx:id=\"cmbEdDriver\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdFA != null : "fx:id=\"cmbEdFA\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdGD != null : "fx:id=\"cmbEdGD\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdIT != null : "fx:id=\"cmbEdIT\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdMA != null : "fx:id=\"cmbEdMA\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdManager != null : "fx:id=\"cmbEdManager\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdSA != null : "fx:id=\"cmbEdSA\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdSE != null : "fx:id=\"cmbEdSE\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbEdWA != null : "fx:id=\"cmbEdWA\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenDS != null : "fx:id=\"cmbSenDS\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenDriver != null : "fx:id=\"cmbSenDriver\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenFA != null : "fx:id=\"cmbSenFA\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenGD != null : "fx:id=\"cmbSenGD\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenIT != null : "fx:id=\"cmbSenIT\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenMA != null : "fx:id=\"cmbSenMA\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenManager != null : "fx:id=\"cmbSenManager\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenSA != null : "fx:id=\"cmbSenSA\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenSE != null : "fx:id=\"cmbSenSE\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert cmbSenWA != null : "fx:id=\"cmbSenWA\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
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
        assert tableColumnAge1 != null : "fx:id=\"tableColumnAge1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnAge2 != null : "fx:id=\"tableColumnAge2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnDept1 != null : "fx:id=\"tableColumnDept1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnDept2 != null : "fx:id=\"tableColumnDept2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnEdu1 != null : "fx:id=\"tableColumnEdu1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnEdu2 != null : "fx:id=\"tableColumnEdu2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnGender1 != null : "fx:id=\"tableColumnGender1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnGender2 != null : "fx:id=\"tableColumnGender2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnId1 != null : "fx:id=\"tableColumnId1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnId2 != null : "fx:id=\"tableColumnId2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnJT1 != null : "fx:id=\"tableColumnJT1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnJT2 != null : "fx:id=\"tableColumnJT2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnPES1 != null : "fx:id=\"tableColumnPES1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnPES2 != null : "fx:id=\"tableColumnPES2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnSen1 != null : "fx:id=\"tableColumnSen1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableColumnSen2 != null : "fx:id=\"tableColumnSen2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableView1 != null : "fx:id=\"tableView1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert tableView2 != null : "fx:id=\"tableView2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert txtField1 != null : "fx:id=\"txtField1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert txtField2 != null : "fx:id=\"txtField2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert pieChartRicorsione1 != null : "fx:id=\"pieChartRicorsione1\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        assert pieChartRicorsione2 != null : "fx:id=\"pieChartRicorsione2\" was not injected: check your FXML file 'ScenaRicercaPersonale.fxml'.";
        this.tableColumnAge1.setCellValueFactory(new PropertyValueFactory<Utente,Integer>("age"));
        this.tableColumnAge2.setCellValueFactory(new PropertyValueFactory<Utente,Integer>("age"));
        this.tableColumnDept1.setCellValueFactory(new PropertyValueFactory<Utente,String>("dept"));
        this.tableColumnDept2.setCellValueFactory(new PropertyValueFactory<Utente,String>("dept"));
        this.tableColumnEdu1.setCellValueFactory(new PropertyValueFactory<Utente,String>("education"));
        this.tableColumnEdu2.setCellValueFactory(new PropertyValueFactory<Utente,String>("education"));
        this.tableColumnGender1.setCellValueFactory(new PropertyValueFactory<Utente,String>("gender"));
        this.tableColumnGender2.setCellValueFactory(new PropertyValueFactory<Utente,String>("gender"));
        this.tableColumnId1.setCellValueFactory(new PropertyValueFactory<Utente,Integer>("id"));
        this.tableColumnId2.setCellValueFactory(new PropertyValueFactory<Utente,Integer>("id"));
        this.tableColumnJT1.setCellValueFactory(new PropertyValueFactory<Utente,String>("jobTitle"));
        this.tableColumnJT2.setCellValueFactory(new PropertyValueFactory<Utente,String>("jobTitle"));
        this.tableColumnPES1.setCellValueFactory(new PropertyValueFactory<Utente,Integer>("perfEval"));
        this.tableColumnPES2.setCellValueFactory(new PropertyValueFactory<Utente,Integer>("perfEval"));
        this.tableColumnSen1.setCellValueFactory(new PropertyValueFactory<Utente,Integer>("seniority"));
        this.tableColumnSen2.setCellValueFactory(new PropertyValueFactory<Utente,Integer>("seniority"));
    }
    
    public void setComboBoxes() {
    	List<Integer> seniority = this.model.getSeniority();
    	List<String> education = this.model.getEducation();
    	
    	this.cmbSenDriver.getItems().addAll(seniority);
    	this.cmbSenDS.getItems().addAll(seniority);
    	this.cmbSenFA.getItems().addAll(seniority);
    	this.cmbSenGD.getItems().addAll(seniority);
    	this.cmbSenIT.getItems().addAll(seniority);
    	this.cmbSenMA.getItems().addAll(seniority);
    	this.cmbSenManager.getItems().addAll(seniority);
    	this.cmbSenSA.getItems().addAll(seniority);
    	this.cmbSenSE.getItems().addAll(seniority);
    	this.cmbSenWA.getItems().addAll(seniority);
    	
    	this.cmbEdDS.getItems().addAll(education);
    	this.cmbEdDriver.getItems().addAll(education);
    	this.cmbEdFA.getItems().addAll(education);
    	this.cmbEdGD.getItems().addAll(education);
    	this.cmbEdIT.getItems().addAll(education);
    	this.cmbEdMA.getItems().addAll(education);
    	this.cmbEdManager.getItems().addAll(education);
    	this.cmbEdSA.getItems().addAll(education);
    	this.cmbEdSE.getItems().addAll(education);
    	this.cmbEdWA.getItems().addAll(education);
    }
    
    public void setModel(Model model) {
    	this.model=model;
    	this.setComboBoxes();
    }


}

