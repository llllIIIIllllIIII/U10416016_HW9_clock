import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ClockAnimation extends Application {
	@Override // Override the start method in the Application class
public void start(Stage primaryStage) {
	

	
	ClockPane clock = new ClockPane(); // Create a clock
 
 // Create a handler for animation
	EventHandler<ActionEvent> eventHandler = e -> {
	clock.setCurrentTime(); // Set a new clock time
	};
	
	EventHandler<ActionEvent> eventHandler2 = e ->{

		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date dateobj = new Date();
			primaryStage.setTitle(df.format(dateobj));
			
        }
		catch (Exception ex) { 
            ex.printStackTrace(); 
		}
		
	};

 // Create an animation for a running clock
	Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
	animation.setCycleCount(Timeline.INDEFINITE);
	animation.play(); // Start animation
	
	Timeline animation2 = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler2));
	animation2.setCycleCount(Timeline.INDEFINITE);
	animation2.play();

// Create a scene and place it in the stage
	Scene scene = new Scene(clock, 500,500);
	// Set the stage title
	primaryStage.setScene(scene); // Place the scene in the stage
	primaryStage.show(); // Display the stage
	
}
}	
