
public class AppointmentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppointmentMain am = new AppointmentMain();
		am.start();
	}
	
	
	public void start() {
		
		int option = 0;
		while(option != 4) {
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
				System.out.println("good bye!");
			}
		
	}
	
	
	}

}