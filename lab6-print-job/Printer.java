import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a single document to be printed.
 */
class PrintJob {
    private String documentName;
    private int pageCount;

    // Constructor
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // Return description of the print job
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}

/**
 * Simulates a printer that manages a queue of print jobs.
 */
public class Printer {

    private Queue<PrintJob> jobQueue;

    public Printer() {
        // Initialize the queue
        jobQueue = new LinkedList<>();
    }

    /**
     * Adds a new print job to the queue.
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        jobQueue.add(job); // enqueue
    }

    /**
     * Processes the job at the front of the queue.
     */
    public void processNextJob() {

        if (jobQueue.isEmpty()) {
            System.out.println("No jobs in the print queue.");
            return;
        }

        PrintJob nextJob = jobQueue.remove(); // dequeue

        System.out.println("Processing print job: " + nextJob);
    }

    public static void main(String[] args) {

        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");

        officePrinter.processNextJob();
        officePrinter.processNextJob();

        System.out.println("\nNew high-priority job arrives...");

        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob();
        officePrinter.processNextJob();
        officePrinter.processNextJob();
    }
}
