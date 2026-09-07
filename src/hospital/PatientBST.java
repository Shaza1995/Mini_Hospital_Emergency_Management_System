package hospital;

public class PatientBST {

    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;

    public void insert(Patient patient) {
        root = insertPatient(root, patient);
    }

    private Node insertPatient(Node root, Patient patient) {
        if (root == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertPatient(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertPatient(root.right, patient);
        } else {
            System.out.println("Patient ID already exists.");
        }

        return root;
    }

    public Patient search(int patientId) {
        Node current = root;

        while (current != null) {
            if (patientId == current.patient.getPatientId()) {
                return current.patient;
            }

            if (patientId < current.patient.getPatientId()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public void delete(int patientId) {
        if (search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        root = deletePatient(root, patientId);
        System.out.println("Patient deleted successfully.");
    }

    private Node deletePatient(Node root, int patientId) {
        if (root == null) {
            return null;
        }

        if (patientId < root.patient.getPatientId()) {
            root.left = deletePatient(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deletePatient(root.right, patientId);
        } else {

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node successor = findMinimum(root.right);
            root.patient = successor.patient;
            root.right = deletePatient(root.right,
                    successor.patient.getPatientId());
        }

        return root;
    }

    private Node findMinimum(Node root) {
        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients registered.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            root.patient.displayPatient();
            System.out.println("----------------------------");
            inOrder(root.right);
        }
    }
}