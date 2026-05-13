public class Patient {
    private String name;
    private String symptom;
    private int priorityLevel;
    private int arrivalOrder;

    public Patient(String name, String symptom, int priorityLevel, int arrivalOrder) {
        this.name = name;
        this.symptom = symptom;
        this.priorityLevel = priorityLevel;
        this.arrivalOrder = arrivalOrder;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return symptom;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    @Override
    public String toString() {
        return "Patient Name: " + name +
                ", Symptom: " + symptom +
                ", Priority Level: " + priorityLevel +
                ", Arrival Order: " + arrivalOrder;
    }
}
