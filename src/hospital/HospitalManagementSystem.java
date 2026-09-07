package hospital;

import java.util.Scanner;

public class HospitalManagementSystem {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    displayAllPatients();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    treatNextPatient();
                    break;

                case 7:
                    displayWaitingPatients();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    removeLatestTreatment();
                    break;

                case 10:
                    displayTreatmentHistory();
                    break;

                case 11:
                    addVisit();
                    break;

                case 12:
                    removeVisit();
                    break;

                case 13:
                    searchVisit();
                    break;

                case 14:
                    displayVisitHistory();
                    break;

                case 0:
                    System.out.println("Thank you for using the Hospital Emergency Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n==============================================");
        System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        System.out.println("\n--- Patient Management (BST) ---");
        System.out.println("1. Register New Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");

        System.out.println("\n--- Emergency Queue ---");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Patient");
        System.out.println("7. Display Waiting Patients");

        System.out.println("\n--- Treatment History (Stack) ---");
        System.out.println("8. Add Completed Treatment");
        System.out.println("9. Remove Latest Treatment");
        System.out.println("10. Display Treatment History");

        System.out.println("\n--- Patient Visit History (Linked List) ---");
        System.out.println("11. Add Visit");
        System.out.println("12. Remove Visit");
        System.out.println("13. Search Visit");
        System.out.println("14. Display Visit History");

        System.out.println("\n0. Exit");
        System.out.println("==============================================");
    }

    public static void registerPatient() {

        System.out.println("\n--- Register New Patient ---");

        int id = getIntInput("Enter Patient ID: ");

        if (patientBST.search(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        int age = getIntInput("Enter Age: ");

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id,
                name,
                age,
                contact,
                condition
        );

        patientBST.insert(patient);

        System.out.println("Patient registered successfully.");
    }

    public static void searchPatient() {

        System.out.println("\n--- Search Patient ---");

        int id = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("\nPatient Found:");
            System.out.println("----------------------------");
            patient.displayPatient();
        }
    }

    public static void deletePatient() {

        System.out.println("\n--- Delete Patient ---");

        int id = getIntInput("Enter Patient ID: ");

        patientBST.delete(id);
    }

    public static void displayAllPatients() {

        System.out.println("\n--- All Registered Patients ---");

        patientBST.displayInOrder();
    }

    public static void addEmergencyPatient() {

        System.out.println("\n--- Add Patient to Emergency Queue ---");

        int id = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found. Please register the patient first.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    public static void treatNextPatient() {

        System.out.println("\n--- Treat Next Patient ---");

        Patient patient = emergencyQueue.dequeue();

        if (patient != null) {
            System.out.println("\nPatient selected for treatment:");
            patient.displayPatient();
        }
    }

    public static void displayWaitingPatients() {

        System.out.println("\n--- Emergency Waiting Queue ---");

        emergencyQueue.displayQueue();
    }

    public static void addTreatment() {

        System.out.println("\n--- Add Completed Treatment ---");

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        Treatment treatmentRecord = new Treatment(
                patient.getPatientId(),
                patient.getPatientName(),
                treatment,
                doctor
        );

        treatmentStack.push(treatmentRecord);
    }

    public static void removeLatestTreatment() {

        System.out.println("\n--- Remove Latest Treatment ---");

        Treatment treatment = treatmentStack.pop();

        if (treatment != null) {
            System.out.println("\nRemoved Treatment:");
            treatment.displayTreatment();
        }
    }

    public static void displayTreatmentHistory() {

        System.out.println("\n--- Treatment History ---");

        treatmentStack.displayStack();
    }

    public static void addVisit() {

        System.out.println("\n--- Add Patient Visit ---");

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = getIntInput("Enter Visit ID: ");

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        patient.getVisitHistory().addVisit(visit);

        System.out.println("Visit added to patient's history.");
    }

    public static Patient findPatientForVisit() {

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
        }

        return patient;
    }

    public static void removeVisit() {

        System.out.println("\n--- Remove Patient Visit ---");

        Patient patient = findPatientForVisit();

        if (patient == null) {
            return;
        }

        int visitId = getIntInput("Enter Visit ID: ");

        patient.getVisitHistory().removeVisit(visitId);
    }

    public static void searchVisit() {

        System.out.println("\n--- Search Patient Visit ---");

        Patient patient = findPatientForVisit();

        if (patient == null) {
            return;
        }

        int visitId = getIntInput("Enter Visit ID: ");

        Visit visit = patient.getVisitHistory().searchVisit(visitId);

        if (visit == null) {
            System.out.println("Visit not found.");
        } else {
            System.out.println("\nVisit Found:");
            System.out.println("----------------------------");
            visit.displayVisit();
        }
    }

    public static void displayVisitHistory() {

        System.out.println("\n--- Patient Visit History ---");

        Patient patient = findPatientForVisit();

        if (patient == null) {
            return;
        }

        patient.getVisitHistory().displayVisits();
    }

    public static int getIntInput(String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }
}