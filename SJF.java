import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Process {
    String id;
    int arrivalTime;
    int burstTime;
    int startTime = 0;
    int completeTime = 0;
    int waitingTime = 0;

    Process(String id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class SJF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Process> processes = new ArrayList<>();

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter arrival time for process P" + i + ": ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Enter burst time for process P" + i + ": ");
            int burstTime = scanner.nextInt();
            processes.add(new Process("P" + i, arrivalTime, burstTime));
        }

        int currentTime = 0;
        int totalWaitingTime = 0;
        List<Process> completedProcesses = new ArrayList<>();

        while (!processes.isEmpty()) {
            List<Process> availableProcesses = new ArrayList<>();
            for (Process p : processes) {
                if (p.arrivalTime <= currentTime) {
                    availableProcesses.add(p);
                }
            }

            if (availableProcesses.isEmpty()) {
                currentTime++;
                continue;
            }

            Process currentProcess = Collections.min(availableProcesses, Comparator.comparingInt(p -> p.burstTime));
            currentProcess.startTime = currentTime;
            currentProcess.completeTime = currentTime + currentProcess.burstTime;
            currentProcess.waitingTime = currentProcess.startTime - currentProcess.arrivalTime;
            totalWaitingTime += currentProcess.waitingTime;

            currentTime = currentProcess.completeTime;
            completedProcesses.add(currentProcess);
            processes.remove(currentProcess);
        }

        printTable(completedProcesses, totalWaitingTime);
    }

    private static void printTable(List<Process> processes, int totalWaitingTime) {
        System.out.println("\nShort Job First (SJF)\n");
        System.out.println("Time\tProcess\tBurst\tArrival\tStart\tComplete\tWaiting");
        for (Process p : processes) {
            System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t\t%d\n", p.completeTime, p.id, p.burstTime, p.arrivalTime, p.startTime, p.completeTime, p.waitingTime);
        }
        System.out.printf("\nAverage waiting time = %.1f\n", (double) totalWaitingTime / processes.size());
    }
}
