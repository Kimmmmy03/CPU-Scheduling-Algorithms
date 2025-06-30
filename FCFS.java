import java.util.Scanner;

public class FCFS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of processes from the user
        System.out.println("Enter the number of processes:");
        int n = scanner.nextInt();

        // Arrays to store process details
        int[] pid = new int[n]; // Process IDs
        int[] arrivalTime = new int[n]; // Arrival times
        int[] burstTime = new int[n]; // Burst times
        int[] completionTime = new int[n]; // Completion times
        int[] waitingTime = new int[n]; // Waiting times
        int[] startTime = new int[n]; // Start times

        // Input arrival time and burst time for each process
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1; // Assign process ID
            System.out.println("Enter arrival time for process " + pid[i] + ":");
            arrivalTime[i] = scanner.nextInt();
            System.out.println("Enter burst time for process " + pid[i] + ":");
            burstTime[i] = scanner.nextInt();
        }

        // Perform FCFS scheduling
        fcfsScheduling(n, arrivalTime, burstTime, completionTime, waitingTime, startTime);
        // Print the process details
        printProcessDetails(n, pid, arrivalTime, burstTime, completionTime, waitingTime, startTime);
    }

    // Function to perform FCFS scheduling
    public static void fcfsScheduling(int n, int[] arrivalTime, int[] burstTime, int[] completionTime, int[] waitingTime, int[] startTime) {
        int currentTime = 0; // Keeps track of the current time

        // Calculate completion, start, and waiting times for each process
        for (int i = 0; i < n; i++) {
            // Ensure the current time is at least the arrival time of the process
            if (currentTime < arrivalTime[i]) {
                currentTime = arrivalTime[i];
            }
            // Calculate start time
            startTime[i] = currentTime;
            // Calculate completion time
            completionTime[i] = currentTime + burstTime[i];
            // Calculate waiting time
            waitingTime[i] = startTime[i] - arrivalTime[i];
            // Update current time to the completion time of the current process
            currentTime = completionTime[i];
        }
    }

    // Function to print process details and average times
    public static void printProcessDetails(int n, int[] pid, int[] arrivalTime, int[] burstTime, int[] completionTime, int[] waitingTime, int[] startTime) {
        System.out.println("\nFirst Come First Serve (FCFS)\n");
        System.out.println("Process\t\tArrival\t\tBurst\t\tStart\t\tComplete\tWaiting");
        
        double totalWaitingTime = 0; // Total waiting time for calculating average

        // Print details of each process
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" + startTime[i] + "\t\t" + completionTime[i] + "\t\t" + waitingTime[i]);
            totalWaitingTime += waitingTime[i]; // Accumulate total waiting time
        }

        // Print average waiting time and the divisor
        System.out.printf("\nTotal Waiting Time: %.2f\n", totalWaitingTime);
        System.out.println("Number of Processes: " + n);
        System.out.printf("Average Waiting Time: %.2f\n", (totalWaitingTime / n));
    }
}
