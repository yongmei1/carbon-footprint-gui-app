/*
 * 
 */
package application;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos; 
import javafx.scene.control.Tab; 
import javafx.scene.image.Image; 
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
// TODO: Auto-generated Javadoc

/**
 * The Class Introduction.
 */
public class Introduction extends Tab{   
	
	 
	/**
	 * <h1>The Introduction Tab</h1>
	 * This tab allows you to enter activities, dates, weeks and points.
	 *  */ 
	public Introduction()   {     
		 
		   
		try {
			GridPane p = new GridPane();
			FileInputStream input = new FileInputStream("D:\\year 2 semester 2\\object oriented programming\\splashpage.jpg");
		 
			Image image = new Image(input );
			BackgroundImage backim= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background background = new Background(backim); 
			p.setBackground(background);  
			setText("Introduction");   
		    
		 
			Text l1 = new Text ("My Carbon Awareness Effort Application");      
			
			VBox box = new VBox();
		 	box.getChildren().add(l1); 
		 	p.getChildren().add(box);
		 	p.setAlignment(Pos.CENTER);
		 	l1.setFont(Font.font("Arial", 28)); 
		 	l1.setFill(Color.WHITESMOKE);
		 	setContent(p); 
		 
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		 
		 
	}} 