
public class AppointmentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppointmentMain am = new AppointmentMain();
		am.start();
	}
	
	
	public void start() {
		
		int option = 0;
		while(option != 7) {
			AppointmentArray.menu();
			option = Helper.readInt("Enter option > ");
			
			
			if(option == 1) {
				AppointmentArray.viewAllappointments(AppointmentArray.appointmentList);

			}
			else if (option ==2 ) {
				AppointmentArray.addappointments(AppointmentArray.appointmentList, AppointmentArray.inputappointments() );
			}
			else if (option == 3) {
				int choose= Helper.readInt("Enter appointment ID to delete > ");
				AppointmentArray.deletappointments(choose);
			
				
		}
			else if(option ==4) {
				System.out.println("Update appointments");
				int update = Helper.readInt("Enter appointment id: ");
				AppointmentArray.updateappointment(update);
			}
			else if(option ==5) {
				System.out.println("add meeting notes  ");
				int update = Helper.readInt("Enter appointment id: ");
				AppointmentArray.inputmeetingnotes(update);
			}
			else if(option ==6) {
				System.out.println("change meeting day  ");
				int update = Helper.readInt("Enter appointment id : ");
				AppointmentArray.changemeetingdate(update);
			}
			
			else if(option ==7) {
				System.out.println("good bye!");
			}
		
	}
	
	
	}

}
