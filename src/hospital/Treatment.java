package hospital;

public class Treatment {
    private int patientId;
    private String patientName;
    private String treatment;
    private String doctorName;

    public Treatment(int patientId, String patientName,
                     String treatment, String doctorName) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatment = treatment;
        this.doctorName = doctorName;
    }

    public void displayTreatment() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Treatment: " + treatment);
        System.out.println("Doctor Name: " + doctorName);
    }
}