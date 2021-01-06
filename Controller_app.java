package sample;

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

		thechoicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			message= newValue;
			System.out.println(message);
		});


		buttonConvert.setOnAction(event-> {
			String input=temp_textfield.getText();
			try{
				temp = Float.parseFloat(input);
				String unit = (message == "C-F")? "°F": "°C";
				Alert alert= new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Result");
				alert.setHeaderText("The output is:");
				alert.setContentText(String.valueOf(conv)+unit);
				alert.show();
			}catch(Exception e){
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Result");
				alert.setHeaderText("Warning");
				alert.setContentText(String.valueOf(e));
				alert.show();
			}

			if (message=="C-F"){
				conv = (temp * 9/5) + 32;
			}else if(message=="F-C"){
				conv =(temp - 32) * 5/9;
			}
		});


	}
}
