package it.monesidn.testjavafx2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		Application.launch(Ui.class, args);
	}
}
