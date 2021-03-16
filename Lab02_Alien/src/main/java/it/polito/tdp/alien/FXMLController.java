package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary model = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParole;

    @FXML
    private Button btnTranslae;

    @FXML
    private TextArea txtTraduzione;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	model.reset();
    	txtParole.clear();
    	txtTraduzione.clear();
    }

    @FXML
    void doTranslare(ActionEvent event) {
    	String testo = txtParole.getText();
    	try {
    	String set[] = testo.split(" ");
    	if(set[1]!=null) {
    		model.addWord(set[0].toLowerCase(), set[1].toLowerCase());
    		txtTraduzione.setText("Nuova parola salvata");
    		return;
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	List<String> traduzione = new LinkedList<>();
    	traduzione.addAll(model.traslateWord(testo));
    	if(traduzione.isEmpty()) {
    		txtTraduzione.setText("Parola non presente nel dizionario");
    		return;
    	}
    	else {
    		txtTraduzione.setText(testo.toLowerCase()+" significa:\n");
    		for(String s : traduzione)
    			txtTraduzione.appendText(s+"\n");
  
    		return;
    		}
    

    }

    @FXML
    void initialize() {
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslae != null : "fx:id=\"btnTranslae\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
