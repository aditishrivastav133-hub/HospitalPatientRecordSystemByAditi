import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Login login = new Login();

        if (!login.login()) {
            return;
        }

        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println(" HOSPITAL PATIENT RECORD SYSTEM ");
            System.out.println("======================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    dao.addPatient();
                    break;

                case 2:
                    dao.viewPatients();
                    break;

                case 3:
                    dao.searchPatient();
                    break;

                case 4:
                    dao.updatePatient();
                    break;

                case 5:
                    dao.deletePatient();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}