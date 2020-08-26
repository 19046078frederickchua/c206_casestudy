import java.util.ArrayList;

public class AppointmentArray {

	
	
	
	
	public static ArrayList<appointments> appointmentList = new ArrayList<appointments>(); 
	
	public static void menu() {
		System.out.println("Appointments");
		System.out.println("1. Display appointments");
		System.out.println("2. Add appointments");
		System.out.println("3. delete appointments");
		System.out.println("4. update date (For administrators) ");
		System.out.println("5. add meeting notes  ");
		System.out.println("6. change meeting date ");
		System.out.println("7. Exit");
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
		boolean isture = false;
		for (int i = 0; i < appointmentlist.size(); i++) {
			System.out.println("appointment  LIST");
			isture = true;
//			System.out.println(mainappointments.showAvailability(appointmentlist.get(i)));
			output += String.format("%-20d %d/%d/%d", AppointmentArray.appointmentList.get(i).getdateid(),
					AppointmentArray.appointmentList.get(i).getDay(), AppointmentArray.appointmentList.get(i).getMonth(), AppointmentArray.appointmentList.get(i).getYear());
					
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
		String notes = Helper.readString("Enter meeting notes > ");
		
		appointments ap = new appointments( dateid ,day, month, year, notes);
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
	//===============================option 4 update ================================
	public static void updateappointment(int update) {
		int option = 0;

		 

        boolean isTrue = false;
    
            for(int i =0 ; i< appointmentList.size(); i++) {
                if(appointmentList.get(i).getdateid()==(update)) {
                    
                        System.out.println("1. Change date id ");
                        System.out.println("2. Change day");
                        System.out.println("3. Change month");
                        System.out.println("4. Change year");
                        System.out.println("5. Change time");
                        
                        option = Helper.readInt("Enter Option > ");
                        
                        if(option == 1) {
                            int  newdateid = Helper.readInt("Enter new date id  > ");
                            appointmentList.get(i).setdateid(newdateid);
                        }
                        else if(option == 2) {
                            int newday = Helper.readInt("Enter new day > ");
                            appointmentList.get(i).setDay(newday);
                        }
                        else if(option == 3) {
                            int newmonth = Helper.readInt("Enter new month > ");
                            appointmentList.get(i).setMonth(newmonth);
                        }
                        else if(option == 4) {
                            int newyear = Helper.readInt("Enter new year > ");
                            appointmentList.get(i).setYear(newyear);
                        }
                        else if(option == 5) {
                            String newtime = Helper.readString("Enter new time > ");
                            appointmentList.get(i).setTime(newtime);
                        }
                        else {
                            System.out.println("Invalid Option");
                        }
                    }
                
                isTrue = true;
                    
                }
            if(isTrue == false) {
                System.out.println("appointments does not exist");
            }
    }
	//===============================option 5 add meeting notes ================================
	public static void inputmeetingnotes(int id) {
		 for(int i =0 ; i< appointmentList.size(); i++) {
             if(appointmentList.get(i).getdateid()==(id)) {
		    String notes1  = Helper.readString("Enter meeting notes for the day");
		    appointmentList.get(i).setNotes(notes1);
		    System.out.println("notes updated ");
             }
             else{
            	 System.out.println("invalid id");
             }
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
		            		 appointmentList.get(i).setMonth(change);
		            		 output += "Month has been updated";
		            	 }
		            	 else if(option == 3) {
		            		 appointmentList.get(i).setYear(change);
		            		 output += "Year has been updated";
		            	 }
		         			
		            	
		             }
		             }
				 if(istrue == false) {
					 output += "Update Fail";
				 }
				 return output;
			}
			
				 
		 
	

	
	
	}

	
	
		
	
		
