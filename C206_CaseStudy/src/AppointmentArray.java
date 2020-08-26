import java.util.ArrayList;

public class AppointmentArray {

	
	
	
	
	public static ArrayList<appointments> appointmentList = new ArrayList<appointments>(); 
	
	public static void menu() {
		System.out.println("Appointments");
		System.out.println("1. Display appointments");
		System.out.println("2. Add appointments");
		System.out.println("3. delete appointments");
		System.out.println("4. add meeting notes  ");
		System.out.println("5. change meeting date ");
		System.out.println("6. Exit");
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
		String output = String.format("%-20s %-20s %-15s %-15s\n", "APPOINTMENT ID", "APPOINTMENT DATE","APPOINTMENT TIME", "APPOINTMENT NOTES");
		boolean isture = false;
		for (int i = 0; i < appointmentlist.size(); i++) {
			System.out.println("appointment  LIST");
			isture = true;
//			System.out.println(mainappointments.showAvailability(appointmentlist.get(i)));
			output += String.format("%-20d %d/%d/%-16d %-15s %-15s\n", AppointmentArray.appointmentList.get(i).getdateid(),
					AppointmentArray.appointmentList.get(i).getDay(), AppointmentArray.appointmentList.get(i).getMonth(), AppointmentArray.appointmentList.get(i).getYear(),
					AppointmentArray.appointmentList.get(i).getTime(),AppointmentArray.appointmentList.get(i).getNotes());
					
		}
		if(isture == false) {
			output += "No appointment Found";
		}
		return output;	
	}
	public static String viewAllappointments(ArrayList<appointments> appointmentlist) {
		System.out.println("appointment  LIST");

		return retrieveAllappointments(appointmentlist);	

	}
		
	//================================= Option 2 Add =================================
	public static appointments inputappointments() {
		
		int dateid = Helper.readInt("Enter dateid > ");
		int day = Helper.readInt("Enter day > ");
		int month = Helper.readInt("Enter month > ");
		int year = Helper.readInt("Enter year > ");
		String time = Helper.readString("Enter meeting time > ");
		
		appointments ap = new appointments( dateid ,day, month, year,time);
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
	
	
    
	//===============================option 5 add meeting notes ================================
	public static void inputmeetingnotes(int id, String notes) {
		boolean isTrue = false;
		 for(int i =0 ; i< appointmentList.size(); i++) {
			 isTrue = true;
             if(appointmentList.get(i).getdateid()==(id)) {
		    appointmentList.get(i).setNotes(notes);
		    System.out.println("notes updated ");
             }
           
		 }
		 if(isTrue == false) {
			 System.out.println("Appointment does not exist");
		 }
		 }
		//===============================option 6 change meeting date ================================
			public static String changemeetingdate(int id, int option, int change) {
				boolean istrue = false;
				String output = "";
				 for(int i =0 ; i< appointmentList.size(); i++) {
		             if(appointmentList.get(i).getdateid()==(id)) {
		            	 istrue = true;
		            	 if(option == 1) {
		            		 if(change == appointmentList.get(i).getDay()) {
		            			 output += "update fail you can't change a meeting day on the day itself";
		            		 }
		            		 else {
		            		 appointmentList.get(i).setDay(change);
		            		 output += "Day has been updated";
		            		 }
		            	 }
		            	 else if(option == 2) {
		            		
		            		 if(change < appointmentList.get(i).getMonth()) {
		            			 output += "Appointment cannot be in the past";
		            		 }
		            		 else {
		            			 appointmentList.get(i).setMonth(change);
		            		 output += "Month has been updated";
		            		 }
		            	 }
		            	 else if(option == 3) {
		            		 if(change < appointmentList.get(i).getYear()) {
		            			 output += "Year Cannot be in the past";
		            		 }
		            		 else {
		            		 appointmentList.get(i).setYear(change);
		            		 output += "Year has been updated";
		            		 }
		            	 }
		         			
		            	
		             }
		             }
				 if(istrue == false) {
					 output += "Update Fail";
				 }
				 return output;
			}
			
				 
		 
	

	
	
	}

	
	
		
	
		
