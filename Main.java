package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] i_see_you){
		launch(i_see_you);
		/* Ignore  that if you are professional java programmer.
		   I am just learning JAVAFX by Developing this small project.*/
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		//first we have to load our fxml file
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_ui.fxml"));
		//now we try to load stage on which scenes are displayed in this case we have virtual box as stage.
		VBox rootNode= loader.load();

		//now i am loading out menubar on root
		MenuBar menuBar= createMenu();
		rootNode.getChildren().add(0,menuBar);


		//now load all the scenes on root which is virtual box.
		Scene scene = new Scene(rootNode,400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Measurement");
		primaryStage.show();

	}
	private MenuBar createMenu(){
		Menu fileMenu= new Menu("File");

		Menu helpMenu = new Menu("Help");

		MenuBar menuBar =new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}
}
