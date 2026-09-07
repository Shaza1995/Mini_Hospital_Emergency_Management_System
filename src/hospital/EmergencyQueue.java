package hospital;

public class EmergencyQueue {

    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node front;
    private Node rear;

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Patient added to emergency queue.");
    }

    public Patient dequeue() {
        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println("Patient removed from emergency queue.");
        return patient;
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        Node current = front;

        System.out.println("Patients Waiting for Treatment:");
        System.out.println("----------------------------");

        while (current != null) {
            current.patient.displayPatient();
            System.out.println("----------------------------");
            current = current.next;
        }
    }
}