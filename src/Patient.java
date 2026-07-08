public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String medicalHistory;
    private String phone;

    // Default Constructor
    public Patient() {
    }

    // Parameterized Constructor
    public Patient(int patientId, String name, int age, String gender,
                   String disease, String medicalHistory, String phone) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.medicalHistory = medicalHistory;
        this.phone = phone;
    }

    // Getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDisease() {
        return disease;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}