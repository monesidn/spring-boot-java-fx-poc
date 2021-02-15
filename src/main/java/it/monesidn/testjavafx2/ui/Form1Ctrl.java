package it.monesidn.testjavafx2.ui;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.monesidn.testjavafx2.service.HelloService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@Component
@Scope("prototype")
public class Form1Ctrl {
	
	@Autowired
	HelloService helloService;
	
	@FXML
	Button sayHelloBtn;
	@FXML
	TextField nameField;
	
	private void sayHello() {
		Alert alert;
		
		String name = nameField.getText();
		if (StringUtils.isWhitespace(name)) {
			alert = new Alert(AlertType.ERROR, "Please type a name in the text box!");
		} else {
			alert = new Alert(AlertType.INFORMATION, helloService.generateHello(name));
		}
		
		alert.showAndWait();
	}
	
	@FXML
	public void initialize(){
		System.out.println("Initialize called");
		sayHelloBtn.setOnAction(ev -> sayHello());
	}

}
