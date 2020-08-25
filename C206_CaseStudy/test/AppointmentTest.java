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

}
