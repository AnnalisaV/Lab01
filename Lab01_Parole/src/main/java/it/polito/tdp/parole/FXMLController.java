package it.polito.tdp.parole;


import it.polito.tdp.parole.model.EccezioneParolaVuota;
import it.polito.tdp.parole.model.Parole;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempi;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;

    @FXML
    void doInsert(ActionEvent event) {
 
    	//pulisco la casella ogni volta
    	txtResult.clear();
    	
    	String parola= this.txtParola.getText(); 
    	
    	
    	try {
    		elenco.addParola(parola);
    	}
    	catch(EccezioneParolaVuota epv) {
    		txtResult.appendText("Devi inserire una parola!\n");
    		return; 
    	}
    
    	// aggiunta la parola all'elenco lo visualizzo
    	for (String s : elenco.getElenco()) {
    		
    	txtResult.appendText(s+"\n");
    	}
    	
    	txtParola.clear(); 
    	
    	txtTempi.setText("Tempo richiesto per l'operazione: "+Long.toString(System.nanoTime())); // per visualizzare i tempi di esecuzione di ogni operazione
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    	txtParola.clear();
    	
    	txtTempi.setText("Tempo richiesto per l'operazione: "+Long.toString(System.nanoTime()));
    }

    @FXML
    void doCancella(ActionEvent event) {

    	String daEliminare= txtResult.getSelectedText(); 
    	elenco.cancella(daEliminare);
    	
    	//aggiorno la 'videata'
    	txtResult.clear();
    	for (String s : elenco.getElenco()) {
    		
        	txtResult.appendText(s+"\n");
        	}
    	
    	txtTempi.setText("Tempo richiesto per l'operazione: "+Long.toString(System.nanoTime()));
    	
    }
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
