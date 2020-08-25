import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppointmentTest {

	private appointments ap1;
	private appointments ap2;
	
	@Before
	public void setUp() throws Exception {
		ap1 = new appointments(1,1,1,1);
		ap2 = new appointments(2,2,2,2);
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
		// Test if the  appointmentlist is empty
		String testOutput = "No appointment Found";
		String viewappointment = AppointmentArray.retrieveAllappointments(AppointmentArray.appointmentList);
		assertEquals("Test if the appointmentlist is empty", testOutput,viewappointment );

		//Test that viewAllappointments() method returns a String that equals to expectedOutput2
		AppointmentArray.addappointments(AppointmentArray.appointmentList, ap1);
		AppointmentArray.addappointments(AppointmentArray.appointmentList, ap2);
		
		String output = String.format("%-20s %-10s\n", "APPOINTMENT ID", "APPOINTMENT DATE");
		
		for(int i = 0; i < AppointmentArray.appointmentList.size(); i++ ) {
			output += String.format("%-20d %d/%d/%d", AppointmentArray.appointmentList.get(i).getdateid(),
					AppointmentArray.appointmentList.get(i).getDay(), AppointmentArray.appointmentList.get(i).getMonth(), AppointmentArray.appointmentList.get(i).getYear());
				
		}
		String viewappointment2 = AppointmentArray.retrieveAllappointments(AppointmentArray.appointmentList);
		assertEquals("Test that viewAllCategory() method return a String that equals expectedOutput2",output, viewappointment2);
		
	}


}
