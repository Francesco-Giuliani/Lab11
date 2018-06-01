package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimulation;

    @FXML
    private TextArea txtResult;

    @FXML
    void startSimulation(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnSimulation != null : "fx:id=\"btnSimulation\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
    public void setModel(Model model) {
    	this.model = model;
    }

}
