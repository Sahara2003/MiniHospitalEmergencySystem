public class TreatmentStack {
    // Node class for Stack
    private class Node {
        String treatmentRecord;
        Node next;

        Node(String treatmentRecord) {
            this.treatmentRecord = treatmentRecord;
            next = null;
        }
    }

    private Node top;
    private int size;

    public TreatmentStack() {
        top = null;
        size = 0;
    }

    // Push - add a treatment record
    public void push(String treatmentRecord) {
        Node newNode = new Node(treatmentRecord);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Treatment record added: " + treatmentRecord);
    }

    // Pop - remove and return the most recent treatment
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No treatment records to remove.");
            return null;
        }

        String record = top.treatmentRecord;
        top = top.next;
        size--;
        System.out.println("Removed latest treatment: " + record);
        return record;
    }

    // Peek - view the most recent treatment without removing
    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return top.treatmentRecord;
    }

    // Display all treatment records (most recent first)
    public void display() {
        if (isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        System.out.println("\n--- Treatment History (Most Recent First) ---");
        System.out.println("Total records: " + size);
        System.out.println("---------------------------------------------");
        Node current = top;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.treatmentRecord);
            current = current.next;
            position++;
        }
        System.out.println("---------------------------------------------");
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get stack size
    public int getSize() {
        return size;
    }
}