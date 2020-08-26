
public class AppointmentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppointmentMain am = new AppointmentMain();
		am.start();
	}
	
	
	
	public void start() {
		
		int option = 0;
		while(option != 6) {
			AppointmentArray.menu();
			option = Helper.readInt("Enter option > ");
			
			
			if(option == 1) {
				System.out.println(AppointmentArray.viewAllappointments(AppointmentArray.appointmentList));

			}
			else if (option ==2 ) {
				AppointmentArray.addappointments(AppointmentArray.appointmentList, AppointmentArray.inputappointments() );
			}
			else if (option == 3) {
				int choose= Helper.readInt("Enter appointment ID to delete > ");
				AppointmentArray.deletappointments(choose);
			
				
		}
			
			else if(option ==4) {
				System.out.println("add meeting notes  ");
				boolean isTrue = false;
				int update = Helper.readInt("Enter appointment id: ");
				for(int i = 0; i<AppointmentArray.appointmentList.size(); i++) {
					if(AppointmentArray.appointmentList.get(i).getdateid() == update) {
						String meetingnotes = Helper.readString("Enter meeting notes > ");
						AppointmentArray.inputmeetingnotes(update, meetingnotes);
					}
				}
				if(isTrue == true) {
					System.out.println("date id Does not exist");
				}
				
				
			}
			else if(option ==5) {
				updatingmeeting();
			}
			
			else if(option ==6) {
				System.out.println("good bye!");
			}
			else {
				System.out.println("invalid input");
			}
		
	}
	
	}
	
	public void updatingmeeting() {
		boolean isTrue = false;
		int id = Helper.readInt("Enter Date ID > ");
		for(int i =0 ;i<AppointmentArray.appointmentList.size();i++) {
			if(AppointmentArray.appointmentList.get(i).getdateid() == id) {
				System.out.println("UPDATE MENU");
				System.out.println("1. Change day");
				System.out.println("2. Change month");
				System.out.println("3. Change year");
				System.out.println("4. Quit");
				int option = Helper.readInt("Enter option > ");
				
				if(option == 1) {
					int day = Helper.readInt("Enter day to change > ");
					System.out.println(AppointmentArray.changemeetingdate(id,option,day));
				}
				else if(option ==2) {
					int month = Helper.readInt("Enter month to change> ");
					System.out.println(AppointmentArray.changemeetingdate(id,option,month));

					
				}
				else if (option ==3) {
					int year  =Helper.readInt("Enter year to change > ");
					System.out.println(AppointmentArray.changemeetingdate(id,option,year));

				}
				else if(option ==4) {
					System.out.println("return to main menu");
				}
				else {
					System.out.println("invalid option");
				}
				
				isTrue = true;
				
			}
		}
		if(isTrue == false ) {
			System.out.println("Date id does not exit");
		}

	
		
		
	}

}
