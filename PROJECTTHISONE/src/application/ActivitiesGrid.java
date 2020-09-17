/*
 * 
 */
package application;

import java.io.IOException;  
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii; 
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * <h1>The Activities Grid Tab</h1>
 * This tab allows you to enter activities, dates, weeks and points.
 *  */

public class ActivitiesGrid extends Tab  {   
	
	/** The act. */
	Activity act = new Activity();
	
	/** The processor. */
	private Controller processor = new Controller(); 
	
	/** The week. */
	private   Label week;
	
	/** The date. */
	private   Label date;
	 
	/** The activity. */
	private   Label activity;
	
	/** The points. */
	private   Label points; 
	
	/** The textbox. */
	private   TextArea textbox;
	 
	/** The arrlist. */
	private static ArrayList<Activity> arrlist = new ArrayList<>(); 
	
	/** The pointslist. */
	private static ArrayList<Integer> pointslist = new ArrayList<>();  
	
	/** The date list. */
	private static ArrayList<String> dateList = new ArrayList<>();
	
	
	/** The combolist. */
	ObservableList<String> combolist =  FXCollections.observableArrayList();
	 
     /**
      * The activities grid acts as a view for the activity tab. 
      * */
	
	public ActivitiesGrid ()   {   
		setText("Activities");
		GridPane grid = new GridPane();
		grid.setHgap(10);  
		grid.setVgap(10);  
		grid.setPadding(new Insets(65, 65, 65, 65));     
		 
		week = new Label("Week------------"); 
		date = new Label("Date-------------"); 
		activity = new Label("Activity----------"); 
		points = new Label("Points-----------");
		 
		week.setFont(Font.font("Arial", 12)); 
		date.setFont(Font.font("Arial", 12)); 
		activity.setFont(Font.font("Arial", 12)); 
		points.setFont(Font.font("Arial", 12)); 
		
		HBox text1 = new HBox();  
		HBox text2 = new HBox();
		HBox text3 = new HBox();
		HBox text4 = new HBox();
		
		HBox box= new HBox(); 
		VBox downbox = new VBox();
		HBox bottomscreen = new HBox(); 
		
		textbox = new TextArea();
		textbox.setText("Activities to be displayed\n");
		Button removebutton = new Button("Remove");
		Button add = new Button("Add");
		Button list = new Button("List");
		Button summary = new Button("Summary"); 
		Button savebutton = new Button("Save");  
		Button loadbutton = new Button("Load"); 
		
		TextField userTextField = new TextField( );
		DatePicker choosedate = new DatePicker();     
		ComboBox<String> comboB = new ComboBox<String>( combolist);  // Combobox creation 
		comboB.setEditable(true); 
		TextField userTextField4 = new TextField( ); 
		userTextField.setPromptText("Enter the week here"); 
		text2.getChildren().addAll(date, choosedate); 
		userTextField4.setPromptText("Enter the points here"); 
		
		userTextField.setFont(Font.font("Arial", 12));   
		userTextField4.setFont(Font.font("Arial", 12));
		removebutton.setFont(Font.font("Arial", 12)); 
		add.setFont(Font.font("Arial", 12)); 
		list.setFont(Font.font("Arial", 12)); 
		summary.setFont(Font.font("Arial", 12)); 
		savebutton.setFont(Font.font("Arial", 12)); 
		loadbutton.setFont(Font.font("Arial", 12)); 
		
		text1.getChildren().addAll(week, userTextField);
		text3.getChildren().addAll(activity, comboB);
		text4.getChildren().addAll(points, userTextField4);
		
		grid.add(text1, 0, 0); 
		grid.add(text2, 0, 1); 
		grid.add(text3, 0, 2); 
		grid.add(text4, 0, 3);
		
		   
		ObservableList<Node> bigbox = box.getChildren();  
		ObservableList<Node> vbox = downbox.getChildren(); 
		  
		  
		box.setSpacing(100);   //Spacing
	    bottomscreen.setSpacing(420);
	    bigbox.addAll(removebutton,add,list,summary); 
	    bottomscreen.getChildren().addAll(savebutton, loadbutton);
	    vbox.addAll(textbox, bottomscreen); 
	    grid.add(box, 0, 5); 
		grid.add(downbox,0,7);
		 
		setContent(grid);   //setting it to the stage
      
		
		BackgroundFill background_fill = new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		grid.setBackground(background); 
		
		
		
		add.setOnAction(new EventHandler<ActionEvent>(){ 
			 @Override
			 public void handle(ActionEvent event) {  
				 String temp= choosedate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
				 String d = act.setDate(temp.toString());
				 String w = act.setWeek(userTextField.getText());
				 String p = act.setPoints(userTextField4.getText());   
				 String temp2 = comboB.getValue().toString();
				 String c =  act.setActivity(  temp2) ; 
				 processor.Addbutton(w, d, c,p,  comboB , textbox, pointslist, arrlist, dateList); 
			 }	 });   
		
		savebutton.setOnAction(new EventHandler<ActionEvent>(){
			  @Override
			   public void handle(ActionEvent event) {   
				  try { processor.deserialise(arrlist, comboB );
					
				} catch (IOException e) { 
					e.printStackTrace(); }
			  }  }
	); 
			  
		
		// Loadbutton function : reads activities from activities file and loads them into the combobox list
		loadbutton.setOnAction(new EventHandler<ActionEvent>(){
			 
			@Override
			   public void handle(ActionEvent event) {  
			    processor.serialise(arrlist,  comboB );
			     }  
	}); 
				//REMOVE POP UP WINDOW: 
						Stage popupwindow=new Stage(); 
						GridPane popupgrid = new GridPane(); 
						Scene sc = new Scene(popupgrid, 400, 200);
						Label word = new Label("choice: ");
						TextField indexfield = new TextField();
						Button close= new Button("Close window");
						Button submit = new Button("Submit"); 
				
			close.setOnAction(new EventHandler<ActionEvent>() {
					@Override
			public void handle(ActionEvent e) {
			    popupwindow.close();
				 }
			}); 
				
			removebutton.setOnAction(new EventHandler<ActionEvent>(){
					 @Override
					public void handle(ActionEvent event) { 
						 popupwindow.show();
							VBox box = new VBox();
							popupwindow.setScene(sc); 
							box.getChildren().addAll(word, indexfield, close , submit);
							box.setSpacing(5);
							popupgrid.setHgap(10);   
							popupgrid.setVgap(10);    
							popupgrid.setPadding(new Insets(10, 10, 10, 10)); 
							popupgrid.add(box, 0, 1); 
							 
							textbox.appendText("\nwhich one do u want to remove?\n please enter the number in the pop up window textbox\n");  
							for(int i =0;i< arrlist.size();i++) {  
								textbox.appendText(i+ ".) "+arrlist.get(i).toString()+"\n");  
							}}});
			
			 submit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					processor.submit( textbox,  arrlist , indexfield, pointslist, comboB );
				}
			});
			
			//list function call:
				String a = act.getActivity();
				String w = act.getWeek();
				String p = act.getPoints();
				String d = act.getDate();
				list.setOnAction(new EventHandler<ActionEvent>(){ 
					@Override
					public void handle(ActionEvent e) {
						processor.Listbutton( w, d, a, p, arrlist, textbox, comboB); } 
							  });  
							
			//SUMMARY FUNCTION: CALCULATE UP THE POINTS
			summary.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) { 
					processor.Summarybutton( textbox, pointslist); 
					}
				}); 
			 
		}


	/**
	 * Gets the arrlist.
	 *
	 * @return list of activities
	 */
	public static ArrayList<Activity> getArrlist() {
		return  arrlist;
	}
  
	/**
	 * Gets the dates.
	 *
	 * @return the dates
	 */
	public static ArrayList<String> getdates(){ 
		return dateList;
	}
	
	/**
	 * Gets the combolist.
	 *
	 * @return list of activities in combo box
	 */
	public  ObservableList<String> clist(){
		return combolist;
	}
}