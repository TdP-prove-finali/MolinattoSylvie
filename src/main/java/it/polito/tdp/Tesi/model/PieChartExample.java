package it.polito.tdp.Tesi.model;
import javafx.application.Application; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.chart.PieChart; //classe che estende la classe dell'applicazione 

public class PieChartExample extends Application{ 
	
	//punto iniziale dell'applicazione 
	@Override 
	public void start(Stage s) { //oggetto di ObservbleList con ogni percentuale di slice 
		
		ObservableList pcd=FXCollections.observableArrayList(new PieChart.Data("Felice",50), 
				           new PieChart.Data("Triste", 25), new PieChart.Data("Nessuna emozione", 10), 
				           new PieChart.Data("Confuso", 15)); 
	    //creazione del grafico a torta 
		PieChart pc=new PieChart(pcd); 
		//Imposta il titolo del grafico 
		pc.setTitle("Emotions of human"); 
		//direzione del grafico a torta creato 
		pc.setClockwise(true); 
		//lunghezza delle righe dell&39;etichetta nel grafico a torta 
		pc.setLabelLineLength(45); 
		//visibilità delle etichette nel grafico 
		pc.setLabelsVisible(true); 
		//angolo iniziale che deve essere utilizzato nel grafico 
		pc.setStartAngle(180); 
		//Creazione oggetto gruppo 
		Group r=new Group(pc); 
		//creazione oggetto scena 
		Scene sc=new Scene(r, 600, 400); 
		//imposta il titolo dello stage 
		s.setTitle("grafico a torta"); 
		//Aggiungi scena a 
		s.setScene(sc); 
		//Visualizzazione dei risultati 
		s.show(); 
	} 
	
	
	public static void main(String args[]){ 
		launch(args); 
	} 
}