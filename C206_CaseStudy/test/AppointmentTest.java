import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppointmentTest {

	private appointments ap1;
	private appointments ap2;
	
	@Before
	public void setUp() throws Exception {
		ap1 = new appointments(1,1,1,1, "2.30pm");
		ap2 = new appointments(2,2,2,2, "3.30pm");
	}

	@After
	public void tearDown() throws Exception {
		ap1 = null;
		ap2 = null;
		AppointmentArray.appointmentList.clear();
	}

	@Test
	public void inputappointments() {
		// Test that appointmelist is not null
		AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
				assertNotNull("Test that appointmentlist is not null", AppointmentArray.appointmentList.size());
				
				// Test that the size of appointmentlist is 0
				AppointmentArray.appointmentList.clear();
				assertEquals("Test that the size of appointmentlist is 0", 0, AppointmentArray.appointmentList.size());
				
				
				// Test that appointmentList size is 1 when 1 appointment object is added
				AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
				assertEquals("Test that the size of appointmentlist is 1", 1, AppointmentArray.appointmentList.size());
				AppointmentArray.appointmentList.clear();

				// Test that appointmentlist size is 2 when 2 appointment objects are added
				AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
				AppointmentArray.addappointments(AppointmentArray.appointmentList, ap2);
				System.out.println(AppointmentArray.appointmentList.size());
				assertEquals("Test that appointmentlist size is 2 when 2 appointment objects are added", 2,
						AppointmentArray.appointmentList.size());
				
				// Test that the first item in appointlist is the same
				AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
				assertEquals("Test that first item in appointmentlist is the same", ap1, AppointmentArray.appointmentList.get(0));
				
				// Test that the second item in appointmentlist is the same
				AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
				AppointmentArray.addappointments(AppointmentArray.appointmentList, ap2);
				assertEquals("Test that second item in appointmentlist is the same", ap2, AppointmentArray.appointmentList.get(1));
		 
	}
	@Test
	public void viewAllappointments() {

		// Test that appointmentlist is not null but empty
		assertNotNull("Test that appointmentlist is not null", AppointmentArray.appointmentList);
		
		//Test that viewAllappointments() method returns a String that equals to expectedOutput2
		AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
		AppointmentArray.addappointments(AppointmentArray.appointmentList, ap2);
		
		
		String output = String.format("%-20s %-20s %-15s %-15s\n", "APPOINTMENT ID", "APPOINTMENT DATE", "APPOINTMENT TIME","APPOINTMENT NOTES");
		
		for(int i = 0; i < AppointmentArray.appointmentList.size(); i++ ) {
			output += String.format("%-20d %d/%d/%-16d %-15s %-15s\n", AppointmentArray.appointmentList.get(i).getdateid(),
					AppointmentArray.appointmentList.get(i).getDay(), AppointmentArray.appointmentList.get(i).getMonth(), AppointmentArray.appointmentList.get(i).getYear(),
					AppointmentArray.appointmentList.get(i).getTime(),AppointmentArray.appointmentList.get(i).getNotes());
				
		}
		String viewappointment2 = AppointmentArray.retrieveAllappointments(AppointmentArray.appointmentList);
		assertEquals("Test that viewAllCategory() method return a String that equals expectedOutput2",output, viewappointment2);
		
	}
	@Test
	public void deletappointments() {
		// Test if the ArrayList is null?
		assertNotNull("//Test that instructorList is not null", AppointmentArray.appointmentList);

		// Test if the item arraylist is still 0 after adding student 1 into the array
		// list
		AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
		AppointmentArray.deletappointments(ap1.getdateid());
		assertEquals("Test if the appointment arraylist is still 0 after adding and deleting", 0,
				AppointmentArray.appointmentList.size());

		// Test if after adding ap1 and ap2 and deleting ap2 from the arrayList to
		// check
		// if the arraylist is equals to 1 after deleting one from the arraylist
		AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
		AppointmentArray.addappointments(AppointmentArray.appointmentList, ap2);
		AppointmentArray.deletappointments(ap2.getdateid());
		assertEquals("Test if the appointment arraylist is still 1 after adding 2 appointment and deleting 1 of the appointment",1, AppointmentArray.appointmentList.size());
		AppointmentArray.deletappointments(ap1.getdateid());

	}
	public void updateappointment() {
     
		
		//Test dateid does not exist error message
		String output = AppointmentArray.changemeetingdate(3,1,3);
		assertEquals("Test date id does not exist error message","date id does not exist", output);
		
		//Test invalid option error message
		String output2 = AppointmentArray.changemeetingdate(ap1.getdateid(),5,2);
		assertEquals("Test invalid option error message","Invalid Option", output2);
		
		//Test if Update dateid is  successful
		String output3 = AppointmentArray.changemeetingdate(ap1.getdateid(),1,3);
		assertEquals("Test if Update date id  is successful","Update date id  Successful", output3);
		
		//Test if option is correct  is successful
		String output4 = AppointmentArray.changemeetingdate(ap1.getdateid(),2,4);
		assertEquals("Test if Update day successful","Update Pday Successful", output4);
		
		//check that changes can only be made one day before 
		String output5= AppointmentArray.changemeetingdate(ap1.getdateid(),1,1);
		assertEquals("Test if the day is the same day  unsuccessful","change day unSuccessful", output5);
		
		String output6 = AppointmentArray.changemeetingdate(ap1.getdateid(),1,2);
		assertEquals("Test if change  day successful","change day Successful", output6);
				
		
	}
	public void inputmeetingnotes() {
		
		String notes = "this is for testing";
		// this is to Test that notes is added to the date after using setNotes() method
		AppointmentArray.appointmentList.add(ap1);
		AppointmentArray.inputmeetingnotes(AppointmentArray.appointmentList.get(0).getdateid(), notes);
		assertEquals("Test that notes is added into date after using setNotes() method", notes,AppointmentArray.appointmentList.get(0).getNotes());
		
		// this is to test if the meeting notes can be viewed 
		AppointmentArray.viewAllappointments(AppointmentArray.appointmentList);
		assertEquals("Test that notes is able to be viewed", notes,AppointmentArray.appointmentList.get(0).getNotes());
		
		// this is to test if the one that i input is the same with the one that i save 
		assertSame("Test if the one that i input is the same with the one that i save  ",notes,AppointmentArray.appointmentList.get(0).getNotes());
		
	}

	
	
}
