package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_app implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> thechoicebox;

	@FXML
	public TextField temp_textfield;

	@FXML
	public Button buttonConvert;
	private String message;
	private float temp= 1f;
	private float conv ;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		thechoicebox.getItems().add("C-F");
		thechoicebox.getItems().add("F-C");
		thechoicebox.setValue("choose to convert");

		thechoicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				message= newValue;
				System.out.println(message);
			}
		});




		buttonConvert.setOnAction(event-> {
			System.out.println("m hogyela h click");
			String input= temp_textfield.getText();
			temp = Float.parseFloat(input);
			if (message=="C-F"){
				conv = (temp * 9/5) + 32;
				System.out.println(conv);
			}else if(message=="F-C"){
				conv =(temp - 32) * 5/9;
				System.out.println(conv);
			}
			String unit = (message == "C-F")? "°F": "°C";
			Alert alert= new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Result");
			alert.setHeaderText("The output is:");
			alert.setContentText(String.valueOf(conv)+unit);
			alert.show();
		});


	}
}
