import java.util.Scanner;

public class Main {
    private static PatientBST patientBST = new PatientBST();
    private static EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static TreatmentStack treatmentStack = new TreatmentStack();
    private static VisitHistory visitHistory = new VisitHistory();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextPatientId = 1001;
    private static int nextVisitId = 1;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   MINI HOSPITAL EMERGENCY SYSTEM");
        System.out.println("========================================");
        System.out.println("Welcome! Let's build this step by step.");

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            
            // FIX: Better input validation
            while (!scanner.hasNextInt()) {
                System.out.print("❌ Invalid input! Please enter a number (0-14): ");
                scanner.next(); // Clear the invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    searchPatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    displayPatients();
                    break;
                case 5:
                    addEmergencyPatient();
                    break;
                case 6:
                    treatNextPatient();
                    break;
                case 7:
                    displayEmergencyQueue();
                    break;
                case 8:
                    addTreatmentRecord();
                    break;
                case 9:
                    removeLatestTreatment();
                    break;
                case 10:
                    displayTreatmentHistory();
                    break;
                case 11:
                    addPatientVisit();
                    break;
                case 12:
                    removePatientVisit();
                    break;
                case 13:
                    searchPatientVisit();
                    break;
                case 14:
                    displayVisitHistory();
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please enter a number between 0 and 14.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("   MINI HOSPITAL EMERGENCY SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display Patients (In-order)");
        System.out.println("5. Add Emergency Patient");
        System.out.println("6. Treat Next Patient");
        System.out.println("7. Display Emergency Queue");
        System.out.println("8. Add Treatment Record");
        System.out.println("9. Remove Latest Treatment");
        System.out.println("10. Display Treatment History");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Remove Patient Visit");
        System.out.println("13. Search Patient Visit");
        System.out.println("14. Display Visit History");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    // ========== BST Operations ==========
    
    private static void addPatient() {
        System.out.println("\n--- Add New Patient ---");
        
        int patientId = nextPatientId++;
        System.out.println("✅ Auto-generated Patient ID: " + patientId);
        
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        
        // Validate age input
        int age = 0;
        while (true) {
            System.out.print("Enter Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine();
                if (age > 0 && age < 150) {
                    break;
                } else {
                    System.out.println("❌ Please enter a valid age (1-149)");
                }
            } else {
                System.out.println("❌ Please enter a valid number for age");
                scanner.next();
            }
        }
        
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();
        
        Patient patient = new Patient(patientId, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("✅ Patient added successfully!");
    }

    private static void searchPatient() {
        System.out.println("\n--- Search Patient ---");
        System.out.print("Enter Patient ID to search: ");
        int id = getValidIntInput();
        
        Patient patient = patientBST.search(id);
        if (patient != null) {
            System.out.println("✅ Patient found:");
            System.out.println(patient);
        } else {
            System.out.println("❌ Patient with ID " + id + " not found.");
        }
    }

    private static void deletePatient() {
        System.out.println("\n--- Delete Patient ---");
        System.out.print("Enter Patient ID to delete: ");
        int id = getValidIntInput();
        
        boolean deleted = patientBST.delete(id);
        if (deleted) {
            System.out.println("✅ Patient with ID " + id + " deleted successfully.");
        } else {
            System.out.println("❌ Patient with ID " + id + " not found.");
        }
    }

    private static void displayPatients() {
        patientBST.inorderTraversal();
    }

    // ========== Queue Operations ==========

    private static void addEmergencyPatient() {
        System.out.println("\n--- Add Emergency Patient ---");
        System.out.print("Enter Patient ID to add to emergency queue: ");
        int id = getValidIntInput();
        
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("❌ Patient not found. Please register the patient first.");
            return;
        }
        
        emergencyQueue.enqueue(patient);
    }

    private static void treatNextPatient() {
        System.out.println("\n--- Treat Next Patient ---");
        Patient patient = emergencyQueue.dequeue();
        if (patient != null) {
            // When treatment is completed, we can add to treatment stack
            System.out.println("✅ Treatment completed for: " + patient.getName());
            String treatmentRecord = "Patient: " + patient.getName() + 
                                   " (ID: " + patient.getPatientId() + 
                                   ") treated for " + patient.getMedicalCondition();
            treatmentStack.push(treatmentRecord);
        }
    }

    private static void displayEmergencyQueue() {
        emergencyQueue.display();
    }

    // ========== Stack Operations ==========

    private static void addTreatmentRecord() {
        System.out.println("\n--- Add Treatment Record ---");
        System.out.print("Enter treatment description: ");
        String record = scanner.nextLine();
        if (record.trim().isEmpty()) {
            System.out.println("❌ Treatment description cannot be empty.");
            return;
        }
        treatmentStack.push(record);
    }

    private static void removeLatestTreatment() {
        System.out.println("\n--- Remove Latest Treatment ---");
        treatmentStack.pop();
    }

    private static void displayTreatmentHistory() {
        treatmentStack.display();
    }

    // ========== Linked List Operations ==========

    private static void addPatientVisit() {
        System.out.println("\n--- Add Patient Visit ---");
        
        System.out.print("Enter Visit Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        
        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        
        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();
        
        Visit visit = new Visit(nextVisitId++, date, doctor, diagnosis, treatment);
        visitHistory.addVisit(visit);
    }

    private static void removePatientVisit() {
        System.out.println("\n--- Remove Patient Visit ---");
        System.out.print("Enter Visit ID to remove: ");
        int id = getValidIntInput();
        visitHistory.removeVisit(id);
    }

    private static void searchPatientVisit() {
        System.out.println("\n--- Search Patient Visit ---");
        System.out.print("Enter Visit ID to search: ");
        int id = getValidIntInput();
        
        Visit visit = visitHistory.searchVisit(id);
        if (visit != null) {
            System.out.println("✅ Visit found:");
            System.out.println(visit);
        } else {
            System.out.println("❌ Visit with ID " + id + " not found.");
        }
    }

    private static void displayVisitHistory() {
        visitHistory.display();
    }

    // ========== Helper Method for Valid Integer Input ==========
    
    private static int getValidIntInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return value;
            } else {
                System.out.print("❌ Please enter a valid number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }
}// Version 2.0 - Improved error handling
// Main class with console menu
