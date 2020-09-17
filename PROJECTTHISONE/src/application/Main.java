/*
 * 
 */
package application; 

import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage; 


// TODO: Auto-generated Javadoc
/**
 * <h1>The Activities Grid Tab</h1>
 * This tab allows you to enter activities, dates, weeks and points.
 *  */

/**
 * @author yongmei chen
 *
 */
public class Main extends Application {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);}
    
	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
			BorderPane mainPane = new BorderPane(); 
			Group root = new Group(); 
			
			Scene scene = new Scene(root,700,500);
			
			TabPane tp = new TabPane();      
			tp.getTabs().add (new Introduction());                
			tp.getTabs().add (new ActivitiesGrid());  
			tp.getTabs().add (new ResultsGrid()); 
			mainPane.setCenter(tp);      
			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());      
			root.getChildren().add(mainPane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("My Carbon Awareness Project");
			primaryStage.show();
			 
	 }}
	   