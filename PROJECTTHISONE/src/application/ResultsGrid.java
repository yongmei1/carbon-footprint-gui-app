/*
 * 
 */
  package application;
import java.util.ArrayList;  
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.scene.control.Button; 
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea; 
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text; 


// TODO: Auto-generated Javadoc
/**
 * <h1>The Results Grid Tab</h1>
 * This tab allows you to enter activities, dates, weeks and points.
 *  */
public class ResultsGrid extends Tab {   
	 
	
	//--------------   //  Sets up this panel with some buttons to show how grid   
	//  layout affects their position, shape, and size.   //-------------   
	

	/** The processor. */
	private Controller processor = new Controller();
	
	/** The actgrid. */
	private ActivitiesGrid actgrid = new ActivitiesGrid();
	 
	/**
	 * Instantiates a new results grid.
	 */
	public ResultsGrid()   {     
	 
		GridPane grid = new GridPane();
		grid.setHgap(10);  //shifts everything down
		grid.setVgap(10);   // shifts  everything right->
		grid.setPadding(new Insets(65, 65, 65, 65));    //padding : moves everything away from top left corner to a more center area
		 
		BackgroundFill background_fill = new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill);
		
		grid.setBackground(background); 
		VBox box  = new VBox();
		
		HBox buttons = new HBox();
		Text title = new Text("Results Page");
		TextArea tarea = new TextArea();
		Button date = new Button("order by date");
		Button extra = new Button("extra button");
		Button activity = new Button("order by activities");
		 
		buttons.getChildren().addAll(date, extra, activity);
		buttons.setSpacing(100);
		box.getChildren().addAll(title, tarea, buttons);
		
		grid.add(box, 3, 1);
		
		setContent(grid);
		setText("Results");
		
		date.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) { 
				ArrayList<Activity>  a = ActivitiesGrid.getArrlist();
				ArrayList<String> dateList = actgrid.getdates();
				processor.OrderingByDate(tarea, a, dateList); 
				} });
		
		
		activity.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) { 
				ArrayList<Activity>  a = ActivitiesGrid.getArrlist();
				processor.OrderingByActivity(tarea, a); 
			} });
		
		extra.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) { 
				ArrayList<Activity>  a = ActivitiesGrid.getArrlist(); 
				processor.extrabutton(  ); 
				} });
      }}