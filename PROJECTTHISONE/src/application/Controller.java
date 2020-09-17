/*
 * 
 */
package application;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField; 


// TODO: Auto-generated Javadoc
//This class interacts with the user - functions

/**
 * <h1>The Controller Tab</h1>
 * As part of the MVC style this is the controller class that contains all the functionality of the program.
 */


public class Controller { 
	
	/** The act. */
	Activity act;
  
	/**
	 * <p>The summary button calculates the sum of the points. </p>
	 * @param textbox This is the text-box where we will display the total points onto after calculation.
	 * @param pointslist We get each points from this list. We convert each points in it to its integer form.
	 */
	 void Summarybutton( TextArea textbox, ArrayList<Integer> pointslist) { 
		 int count = 0; 
		 for (int index=0; index <pointslist.size();++index) { 
		 count = count + pointslist.get(index); } 
		 textbox.appendText("total: "+String.valueOf(count) );
	} 
	  
	 /**
	  * The Addbutton adds every entry entered in the textfields into an arraylist.
	  * @param w This holds week value in string form
	  * @param d This holds the date value in string form
	  * @param combovalue This holds the activity value in string form
	  * @param p This holds the points value in string form
	  * @param comboB This holds the combobox list of items
	  * @param textbox This holds the textbox so we can print the resulting arraylist onto it
	  * @param pointslist This is the list of points
	  * @param arrlist  This is the list of activities
	  * @param dateList This is the list of dates
	  * @return arrlist This returns the list of activities
	  */
	 
	public Object Addbutton(String w,String d,String combovalue,String p, ComboBox<String> comboB, TextArea textbox, ArrayList<Integer> pointslist,  ArrayList<Activity> arrlist, ArrayList<String> dateList  ) {
		  
		 Activity newA = new Activity();
		 Object o = w + " " + d + " " + combovalue  + " " +  p;
		 newA.setWeek(w);
		 newA.setDate(d);
		 newA.setActivity(combovalue);
		 newA.setPoints(p); 
		 arrlist.add(newA); 
		 pointslist.add(Integer.parseInt(p));   //pointslist being added to
		   
		 if (w.isEmpty()   ||  p.isEmpty() || combovalue.isEmpty() || d.isEmpty()) {
		    String comment = "you have not finished completing this form!";
		    textbox.appendText(comment); } 
		 else {    
		    comboB.getItems().add(combovalue);  
		    dateList.add(d);
		    textbox.appendText("~"+o +"\n");  } 
		return arrlist ;  
	 }   
	
	 
	 /**
 	 * <p>The Listbutton displays each activity object in the activity arraylist</p>.
 	 *
 	 * @param w This holds week value in string form
 	 * @param d This holds the date value in string form
 	 * @param a This holds the activity value in string form
 	 * @param p This holds the points value in string form
 	 * @param arrlist This is the list of activities
 	 * @param textbox This holds the textbox so we can print the resulting arraylist onto it
 	 * @param combobox This holds the list of items for the combo box
 	 */
		 
		public void Listbutton( String w,String d,String a,String p,ArrayList<Activity> arrlist, TextArea textbox , ComboBox<String> combobox) {
			   textbox.appendText("\nList:\n");  
			  
			   for(Activity str: arrlist){  
					textbox.appendText(str.toString()+"\n");
			    	     
		 }  }
 
		
		 /**
 		 * <p>The submit button is used when we want to remove an object from the Activities arraylist</p> .
 		 *
 		 * @param textbox This holds the textbox so we can print the resulting Activities arraylist onto it
 		 * @param arrlist This is the list of activities
 		 * @param indexfield This holds the position in which you chose which object to remove from the Activities list
 		 * @param pointslist This holds the list of points
 		 * @param comboB This holds the list of items for the combo box
 		 * @return arrlist Returns resulting Activities list after removal of an object.
 		 */
		public Object submit(TextArea textbox, ArrayList<Activity> arrlist, TextField indexfield , ArrayList<Integer> pointslist, ComboBox<String> comboB) {   
			textbox.appendText("\nplease enter the number in the pop up window\n");
			String s = indexfield.getText();
			textbox.appendText(s);
			int choice = Integer.parseInt(s); 
			arrlist.remove(choice );
			pointslist.remove(choice);
			comboB.getItems().remove(choice); 
				
			textbox.appendText("new array: "+ arrlist.toString()); 
			return arrlist;  
			}
			
		
		 /**
 		 * <p>The serialise button serialises the objects into a text file</p> .
 		 *
 		 * @param arrlist This is the list of activities
 		 * @param comboB the combo B
 		 */
		 
