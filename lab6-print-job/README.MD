
Operating systems often manage shared resources like printers using a queue. When multiple users send documents to a printer, the jobs are processed in the order they were received. This lab simulates a simple print queue using the FIFO principle.

Objective
You will complete two classes: PrintJob and Printer. The Printer class will use a Queue to manage a list of PrintJob objects. You will implement methods to add a job to the queue and to process the next job in the queue.

Requirements
Complete the PrintJob class to store a document name and the number of pages.
In the Printer class, you must use a Queue to store the print jobs. A LinkedQueue is recommended as the number of jobs is unknown.
Implement the addJob(PrintJob job) method to enqueue a new print job.
Implement the processNextJob() method to dequeue the job at the front of the queue and simulate "printing" it by displaying a message.
Code Template
Copy the code below into your Java IDE. You will need to complete both the PrintJob and Printer classes. You will also need a working implementation of a Queue (e.g., LinkedQueue). Submit your completed Printer.java file (which should contain both classes) as your answer.


// You will need a functioning Queue implementation (like LinkedQueue) for this to work.
// interface Queue { ... }
// class LinkedQueue implements Queue { ... }

/**
 * Represents a single document to be printed.
 */
class PrintJob {
    private String documentName;
    private int pageCount;

    // TODO: Implement the constructor
    public PrintJob(String documentName, int pageCount) {
        // Your code here
    }

    // TODO: Implement the toString method to return a descriptive string
    // e.g., "PrintJob[Document: report.docx, Pages: 15]"
    @Override
    public String toString() {
        return ""; // Placeholder
    }
}

/**
 * Simulates a printer that manages a queue of print jobs.
 */
public class Printer {
    private Queue jobQueue;

    public Printer() {
        // TODO: Initialize the jobQueue with a LinkedQueue
        jobQueue = null; // Placeholder
    }

    /**
     * Adds a new print job to the rear of the queue.
     * @param job The print job to add.
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        // TODO: Enqueue the job
    }

    /**
     * Processes the job at the front of the queue.
     */
    public void processNextJob() {
        // TODO: Check if the queue is empty. If so, print a message.
        // If not empty, dequeue the job and print a "Processing..." message.
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}
              
Deliverables:
