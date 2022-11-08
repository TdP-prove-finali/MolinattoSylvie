/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.Tesi;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
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
    
    @FXML // fx:id="pieChart4"
    private PieChart pieChart4; // Value injected by FXMLLoader

    @FXML // fx:id="pieChart5"
    private PieChart pieChart5; // Value injected by FXMLLoader

    @FXML // fx:id="pieChart6"
    private PieChart pieChart6; // Value injected by FXMLLoader

    @FXML // fx:id="pieChart7"
    private PieChart pieChart7; // Value injected by FXMLLoader

    @FXML // fx:id="txtInfo"
    private TextArea txtInfo; // Value injected by FXMLLoader
    
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
    	
    	boolean updateReceived=true;
    	txtResult.clear();
    	String jobTitle = this.cmbJobTitle.getValue();
    	
    	
    	if(jobTitle=="" || jobTitle==null) {
    		txtInfo.appendText("Seleziona un lavoro!\n");
    	}
    	else {
    		
    		// creazione pie chart rappresentanza di genere 
    		
    		this.model.Analizza(jobTitle);
    		 ObservableList<PieChart.Data> list1 = FXCollections.observableArrayList(
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
    	     
    	     
    	    
    	     // creazione bar chart retribuzione annua media
    	     
    	     ObservableList<Series<String, Double>> allSeries1 = barChart1.getData();
       	     
 			 if (updateReceived) {
       	        for (XYChart.Series<String, Double> series : allSeries1) {
       	            for (XYChart.Data<String, Double> data : series.getData()) {
       	                Node node = data.getNode();
       	                Parent parent = node.parentProperty().get();
       	                if (parent != null && parent instanceof Group) {
       	                    Group group = (Group) parent;
       	                    group.getChildren().clear();
       	                }
       	            }
       	        }
       	        allSeries1.clear();
       	     }
    	     
    	     
    	     final String pagaAnnuaMedia = "Paga annua media";
    	    
    	     XYChart.Series<String, Double> series1 = new XYChart.Series<>(); 
    	     series1.setName("Uomini");
    	     final XYChart.Data<String,Double> data1 = new XYChart.Data<>(pagaAnnuaMedia,this.model.getAvgMalePay());
    	     data1.nodeProperty().addListener(new ChangeListener<Node>() {
    	         @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
    	           if (node != null) {
    	             displayLabelForData(data1);
    	           } 
    	         }
    	       });
    	     series1.getData().add(data1);
 
    	    		 
    	     XYChart.Series<String, Double> series2 = new XYChart.Series<>();
    	     series2.setName("Donne");
    	     final XYChart.Data<String,Double> data2 = new XYChart.Data<>(pagaAnnuaMedia,this.model.getAvgFemalePay());
    	     data2.nodeProperty().addListener(new ChangeListener<Node>() {
    	         @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
    	           if (node != null) {
    	             displayLabelForData(data2);
    	           } 
    	         }
    	       });
    	     series2.getData().add(data2);
    	     
    	     barChart1.getData().addAll(Arrays.asList(series1,series2)); 
    	     barChart1.setBarGap(2);
    	     barChart1.setCategoryGap(10);
    	     barChart1.setLegendVisible(true);
    	     barChart1.setLegendSide(Side.RIGHT);
    	     barChart1.setVisible(true);
    	  
    	     
    	     // creazione bar chart bonus annuo medio
    	     
    	     ObservableList<Series<String, Double>> allSeriesBonus = barChartBonus.getData();
       	     
 			 if (updateReceived) {
       	        for (XYChart.Series<String, Double> series : allSeriesBonus) {
       	            for (XYChart.Data<String, Double> data : series.getData()) {
       	                Node node = data.getNode();
       	                Parent parent = node.parentProperty().get();
       	                if (parent != null && parent instanceof Group) {
       	                    Group group = (Group) parent;
       	                    group.getChildren().clear();
       	                }
       	            }
       	        }
       	        allSeriesBonus.clear();
       	     }
    	     
    	     
    	     final String bonusAnnuoMedio = "Bonus Annuo Medio";
    	     
    	     XYChart.Series<String, Double> seriesBonusUomini = new XYChart.Series<>(); 
    	     seriesBonusUomini.setName("Uomini");
    	     final XYChart.Data<String,Double> dataBonusUomini = new XYChart.Data<>(bonusAnnuoMedio,this.model.getAvgMaleBonus());
    	     dataBonusUomini.nodeProperty().addListener(new ChangeListener<Node>() {
    	         @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
    	           if (node != null) {
    	             displayLabelForData(dataBonusUomini);
    	           } 
    	         }
    	       });
    	     seriesBonusUomini.getData().add(dataBonusUomini);
    	     
    	     XYChart.Series<String, Double> seriesBonusDonne = new XYChart.Series<>(); 
    	     seriesBonusDonne.setName("Donne");
    	     final XYChart.Data<String,Double> dataBonusDonne = new XYChart.Data<>(bonusAnnuoMedio,this.model.getAvgFemaleBonus());
    	     dataBonusDonne.nodeProperty().addListener(new ChangeListener<Node>() {
    	         @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
    	           if (node != null) {
    	             displayLabelForData(dataBonusDonne);
    	           } 
    	         }
    	       });
    	     seriesBonusDonne.getData().add(dataBonusDonne);
    	     
    	     
    	     barChartBonus.getData().addAll(Arrays.asList(seriesBonusUomini,seriesBonusDonne)); 
    	     barChartBonus.setBarGap(2);
    	     barChartBonus.setCategoryGap(10);
    	     barChartBonus.setLegendVisible(true);
    	     barChartBonus.setLegendSide(Side.RIGHT);
    	     barChartBonus.setVisible(true);
    	     
    	     
    	     // creazione bar chart età media
    	     
    	     ObservableList<Series<String, Double>> allSeries2 = barChart2.getData();
       	     
 			 if (updateReceived) {
       	        for (XYChart.Series<String, Double> series : allSeries2) {
       	            for (XYChart.Data<String, Double> data : series.getData()) {
       	                Node node = data.getNode();
       	                Parent parent = node.parentProperty().get();
       	                if (parent != null && parent instanceof Group) {
       	                    Group group = (Group) parent;
       	                    group.getChildren().clear();
       	                }
       	            }
       	        }
       	        allSeries2.clear();
       	     }
    	     
    	     barChart2.getData().clear();
    	     XYChart.Series<String, Double> series3 = new XYChart.Series<>(); 
    	     series3.setName("Uomini");
    	     final XYChart.Data<String,Double> data3 = new XYChart.Data<String,Double>("Età media",this.model.getAvgMaleAge());
    	     data3.nodeProperty().addListener(new ChangeListener<Node>() {
    	         @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
    	           if (node != null) {
    	             displayLabelForData(data3);
    	           } 
    	         }
    	       });
    	     series3.getData().add(data3);
    	     
    	     XYChart.Series<String, Double> series4 = new XYChart.Series<>(); 
    	     series4.setName("Donne");
    	     final XYChart.Data<String,Double> data4 = new XYChart.Data<>("Età media",this.model.getAvgFemaleAge());
    	     data4.nodeProperty().addListener(new ChangeListener<Node>() {
    	         @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
    	           if (node != null) {
    	             displayLabelForData(data4);
    	           } 
    	         }
    	       });
    	     series4.getData().add(data4);
    	     
    	     barChart2.getData().addAll(Arrays.asList(series3,series4));
    	     barChart2.setBarGap(2);
    	     barChart2.setCategoryGap(10);
    	     barChart2.setLegendVisible(true);
    	     barChart2.setLegendSide(Side.RIGHT);
    	     barChart2.setVisible(true);
    	     
    	     
    	     // creazione pie chart  istruzione
    	     
    	     double percFemaleCollege = this.model.getPercFemaleCollege();
    	     double percFemaleHighSchool = this.model.getPercFemaleHighSchool();
    	     double percFemaleMasters = this.model.getPercMaleMasters();
    	     double percFemalePhD = this.model.getPercFemalePhD();
    	     

    	     double percMaleCollege = this.model.getPercMaleCollege();
    	     double percMaleHighSchool = this.model.getPercMaleHighSchool();
    	     double percMaleMasters =this.model.getPercMaleMasters();
    	     double percMalePhD = this.model.getPercMalePhD();
    	     
    	     ObservableList<PieChart.Data> list2 = FXCollections.observableArrayList(
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
    	     
    	     
    	     ObservableList<PieChart.Data> list3 = FXCollections.observableArrayList(
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
     	     
     	     
     	     
     	    // creazione pie chart Performance Evaluation Score
     	    double percFemale1 = this.model.getPercFemale1();
     	    double percFemale2 = this.model.getPercFemale2();
     	    double percFemale3 = this.model.getPercFemale3();
     	    double percFemale4 = this.model.getPercFemale4();
     	    double percFemale5 = this.model.getPercFemale5();
     	    
     	    double percMale1 = this.model.getPercMale1();
     	    double percMale2 = this.model.getPercMale2();
     	    double percMale3 = this.model.getPercMale3();
     	    double percMale4 = this.model.getPercMale4();
     	    double percMale5 = this.model.getPercMale5();
     	    
     	    ObservableList<PieChart.Data> list4 = FXCollections.observableArrayList(
  	                new PieChart.Data("1 = "+percFemale1+" %", percFemale1),
  	                new PieChart.Data("2 = "+percFemale2+" %", percFemale2),
  	                new PieChart.Data("3 = "+percFemale3+" %", percFemale3),
  	                new PieChart.Data("4 = "+percFemale4+" %", percFemale4), 
  	                new PieChart.Data("5 = "+percFemale5+" %", percFemale5));
     	     
     	     pieChart4.setData(list4);
     	     pieChart4.setClockwise(true); 
     	     pieChart4.setLabelsVisible(true);
     	     pieChart4.setStartAngle(180);     
     	     pieChart4.setLegendVisible(true); 
     	     pieChart4.setVisible(true);
     	     pieChart4.setLabelLineLength(10);
     	     pieChart4.setLegendSide(Side.RIGHT);
     	     
     	     
     	    ObservableList<PieChart.Data> list5 = FXCollections.observableArrayList(
  	                new PieChart.Data("1 = "+percMale1+" %", percMale1),
  	                new PieChart.Data("2 = "+percMale2+" %", percMale2),
  	                new PieChart.Data("3 = "+percMale3+" %", percMale3),
  	                new PieChart.Data("4 = "+percMale4+" %", percMale4), 
  	                new PieChart.Data("5 = "+percMale5+" %", percMale5));
     	     
     	     pieChart5.setData(list5);
     	     pieChart5.setClockwise(true); 
     	     pieChart5.setLabelsVisible(true);
     	     pieChart5.setStartAngle(180);     
     	     pieChart5.setLegendVisible(true); 
     	     pieChart5.setVisible(true);
     	     pieChart5.setLabelLineLength(10);
     	     pieChart5.setLegendSide(Side.RIGHT);
    	     
    	     
     	    // creazione pie chart Seniority
     	     
      	    double percFemaleSen1 = this.model.getPercFemaleSen1();
      	    double percFemaleSen2 = this.model.getPercFemaleSen2();
      	    double percFemaleSen3 = this.model.getPercFemaleSen3();
      	    double percFemaleSen4 = this.model.getPercFemaleSen4();
      	    double percFemaleSen5 = this.model.getPercFemaleSen5();
      	    
      	    double percMaleSen1 = this.model.getPercMaleSen1();
      	    double percMaleSen2 = this.model.getPercMaleSen2();
      	    double percMaleSen3 = this.model.getPercMaleSen3();
      	    double percMaleSen4 = this.model.getPercMaleSen4();
      	    double percMaleSen5 = this.model.getPercMaleSen5();
      	    
      	    ObservableList<PieChart.Data> list6 = FXCollections.observableArrayList(
   	                new PieChart.Data("1 = "+percFemaleSen1+" %", percFemaleSen1),
   	                new PieChart.Data("2 = "+percFemaleSen2+" %", percFemaleSen2),
   	                new PieChart.Data("3 = "+percFemaleSen3+" %", percFemaleSen3),
   	                new PieChart.Data("4 = "+percFemaleSen4+" %", percFemaleSen4), 
   	                new PieChart.Data("5 = "+percFemaleSen5+" %", percFemaleSen5));
      	     
      	     pieChart6.setData(list6);
      	     pieChart6.setClockwise(true); 
      	     pieChart6.setLabelsVisible(true);
      	     pieChart6.setStartAngle(180);     
      	     pieChart6.setLegendVisible(true); 
      	     pieChart6.setVisible(true);
      	     pieChart6.setLabelLineLength(10);
      	     pieChart6.setLegendSide(Side.RIGHT);
      	     
      	     
      	    ObservableList<PieChart.Data> list7 = FXCollections.observableArrayList(
   	                new PieChart.Data("1 = "+percMaleSen1+" %", percMaleSen1),
   	                new PieChart.Data("2 = "+percMaleSen2+" %", percMaleSen2),
   	                new PieChart.Data("3 = "+percMaleSen3+" %", percMaleSen3),
   	                new PieChart.Data("4 = "+percMaleSen4+" %", percMaleSen4), 
   	                new PieChart.Data("5 = "+percMaleSen5+" %", percMaleSen5));
      	     
      	     pieChart7.setData(list7);
      	     pieChart7.setClockwise(true); 
      	     pieChart7.setLabelsVisible(true);
      	     pieChart7.setStartAngle(180);     
      	     pieChart7.setLegendVisible(true); 
      	     pieChart7.setVisible(true);
      	     pieChart7.setLabelLineLength(10);
      	     pieChart7.setLegendSide(Side.RIGHT);
    	     
    	     
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
    
    
    private void displayLabelForData(XYChart.Data<String, Double> data) {
  	  final Node node = data.getNode();
  	  final Text dataText = new Text(data.getYValue() + "");
  	  node.parentProperty().addListener(new ChangeListener<Parent>() {
  	    @Override public void changed(ObservableValue<? extends Parent> ov, Parent oldParent, Parent parent) {
  	    	  Group parentGroup = (Group) parent;
  	    	  if(parentGroup!=null && parentGroup.getChildren()!=null) {
  	  	    	parentGroup.getChildren().add(dataText);
  	  	      }
  	    }
  	  });

  	  node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
  	    @Override public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
  	      dataText.setLayoutX(
  	        Math.round(
  	          bounds.getMinX() + bounds.getWidth() / 2 - dataText.prefWidth(-1) / 2
  	        )
  	      );
  	      dataText.setLayoutY(
  	        Math.round(
  	          bounds.getMinY() - dataText.prefHeight(-1) * 0.5
  	        )
  	      );
  	    }
  	  });
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
         assert pieChart4 != null : "fx:id=\"pieChart4\" was not injected: check your FXML file 'ScenaAnalisiDati.fxml'.";
         assert pieChart5 != null : "fx:id=\"pieChart5\" was not injected: check your FXML file 'ScenaAnalisiDati.fxml'.";
         assert pieChart6 != null : "fx:id=\"pieChart6\" was not injected: check your FXML file 'ScenaAnalisiDati.fxml'.";
         assert pieChart7 != null : "fx:id=\"pieChart7\" was not injected: check your FXML file 'ScenaAnalisiDati.fxml'.";
         assert txtInfo != null : "fx:id=\"txtInfo\" was not injected: check your FXML file 'ScenaAnalisiDati.fxml'.";
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