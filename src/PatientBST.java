public class PatientBST {
    // Node class for BST
    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    // Insert a patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        } else {
            System.out.println("Patient with ID " + patient.getPatientId() + " already exists!");
        }
        return root;
    }

    // Search for a patient by ID
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Node root, int patientId) {
        if (root == null) {
            return null;
        }

        if (patientId == root.patient.getPatientId()) {
            return root.patient;
        }

        if (patientId < root.patient.getPatientId()) {
            return searchRec(root.left, patientId);
        } else {
            return searchRec(root.right, patientId);
        }
    }

    // Delete a patient by ID
    public boolean delete(int patientId) {
        if (search(patientId) == null) {
            return false;
        }
        root = deleteRec(root, patientId);
        return true;
    }

    private Node deleteRec(Node root, int patientId) {
        if (root == null) {
            return null;
        }

        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get inorder successor (smallest in right subtree)
            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }

    private Patient minValue(Node root) {
        Patient min = root.patient;
        while (root.left != null) {
            min = root.left.patient;
            root = root.left;
        }
        return min;
    }

    // In-order traversal (displays patients in ascending ID order)
    public void inorderTraversal() {
        System.out.println("\n--- Patients in Ascending Order of ID ---");
        inorderRec(root);
        if (root == null) {
            System.out.println("No patients in the system.");
        }
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.patient);
            inorderRec(root.right);
        }
    }

    // Check if BST is empty
    public boolean isEmpty() {
        return root == null;
    }
}