package it.monesidn.testjavafx2;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import it.monesidn.testjavafx2.ui.Form1Ctrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Component
public class Ui extends Application {
	
	private ConfigurableApplicationContext applicationContext;
	
	@Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(App.class).run();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Ui.class.getResource("/views/form1.fxml"));
		loader.setController(this.applicationContext.getBean(Form1Ctrl.class));

		Scene scene = new Scene(loader.load());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
