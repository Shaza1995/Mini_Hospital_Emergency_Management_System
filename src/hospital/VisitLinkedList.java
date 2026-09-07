package hospital;

public class VisitLinkedList {

    private class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
        }
    }

    private Node head;

    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                System.out.println("Visit removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    public Visit searchVisit(int visitId) {
        Node current = head;

        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    public void displayVisits() {
        if (head == null) {
            System.out.println("No previous visits found.");
            return;
        }

        Node current = head;

        System.out.println("Patient Visit History:");
        System.out.println("----------------------------");

        while (current != null) {
            current.visit.displayVisit();
            System.out.println("----------------------------");
            current = current.next;
        }
    }
}