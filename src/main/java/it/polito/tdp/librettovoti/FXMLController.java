package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

public class FXMLController {
	
	/**
	 * DEVO RI SCRIVERE Libretto model e il suo set
	 */
	private Libretto model;  

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;


    @FXML // fx:id="txtEsame"
    private TextField txtEsame; // Value injected by FXMLLoader

    @FXML // fx:id="txtVoto"
    private TextField txtVoto; // Value injected by FXMLLoader
    
    
    @FXML // fx:id="pickerEsame"
    private DatePicker pickerEsame; // Value injected by FXMLLoader


   /* @FXML // fx:id="txtData"
    private TextField txtData; // Value injected by FXMLLoader */  //NON MI SERVE PIU', L'HO SOSTITUITO CON PICKERDATA

    

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	//LEGGI E CONTROLLA I DATI
    	
    	String nomeEsame= txtEsame.getText();
    	
    	//controllo sul nome
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE: nomeEsame vuoto");
    		return; 
    	}
    	
    	//controllo sul voto try/catch se è un numero e se compreso tra 18-30
    	String votoEsame= txtVoto.getText();
    	int votoInt=0;
    	
    	try {
             votoInt= Integer.parseInt(votoEsame);
    	} catch(NumberFormatException ex) {
    		txtResult.setText("ERRORE: il voto deve essere un numero");
    		return;
    		
    	}
    	
    	if(votoInt< 18 || votoInt>30) {
    		txtResult.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    		return;
    			}
    	
    	//controllo sulla data try/catch  --> cancello perchè lo sostituisco con PICKERESAME
    	/*String dataEsame= txtData.getText();
    	LocalDate data;
    	try{
    		data=LocalDate.parse(dataEsame);
    	} catch(DateTimeParseException ex) {
    		txtResult.setText("ERRORE: la data non è nel formato corretto");
    		return;
    		
    	}*/
    	
    	//controllo sulla data --> il PICKERDATA crea calendario e NON devo far controlli sul formato ecc
    	//questi sono incrementati già da questo PICKER DATA!
    	//controllo solo che sia stata inserita o meno una data
    	LocalDate data= pickerEsame.getValue();  
    	    if(data==null) {
            txtResult.setText("ERRORE: la data è errata o mancante");
            return;
    	}
    	
    	//ESEGUI L'AZIONE
    	/**
    	 * MI CREO IL NUOVO VOTO COMPOSTO DAI CAMPI COSTRUITI IN SCENE
    	 */
    	Voto voto= new Voto(nomeEsame,votoInt,data);  
    	model.add(voto);
    	
    	//AGGIORNA I RISULTATI --> nella View (Scene)
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	pickerEsame.setValue(null);
    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
       // assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
}
