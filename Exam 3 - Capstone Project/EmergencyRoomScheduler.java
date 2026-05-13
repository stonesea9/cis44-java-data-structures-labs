import java.util.ArrayList;

public class EmergencyRoomScheduler {
    private ArrayList<Patient> heap;
    private int arrivalCounter;

    public EmergencyRoomScheduler() {
        heap = new ArrayList<>();
        arrivalCounter = 0;
    }

    public void addPatient(String name, String symptom, int priorityLevel) {
        if (priorityLevel < 1 || priorityLevel > 10) {
            System.out.println("Invalid priority level. Priority must be between 1 and 10.");
            return;
        }

        Patient patient = new Patient(name, symptom, priorityLevel, arrivalCounter);
        arrivalCounter++;

        heap.add(patient);
        bubbleUp(heap.size() - 1);
    }

    public Patient treatNextPatient() {
        if (isEmpty()) {
            return null;
        }

        Patient highestPriorityPatient = heap.get(0);

        Patient lastPatient = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastPatient);
            bubbleDown(0);
        }

        return highestPriorityPatient;
    }

    public Patient peekNextPatient() {
        if (isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (compare(heap.get(index), heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int index) {
        int size = heap.size();

        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int highestIndex = index;

            if (leftChildIndex < size &&
                    compare(heap.get(leftChildIndex), heap.get(highestIndex)) > 0) {
                highestIndex = leftChildIndex;
            }

            if (rightChildIndex < size &&
                    compare(heap.get(rightChildIndex), heap.get(highestIndex)) > 0) {
                highestIndex = rightChildIndex;
            }

            if (highestIndex != index) {
                swap(index, highestIndex);
                index = highestIndex;
            } else {
                break;
            }
        }
    }

    private int compare(Patient p1, Patient p2) {
        if (p1.getPriorityLevel() > p2.getPriorityLevel()) {
            return 1;
        } else if (p1.getPriorityLevel() < p2.getPriorityLevel()) {
            return -1;
        } else {
            // If priority levels are the same, the patient who arrived earlier has higher priority.
            if (p1.getArrivalOrder() < p2.getArrivalOrder()) {
                return 1;
            } else if (p1.getArrivalOrder() > p2.getArrivalOrder()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private void swap(int index1, int index2) {
        Patient temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
