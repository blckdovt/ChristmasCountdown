package countdown;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CountdownController implements Initializable {

	@FXML
	private Label countdown;

	@FXML
	private Label headline;

	@FXML
	private AnchorPane root;
	 
	@FXML
	private Label description;

	private Dates dates;

	public void initialize(URL arg0, ResourceBundle arg1) {

		dates = new Dates();
		
		countdown.setText(dates.getPeriod().getMonths()
				+" : "+dates.getPeriod().getDays()
				+" : "+dates.getDuration().toHours()
				+" : "+(dates.getDuration().toMinutes()%60)
				+" : "+((dates.getDuration().toSeconds()%60)%60));

		headline.setText("Time to Christmas " + dates.getStart().getYear());

		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(1), e -> {
					dates = new Dates();
					countdown.setText(dates.getPeriod().getMonths()
							+" : "+dates.getPeriod().getDays()
							+" : "+dates.getDuration().toHours()
							+" : "+(dates.getDuration().toMinutes()%60)
							+" : "+((dates.getDuration().toSeconds()%60)%60));

				})
				);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}	
}
