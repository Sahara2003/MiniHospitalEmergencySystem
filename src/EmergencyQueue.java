public class EmergencyQueue {
    // Node class for Queue
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public EmergencyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue - add patient to the queue
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
    }

    // Dequeue - remove and return the next patient
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No patients to treat.");
            return null;
        }

        Patient patient = front.patient;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("Patient " + patient.getName() + " is now being treated.");
        return patient;
    }

    // Peek - view the next patient without removing
    public Patient peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return front.patient;
    }

    // Display all patients in queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n--- Emergency Queue (Waiting Patients) ---");
        System.out.println("Total waiting: " + size + " patients");
        System.out.println("----------------------------------------");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
        System.out.println("----------------------------------------");
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get queue size
    public int getSize() {
        return size;
    }
}