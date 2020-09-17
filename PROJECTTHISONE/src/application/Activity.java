/*
 * 
 */
package application;

import java.awt.TextField;
import java.io.Serializable;
import java.util.Comparator;
import java.lang.Object; 
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker; 
import java.util.ArrayList;  
// TODO: Auto-generated Javadoc
//import javafx.scene.control.TextField;

 
/**
 * <h1>The Activity Class</h1>
 * <p>This class, the Activity class contains all the getters and setters for this program. 
 * By importing comparator interface we can use its various functionalities in our own code.
 * By making this class implement the Serializable interface, it enables us to serialize and deserialize this class.</p>
 * @author  Mei Chen  
 */


public class Activity implements Serializable {  
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The week. */
	private   String week;
	
	/** The date. */
	private   String date;
	
	/** The activity. */
	private   String activity;
	
	/** The points. */
	private   String points;  
	
	/** The pointslist. */
	private static ArrayList<Integer> pointslist = new ArrayList<Integer>();
	 
	
	/**
	 * This is the general constructor for this class.
	 */
	public Activity() {   }
	
	
	/**
	 * This is the constructor for this class that holds all the instances and private attributes.
	 * @param week The week as a string
	 * @param date   The date as a string
	 * @param activity  The activity as a string
	 * @param points  The points as a string which is later turned to an integer for calculation measures
	 * @param t1  This textfield1  text-field allows us to store the week entered by the user.
	 * @param comboB  The ComboBox which stores the activities.
	 * @param t3  This text-field 3 allows us to store the points the user decides to enter.
	 * @param choosedate  This enables the user to store the date from the DatePicker after choosing it
	 */
	
	//DatePicker choosedate   - maybe change that to a string...
	//this.date = choosedate.getValue().toString();
	
	public Activity(String week, String date, String activity, String points, TextField t1, ComboBox<String> comboB, TextField t3, DatePicker choosedate) {
		this.activity=comboB.getValue().toString();
		this.points=t3.getText();
		this.date = choosedate.getValue().toString();     
		this.week = t1.getText();
		
	} 
	
	
	/**
	 * This comparator compares the activities through using the comparator interface and then sorts them into an alphabetical order .
	 * 
	 */
	public static Comparator<Activity> ActNameComparator = new Comparator<Activity>() {
		public int compare(Activity s1, Activity s2) {
		   String activity1 = s1.getActivity().toUpperCase();
		   String activity2 = s2.getActivity().toUpperCase();
 
		   return activity1.compareTo(activity2);   //ascending order
		   //return activity2.compareTo(activity1);     //descending order
	    }};
	    
	 /**
 	 * This comparator compares the dates through using the comparator interface and then sorts them into an ascending order .
 	 * 
 	 */
	     
	    public static Comparator<Activity> ActDateComparator = new Comparator<Activity>() { 
	    	public int compare(Activity s1, Activity s2) {
	    		String date1 = s1.getDate().toUpperCase();
	    		String date2 = s2.getDate().toUpperCase();
  
	    		return date1.compareTo(date2);   //ascending order
	    		//return date2.compareTo(date1);    //descending order
	    }};
	     
	  /**
	   * This method returns the pointsList if we need it.
	   * @return pointsList  The pointsList 
	   */
	public Object getPList() {
		return pointslist;
	}
	
	 /**
	  * This method allows us to get the week.
	  * @return week  The week is returned. 
	  */
	
	public String getWeek() {
		return week;
	}

	/**
	 * This method allows us to set the week.
	 *
	 * @param week the week
	 * @return this.week  The week is returned after setting it.
	 */
	public String setWeek(String week) {
		return this.week = week;
	}
	/**
	  * This method allows us to get the date.
	  * @return date  The date is returned. 
	  */
	public String getDate() {
		return date;
	}
	
	/**
	 * This method allows us to set the date.
	 *
	 * @param date the date
	 * @return this.date  The date is returned after setting it.
	 */
	public String setDate(String date) {
		 return this.date = date;
	}
	/**
	  * This method allows us to get the activity.
	  * @return activity  The activity is returned. 
	  */
	public String getActivity() {
		return activity;
	}
	
	/**
	 * This method allows us to set the activity.
	 *
	 * @param activity the activity
	 * @return this.activity  The activity is returned after setting it.
	 */
	public String setActivity(String activity) {
		return this.activity = activity;
	}
	/**
	  * This method allows us to get the points.
	  * @return points  The points is returned. 
	  */
	public String getPoints() {
		return points;
	}
	
	/**
	 * This method allows us to set the points.
	 *
	 * @param points the points
	 * @return this.points  The points you set is returned.
	 */
	public String setPoints(String points) {
		return this.points = points;
	}
 
	/**
	  * This toString method is one we overridden for our own taste. 
	  * @return   The string is returned in the format in which we want it in. 
	  */
	@Override
    public String toString() {
        return "week: " + week + ", date: " + date + ", activity: " + activity + " points: " + points ;
    }
	
	/**
	 * The method datePrint acts as a toString for the dates. 
	 * It serves its purpose in the results tab when we want to only view the dates and activities
	 * @return   This string is returned and can be then displayed wherever
	 */
	public String datePrint() { 
		return "~date: "+ date + " "+ activity;
	}
 
}