		public void serialise(ArrayList<Activity> arrlist , ComboBox<String> comboB  ) {
				 
			try
		        {
		           FileOutputStream fos = new FileOutputStream("D:\\OOP1submissionFolder\\serialisation.txt");
		           ObjectOutputStream oos = new ObjectOutputStream(fos);
		           oos.writeObject(arrlist); 
		           oos.close();
		           fos.close();
		            
		           FileWriter fw = new FileWriter("D:\\OOP1submissionFolder\\activities.txt", true);
		           for(int i = 0;i<arrlist.size();i++) { 
		             //  fw.write(comboB.getItems().get(i).toString());
		            fw.write(arrlist.get(i).getActivity()+"\n");	 
		            }
		            
		               Scanner s = new Scanner(new File("D:\\OOP1submissionFolder\\activities.txt"));
				            while (s.hasNextLine()){
				            comboB.getItems().add(s.nextLine()+"\n");
				        }
				        s.close(); 
				        fw.close();  
		        } 
		     catch (IOException ioe)   {
		           ioe.printStackTrace();  }
		    
		        }  
			       
		 /**
 		 * <p>The desserialise button deserialises the char bytes from the text file into text form again.</p> 
 		 *
 		 * @param arrlist This is the list of activities
 		 * @param comboB the combo B
 		 * @throws IOException Signals that an I/O exception has occurred.
 		 */ 
		
			@SuppressWarnings("unchecked")
			public void deserialise(ArrayList<Activity> arrlist , ComboBox<String> comboB ) throws IOException {
					 
				 ArrayList<Activity> activity = new ArrayList<>(); 
			     try  {
				      FileInputStream fis = new FileInputStream("D:\\OOP1submissionFolder\\serialisation.txt");
				      ObjectInputStream ois = new ObjectInputStream(fis);
				      activity = (ArrayList<Activity>) ois.readObject(); 
				      ois.close();
				      fis.close(); 
				        }
				        catch (IOException ioe) { 
				            ioe.printStackTrace();
				            return;  } 
				        catch (ClassNotFoundException c)  {
				            System.out.println("Class not found");
				            c.printStackTrace();
				            return; }
				         
				        //Verify list data
				        for (Activity act : activity) { 
				            System.out.println(act);
				            comboB.getItems().toString();   }
				        
				       /* for(int i=0;i<arrlist.size();i++) {
				        	System.out.println("combo get items part");
				        	System.out.println(comboB.getItems().get(i)); 
				        	System.out.println(arrlist.get(i));
				        }*/  
			 }
 
			 /**
 			 * <p>The OrderingByDate button displays the dates in ascending order.
 			 * The later years are displayed first. The earlier years are displayed later on in the list.</p> 
 			 *
 			 * @param tarea This holds the text area so we can print the ordered dates onto it
 			 * @param a This is the list of activities
 			 * @param dateList This holds the list of dates
 			 */ 
			
				public void OrderingByDate(TextArea tarea, ArrayList<Activity> a, ArrayList<String> dateList) {
					tarea.appendText("<><><><><><><><>\nOrdering by Dates:\n"); 
					Collections.sort(a, Activity.ActDateComparator);
					    
					for(int i=0;i<a.size();i ++) { 
						if (dateList.get(i)==dateList.get(i)) { 
							tarea.appendText(a.get(i).datePrint()+"\n");
						} } 
				}
				 
				
				/**
				 * <p>The OrderingByActivities button displays the activities in alphabetical order </p>  .
				 *
				 * @param tarea This holds the text area so we can print the ordered dates onto it
				 * @param a This is the list of activities
				 */
				
				public void OrderingByActivity(TextArea tarea, ArrayList<Activity> a) { 
					List<Activity> unsortList = new ArrayList<Activity>(); 
					tarea.appendText("<><><><><><><><>\nOrdering by Activities:\n");
					int k = 1;
					Collections.sort(a, Activity.ActNameComparator); 
					 for(int i = 0;i< a.size() ;i++) {  
						 unsortList.add(a.get(i));  
						 tarea.appendText(k+".)"+((Activity) unsortList.get(i)).getActivity()+"\n"); 
						 k++;
					 } 
				 
					 }

				/**
				 * Extrabutton.
				 */
				public void extrabutton() {
					 
					ArrayList<Object> objects = new ArrayList<Object>();
					for(int i=0;i<50;i++) {
						
						Activity a = new Activity();
						a.setActivity("cycle to work");
						a.setDate("21/02/2020");
						a.setPoints("3");
						a.setWeek("6");
						
						objects.add(a);
						
					}
					for(Object o: objects) {
					System.out.println(o+"\n");
					}
				}}  