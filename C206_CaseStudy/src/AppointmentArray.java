import java.util.ArrayList;

public class AppointmentArray {

	
	
	
	public static ArrayList<appointments> appointmentList = new ArrayList<appointments>(); 
	
	public static void menu() {
		System.out.println("Appointments");
		System.out.println("1. Display appointments");
		System.out.println("2. Add appointments");
		System.out.println("3. delete appointments");
		System.out.println("4. Exit");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static boolean showAvailability(appointments appointments) {
		boolean avail;

		if (appointments == null) {
			avail = "Yes" != null;
		} else {
			avail = "No" != null;
		}
		return avail;
	}

	//================================= Option 1 View =================================
	public static String retrieveAllappointments(ArrayList<appointments> appointmentlist) {
		String output = String.format("%-20s %-10s\n", "APPOINTMENT ID", "APPOINTMENT DATE");

		for (int i = 0; i < appointmentlist.size(); i++) {

//			System.out.println(mainappointments.showAvailability(appointmentlist.get(i)));
			output += String.format("%-20d %d/%d/%d", AppointmentArray.appointmentList.get(i).getdateid(),
					AppointmentArray.appointmentList.get(i).getDay(), AppointmentArray.appointmentList.get(i).getMonth(), AppointmentArray.appointmentList.get(i).getYear());
					
		}
		return output;	
	}
	public static void viewAllappointments(ArrayList<appointments> appointmentlist) {
		System.out.println("appointment  LIST");
		 retrieveAllappointments(appointmentlist);	
		System.out.println(retrieveAllappointments(appointmentlist));
	}
		
	//================================= Option 2 Add =================================
	public static appointments inputappointments() {
		
		int dateid = Helper.readInt("Enter dateid > ");
		int day = Helper.readInt("Enter day > ");
		int month = Helper.readInt("Enter month > ");
		int year = Helper.readInt("Enter year > ");

		appointments ap = new appointments( dateid ,day, month, year);
		return ap;
		
	}
	public static void addappointments(ArrayList<appointments> appointmentlist, appointments ap) {
		
		appointmentlist.add(ap);
		System.out.println("appointment added");
	}
	
	
	//================================= Option 3 delete =================================
	
	public static void deletappointments(int del) {
		boolean avail = false;

		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getdateid()==(del)) {
				appointmentList.remove(i);
				avail =  true ;
			}

		}
		if (avail = false) {
			System.out.println("appointment Does not Exist");
		} else {
			System.out.println("appointment Deleted!");
		}
	}
}
