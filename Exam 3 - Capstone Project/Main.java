/*public class Main {
    public static void main(String[] args) {
        EmergencyRoomScheduler scheduler = new EmergencyRoomScheduler();

        scheduler.addPatient("Alice", "Mild cough", 2);
        scheduler.addPatient("Bob", "Chest pain", 9);
        scheduler.addPatient("Cindy", "Fever", 5);
        scheduler.addPatient("David", "Broken arm", 7);
        scheduler.addPatient("Emma", "Headache", 5);

        System.out.println("Number of patients waiting: " + scheduler.size());

        System.out.println("\nNext patient to be treated:");
        System.out.println(scheduler.peekNextPatient());

        System.out.println("\nTreating patients in priority order:");

        while (!scheduler.isEmpty()) {
            Patient patient = scheduler.treatNextPatient();
            System.out.println(patient);
        }

        System.out.println("\nNumber of patients waiting: " + scheduler.size());
    }
}
*/
public class Main {

    public static void main(String[] args) {
        testEmptyScheduler();
        testHighestPriorityFirst();
        testTieByArrivalOrder();
        testInvalidPriority();
        testPeekDoesNotRemove();

        System.out.println("\nAll tests finished.");
    }

    // Test 1: Boundary Test - empty scheduler
    public static void testEmptyScheduler() {
        EmergencyRoomScheduler scheduler = new EmergencyRoomScheduler();

        Patient result = scheduler.treatNextPatient();

        if (result == null) {
            System.out.println("PASS: Empty scheduler returns null.");
        } else {
            System.out.println("FAIL: Empty scheduler should return null.");
        }
    }

    // Test 2: Logic Validation - highest priority patient should be treated first
    public static void testHighestPriorityFirst() {
        EmergencyRoomScheduler scheduler = new EmergencyRoomScheduler();

        scheduler.addPatient("Alice", "Mild cough", 2);
        scheduler.addPatient("Bob", "Chest pain", 9);
        scheduler.addPatient("Cindy", "Fever", 5);

        Patient result = scheduler.treatNextPatient();

        if (result != null && result.getName().equals("Bob")) {
            System.out.println("PASS: Highest priority patient is treated first.");
        } else {
            System.out.println("FAIL: Highest priority patient was not treated first.");
        }
    }

    // Test 3: Edge Case - same priority, earlier arrival should be treated first
    public static void testTieByArrivalOrder() {
        EmergencyRoomScheduler scheduler = new EmergencyRoomScheduler();

        scheduler.addPatient("Alice", "Fever", 5);
        scheduler.addPatient("Emma", "Headache", 5);

        Patient result = scheduler.treatNextPatient();

        if (result != null && result.getName().equals("Alice")) {
            System.out.println("PASS: Tie priority uses arrival order correctly.");
        } else {
            System.out.println("FAIL: Tie priority did not use arrival order correctly.");
        }
    }

    // Test 4: Edge Case - invalid priority should not be added
    public static void testInvalidPriority() {
        EmergencyRoomScheduler scheduler = new EmergencyRoomScheduler();

        scheduler.addPatient("InvalidPatient1", "Unknown", 0);
        scheduler.addPatient("InvalidPatient2", "Unknown", 11);
        scheduler.addPatient("ValidPatient", "Broken arm", 7);

        if (scheduler.size() == 1) {
            System.out.println("PASS: Invalid priority levels were not added.");
        } else {
            System.out.println("FAIL: Invalid priority levels should not be added.");
        }
    }

    // Test 5: peekNextPatient should return the highest priority patient but not remove it
    public static void testPeekDoesNotRemove() {
        EmergencyRoomScheduler scheduler = new EmergencyRoomScheduler();

        scheduler.addPatient("Alice", "Mild cough", 2);
        scheduler.addPatient("Bob", "Chest pain", 9);

        Patient peekedPatient = scheduler.peekNextPatient();

        if (peekedPatient != null &&
                peekedPatient.getName().equals("Bob") &&
                scheduler.size() == 2) {
            System.out.println("PASS: peekNextPatient returns highest priority patient without removing.");
        } else {
            System.out.println("FAIL: peekNextPatient did not work correctly.");
        }
    }
}
