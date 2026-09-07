package hospital;

public class TreatmentStack {

    private class Node {
        Treatment treatment;
        Node next;

        Node(Treatment treatment) {
            this.treatment = treatment;
        }
    }

    private Node top;

    public void push(Treatment treatment) {
        Node newNode = new Node(treatment);
        newNode.next = top;
        top = newNode;

        System.out.println("Treatment record added to stack.");
    }

    public Treatment pop() {
        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        Treatment treatment = top.treatment;
        top = top.next;

        System.out.println("Most recent treatment record removed.");
        return treatment;
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        Node current = top;

        System.out.println("Treatment History:");
        System.out.println("----------------------------");

        while (current != null) {
            current.treatment.displayTreatment();
            System.out.println("----------------------------");
            current = current.next;
        }
    }
}