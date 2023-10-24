package countdown;

import java.net.URL;
import java.time.LocalDate;
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
		
		headline.setText("Time to Christmas " + dates.getStart().getYear());
		
		//When its the Christmas Eve
		if(dates.getStart().isEqual(LocalDate.of(dates.getStart().getYear(), 12, 24))) {
			countdown.setText("Today is Christmas Eve! Happy Holidays!");
		}
		//When its already after Christmas Eve	
		else if (dates.getStart().isAfter(LocalDate.of(dates.getStart().getYear(), 12, 24))){
			countdown.setText("Christmas " + dates.getStart().getYear() + " has already passed!");
		}
		//Countdowntimer Set-up
		else {
			
			countdown.setText(dates.getPeriod().getMonths()
					+" : "+dates.getPeriod().getDays()
					+" : "+dates.getDuration().toHours()
					+" : "+(dates.getDuration().toMinutes()%60)
					+" : "+((dates.getDuration().toSeconds()%60)%60));

			//Countdown-Timer (Animation)
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
}
