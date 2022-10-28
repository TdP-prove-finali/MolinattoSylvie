/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.Tesi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Tesi.model.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Side;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnalisiDatiController {
	
	Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="barChart1"
    private BarChart<String, Double> barChart1; // Value injected by FXMLLoader
    
    @FXML // fx:id="barChart2"
    private BarChart<String, Double> barChart2; // Value injected by FXMLLoader
    
    @FXML // fx:id="barChartBonus"
    private BarChart<String, Double> barChartBonus; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizza"
    private Button btnAnalizza; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnRicercaPersonale"
    private Button btnRicercaPersonale; // Value injected by FXMLLoader

    @FXML // fx:id="cmbJobTitle"
    private ComboBox<String> cmbJobTitle; // Value injected by FXMLLoader

    @FXML // fx:id="pieChart1"
    private PieChart pieChart1; // Value injected by FXMLLoader
    
    @FXML // fx:id="pieChart2"
    private PieChart pieChart2; // Value injected by FXMLLoader

    @FXML // fx:id="pieChart3"
    private PieChart pieChart3; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="xAxis1"
    private CategoryAxis xAxis1; // Value injected by FXMLLoader
    
    @FXML // fx:id="xAxis2"
    private CategoryAxis xAxis2; // Value injected by FXMLLoader
    
    @FXML // fx:id="xAxisBonus"
    private CategoryAxis xAxisBonus; // Value injected by FXMLLoader

    @FXML // fx:id="yAxis1"
    private NumberAxis yAxis1; // Value injected by FXMLLoader
    
    @FXML // fx:id="yAxis2"
    private NumberAxis yAxis2; // Value injected by FXMLLoader
    
    @FXML // fx:id="yAxisBonus"
    private NumberAxis yAxisBonus; // Value injected by FXMLLoader

    
    
    @FXML
    void Analizza(ActionEvent event) {
    	
    	txtResult.clear();
    	String jobTitle = this.cmbJobTitle.getValue();
    	
    	
    	if(jobTitle=="" || jobTitle==null) {
    		System.out.println("Seleziona un lavoro!\n");
    	}
    	else {
    		this.model.Analizza(jobTitle);
    		 ObservableList list1 = FXCollections.observableArrayList(
    	                new PieChart.Data("Percentuale uomini = "+this.model.getPercentualeMaschile()+" %", this.model.getPercentualeMaschile()),
    	                new PieChart.Data("Percentuale donne = "+this.model.getPercentualeFemminile()+" %", this.model.getPercentualeFemminile()));
    	     pieChart1.setData(list1);
    	     pieChart1.setClockwise(true); 
    	     pieChart1.setLabelsVisible(true);
    	     pieChart1.setStartAngle(180);     
    	     pieChart1.setLegendVisible(true); 
    	     pieChart1.setVisible(true);
    	     pieChart1.setLabelLineLength(10);
    	     pieChart1.setLegendSide(Side.RIGHT);
    	     
    	     
    	    
    	     // bar chart retribuzione annua media
    	     
    	     barChart1.getData().clear();  
    	     
    	     final String pagaAnnuaMedia = "Paga annua media";
    	    
    	     XYChart.Series<String, Double> series1 = new XYChart.Series<>(); 
    	     series1.setName("Uomini");
    	     series1.getData().add(new XYChart.Data<>(pagaAnnuaMedia,this.model.getAvgMalePay()));
    	    		 
    	     XYChart.Series<String, Double> series2 = new XYChart.Series<>();
    	     series2.setName("Donne");
    	     series2.getData().add(new XYChart.Data<>(pagaAnnuaMedia,this.model.getAvgFemalePay()));
    	     
    	     barChart1.getData().addAll(series1,series2); 
    	     barChart1.setBarGap(2);
    	     barChart1.setCategoryGap(10);
    	     barChart1.setLegendVisible(true);
    	     barChart1.setLegendSide(Side.RIGHT);
    	     barChart1.setVisible(true);
    	     
    	     // bar chart bonus annuo medio
    	     
    	     barChartBonus.getData().clear();
    	     
    	     final String bonusAnnuoMedio = "Bonus Annuo Medio";
    	     
    	     XYChart.Series<String, Double> seriesBonusUomini = new XYChart.Series<>(); 
    	     seriesBonusUomini.setName("Uomini");
    	     seriesBonusUomini.getData().add(new XYChart.Data<>(bonusAnnuoMedio,this.model.getAvgMaleBonus()));
    	     
    	     XYChart.Series<String, Double> seriesBonusDonne = new XYChart.Series<>(); 
    	     seriesBonusDonne.setName("Donne");
    	     seriesBonusDonne.getData().add(new XYChart.Data<>(bonusAnnuoMedio,this.model.getAvgFemaleBonus()));
    	     
    	     
    	     barChartBonus.getData().addAll(seriesBonusUomini,seriesBonusDonne); 
    	     barChartBonus.setBarGap(2);
    	     barChartBonus.setCategoryGap(10);
    	     barChartBonus.setLegendVisible(true);
    	     barChartBonus.setLegendSide(Side.RIGHT);
    	     barChartBonus.setVisible(true);
    	     
    	     
    	     // bar chart età media
    	     
    	     barChart2.getData().clear();
    	     XYChart.Series<String, Double> series3 = new XYChart.Series<>(); 
    	     
    	     series3.setName("Uomini");
    	     series3.getData().add(new XYChart.Data<String,Double>("Età media",this.model.getAvgMaleAge()));
    	     XYChart.Series<String, Double> series4 = new XYChart.Series<>(); 
    	     series4.setName("Donne");
    	     series4.getData().add(new XYChart.Data<>("Età media",this.model.getAvgFemaleAge()));
    	     
    	     barChart2.getData().addAll(series3,series4);
    	     barChart2.setBarGap(2);
    	     barChart2.setCategoryGap(10);
    	     barChart2.setLegendVisible(true);
    	     barChart2.setLegendSide(Side.RIGHT);
    	     barChart2.setVisible(true);
    	     
    	     
    	     // pie chart  istruzione
    	     
    	     double percFemaleCollege = this.model.getPercFemaleCollege();
    	     double percFemaleHighSchool = this.model.getPercFemaleHighSchool();
    	     double percFemaleMasters = this.model.getPercMaleMasters();
    	     double percFemalePhD = this.model.getPercFemalePhD();
    	     

    	     double percMaleCollege = this.model.getPercMaleCollege();
    	     double percMaleHighSchool = this.model.getPercMaleHighSchool();
    	     double percMaleMasters =this.model.getPercMaleMasters();
    	     double percMalePhD = this.model.getPercMalePhD();
    	     
    	     ObservableList list2 = FXCollections.observableArrayList(
 	                new PieChart.Data("College = "+percFemaleCollege+" %", percFemaleCollege),
 	                new PieChart.Data("High School = "+percFemaleHighSchool+" %", percFemaleHighSchool),
 	                new PieChart.Data("Masters = "+percFemaleMasters+" %", percFemaleMasters),
 	                new PieChart.Data("PhD = "+percFemalePhD+" %", percFemalePhD) );
    	     
    	     pieChart2.setData(list2);
    	     pieChart2.setClockwise(true); 
    	     pieChart2.setLabelsVisible(true);
    	     pieChart2.setStartAngle(180);     
    	     pieChart2.setLegendVisible(true); 
    	     pieChart2.setVisible(true);
    	     pieChart2.setLabelLineLength(10);
    	     pieChart2.setLegendSide(Side.RIGHT);
    	     
    	     
    	     ObservableList list3 = FXCollections.observableArrayList(
  	                new PieChart.Data("College = "+percMaleCollege+" %", percMaleCollege),
  	                new PieChart.Data("High School = "+percMaleHighSchool+" %", percMaleHighSchool),
  	                new PieChart.Data("Masters = "+percMaleMasters+" %", percMaleMasters),
  	                new PieChart.Data("PhD = "+percMalePhD+" %", percMalePhD) );
     	     
     	     pieChart3.setData(list3);
     	     pieChart3.setClockwise(true); 
     	     pieChart3.setLabelsVisible(true);
     	     pieChart3.setStartAngle(180);     
     	     pieChart3.setLegendVisible(true); 
     	     pieChart3.setVisible(true);
     	     pieChart3.setLabelLineLength(10);
     	     pieChart3.setLegendSide(Side.RIGHT);
    	     
    	     
    	     
    	     
    	     
    		txtResult.appendText("Percentuale femminile  : "+this.model.getPercentualeFemminile()+" %\n");
    		txtResult.appendText("Percentuale maschile  : "+this.model.getPercentualeMaschile()+" %\n");
    		txtResult.appendText("Stipendio medio femminile : "+this.model.getAvgFemalePay()+" $/anno\n");
    		txtResult.appendText("Stipendio medio maschile : "+this.model.getAvgMalePay()+" $/anno\n");
    		txtResult.appendText("Bonus medio femminile : "+this.model.getAvgFemaleBonus()+" $/anno\n");
    		txtResult.appendText("Bonus medio maschile : "+this.model.getAvgMaleBonus()+" $/anno\n");
    		txtResult.appendText("Età media del genere femminile : "+this.model.getAvgFemaleAge()+" anni\n");
    		txtResult.appendText("Età media del genere maschile : "+this.model.getAvgMaleAge()+" anni\n");
    		txtResult.appendText("Numero medio di anni di lavoro del genere femminile : "+this.model.getAvgFemaleSeniority()+" anni\n");
    		txtResult.appendText("Numero medio di anni di lavoro del genere maschile : "+this.model.getAvgMaleSeniority()+" anni\n");
    	}
    }
    
    @FXML
    void ricercaPersonale(ActionEvent event)  throws IOException{

    	Stage stage = null;
        BorderPane root = null;
        stage = (Stage) btnRicercaPersonale.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ScenaRicercaPersonale.fxml"));
        root = loader.load();
        RicercaPersonaleController controller=loader.getController();
        Model model=new Model(); 
        controller.setModel(model);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	 assert barChart1 != null : "fx:id=\"barChart1\" was not injected: check your FXML file 'Scene.fxml'.";
    	 assert barChartBonus != null : "fx:id=\"barChartBonus\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnRicercaPersonale != null : "fx:id=\"btnRicercaPersonale\" was not injected: check your FXML file 'Scene.fxml'.";
         assert cmbJobTitle != null : "fx:id=\"cmbJobTitle\" was not injected: check your FXML file 'Scene.fxml'.";
         assert pieChart1 != null : "fx:id=\"pieChart1\" was not injected: check your FXML file 'Scene.fxml'.";
         assert pieChart2 != null : "fx:id=\"pieChart2\" was not injected: check your FXML file 'Scene.fxml'.";
         assert pieChart3 != null : "fx:id=\"pieChart3\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
         assert xAxis1 != null : "fx:id=\"xAxis\" was not injected: check your FXML file 'Scene.fxml'.";
         assert xAxis2 != null : "fx:id=\"xAxis2\" was not injected: check your FXML file 'Scene.fxml'.";
         assert xAxisBonus != null : "fx:id=\"xAxisBonus\" was not injected: check your FXML file 'Scene.fxml'.";
         assert yAxis1 != null : "fx:id=\"yAxis\" was not injected: check your FXML file 'Scene.fxml'.";
         assert yAxis2 != null : "fx:id=\"yAxis2\" was not injected: check your FXML file 'Scene.fxml'.";
         assert yAxisBonus != null : "fx:id=\"yAxisBonus\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.cmbJobTitle.getItems().addAll(this.model.getJobTitles());
    }
}