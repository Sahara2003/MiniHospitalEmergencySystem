public class VisitHistory {
    // Node class for Linked List
    private class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            next = null;
        }
    }

    private Node head;
    private int size;

    public VisitHistory() {
        head = null;
        size = 0;
    }

    // Add a visit
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
        size++;
        System.out.println("Visit added successfully: " + visit);
    }

    // Remove a visit by ID
    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return false;
        }

        // If the head node needs to be removed
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            size--;
            System.out.println("Visit with ID " + visitId + " removed.");
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Visit with ID " + visitId + " not found.");
            return false;
        }

        current.next = current.next.next;
        size--;
        System.out.println("Visit with ID " + visitId + " removed.");
        return true;
    }

    // Search for a visit by ID
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

    // Display all visits
    public void display() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.println("\n--- Patient Visit History ---");
        System.out.println("Total visits: " + size);
        System.out.println("-----------------------------");
        Node current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.visit);
            current = current.next;
            position++;
        }
        System.out.println("-----------------------------");
    }

    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Get list size
    public int getSize() {
        return size;
    }
}