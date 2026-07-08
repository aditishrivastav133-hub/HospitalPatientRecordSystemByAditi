import java.sql.*;
import java.util.*;

public class PatientDAO {

    Connection con = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);

    // Add Patient
    public void addPatient() {
        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();

            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            System.out.print("Enter Medical History: ");
            String medicalHistory = sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            String sql = "INSERT INTO patients(name,age,gender,disease,medical_history,phone) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, disease);
            ps.setString(5, medicalHistory);
            ps.setString(6, phone);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Added Successfully!");
            } else {
                System.out.println("Failed to Add Patient.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Patients
    public void viewPatients() {
        try {

            String sql = "SELECT * FROM patients";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println("-------------------------------");
                System.out.println("Patient ID : " + rs.getInt("patient_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Age        : " + rs.getInt("age"));
                System.out.println("Gender     : " + rs.getString("gender"));
                System.out.println("Disease    : " + rs.getString("disease"));
                System.out.println("History    : " + rs.getString("medical_history"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("-------------------------------");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Patient
    public void searchPatient() {
        try {

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();

            String sql = "SELECT * FROM patients WHERE patient_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Patient ID : " + rs.getInt("patient_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Age        : " + rs.getInt("age"));
                System.out.println("Gender     : " + rs.getString("gender"));
                System.out.println("Disease    : " + rs.getString("disease"));
                System.out.println("History    : " + rs.getString("medical_history"));
                System.out.println("Phone      : " + rs.getString("phone"));

            } else {
                System.out.println("Patient Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Patient
    public void updatePatient() {
        try {

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Disease: ");
            String disease = sc.nextLine();

            System.out.print("Enter New Medical History: ");
            String history = sc.nextLine();

            String sql = "UPDATE patients SET disease=?, medical_history=? WHERE patient_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, disease);
            ps.setString(2, history);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Updated Successfully!");
            } else {
                System.out.println("Patient Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Patient
    public void deletePatient() {
        try {

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM patients WHERE patient_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Deleted Successfully!");
            } else {
                System.out.println("Patient Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}