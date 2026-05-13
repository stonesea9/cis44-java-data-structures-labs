public class Main {
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
