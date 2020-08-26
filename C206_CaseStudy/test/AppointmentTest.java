import static org.junit.Assert.*;


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
		int newdateid = 9;
		int newday = 9;
		int newmonth = 9;
		int newyear= 2000;
		String newtime ="3.40pm";
		// Test that date id  is updated to newdateid after using setdateid() method
		ap1.setdateid(newdateid);
		int updatedateid = ap1.getdateid();
		assertEquals("Test that dateid is updated to newdateid after using setdateid() method", newdateid,updatedateid);
		// Test that day is updated to newday after using setDay() method
		ap1.setDay(newday);
		int updateday = ap1.getDay();
		assertEquals("Test that Day is updated to newday after using setDay() method", newday,updateday);
		// Test that day is updated to newday after using setYear() method
		ap1.setMonth(newmonth);
		int updatemonth =  ap1.getMonth();
		assertEquals("Test that month is updated to newmonth after using setMonth() method", newmonth,updatemonth);
		// Test that year is updated to newyear after using setDay() method
		ap1.setYear(newyear);
		int updateyear = ap1.getYear();
		assertEquals("Test that year is updated to newyear after using setYear() method", newyear,updateyear);
		// Test that time is updated to newtime after using setDay() method
		ap1.setTime(newtime);
		String updatetime = ap1.getTime();
		assertEquals("Test that year is updated to newtime after using setTime() method", newtime,updatetime);
				
	}
	public void inputmeetingnotes() {
		
		String notes = "this is for testing";
		// this is to Test that notes is added to the date after using setNotes() method
		AppointmentArray.appointmentList.add(ap1);
		AppointmentArray.inputmeetingnotes(AppointmentArray.appointmentList.get(0).getdateid(), notes);
		assertEquals("Test that notes is added into date after using setNotes() method", notes,AppointmentArray.appointmentList.get(0).getNotes());
		
		
		
	}
	public void changemeetingdate() {
		//check that changes can only be made one day before 
		
		
		
	} 

}
