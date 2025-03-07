import java.util.ArrayList;
import java.util.Scanner;

class FCFS {

    // Methods

    // To Calculate Completion Time
    public ArrayList<Integer> completionTime(int[][] process) {
        ArrayList<Integer> completeTime = new ArrayList<Integer>();
        try {

            int processNum = process.length;
            for (int i = 0; i < processNum; i++) {
                if (i == 0 || process[i][0] >= completeTime.get(i - 1)) {
                    completeTime.add(process[i][1] + process[i][0]);
                } else {
                    completeTime.add(completeTime.get(i - 1) + process[i][1]);
                }
            }
            return completeTime;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // To calculate Turn Around Time
    public ArrayList<Integer> turnAroundTime(int[][] process) {

        ArrayList<Integer> completionTime = completionTime(process);

        ArrayList<Integer> turnAroundTimeList = new ArrayList<Integer>();
        int processNum = process.length;

        for (int i = 0; i < processNum; i++) {
            turnAroundTimeList.add(completionTime.get(i) - process[i][0]);
        }

        return turnAroundTimeList;
    }

    // To calculate waiting time
    public ArrayList<Integer> waitTime(int[][] process) {

        ArrayList<Integer> turnAroundTimeLiist = turnAroundTime(process);
        ArrayList<Integer> waitingList = new ArrayList<Integer>();
        int processNum = process.length;

        for (int i = 0; i < processNum; i++) {
            waitingList.add(turnAroundTimeLiist.get(i) - process[i][1]);
        }

        return waitingList;
    }

    // To calculate Average Waiting Time
    public float averageWaitingTime(int[][] process) {
        ArrayList<Integer> waitingList = waitTime(process);
        int waitigSum = 0;
        int processNumber = waitingList.size();

        for (int i = 0; i < processNumber; i++) {
            waitigSum += waitingList.get(i);
        }

        return waitigSum / processNumber;
    }

    // To calculate average waiting time
    public int maxWaitingTime(int[][] process) {
        ArrayList<Integer> waitingList = waitTime(process);
        int max = waitingList.get(0);

        for (int i = 1; i < waitingList.size(); i++) {
            if (waitingList.get(i) > max) {
                max = waitingList.get(i);
            }
        }

        return max;
    }
}

public class FirstComeFirstServe {
    public void printArray(int[][] arr) {
        for (int index1 = 0; index1 < arr.length; index1++) {
            for (int index2 = 0; index2 < arr[index1].length; index2++) {
                System.out.print(arr[index1][index2] + ", ");
            }
            System.out.println();
        }
    }

    public void printArray(ArrayList<Integer> arr) {
        for (int index = 0; index < arr.size(); index++) {
            System.out.print(arr.get(index) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FirstComeFirstServe fs = new FirstComeFirstServe();
        FCFS fcfs = new FCFS(); // creating an object and calling constructor of FCFS
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes:- ");
        int processNumber = sc.nextInt();

        int[][] process = new int[processNumber][2];

        for (int index = 0; index < processNumber; index++) {
            System.out.println("Enter Arrival Time for P" + (index + 1) + ":- ");
            int arrivalTime = sc.nextInt();
            System.out.println("Enter Burst Time for P" + (index + 1) + ":- ");
            int burstTime = sc.nextInt();

            process[index][0] = arrivalTime;
            process[index][1] = burstTime;
        }

        while (true) {
            System.out.println("What would you like to perform?");
            System.out.println("Choose the option accordingly...");
            System.out.println(
                    "To check completion time press 1...\nTo check Turn Around Time Press 2...\nTo check waiting Time press 3...");
            System.out.println(
                    "To check average waiting time press 4...\n To check maximum wiating time press 5...\nTo exit Press 6...");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ArrayList<Integer> completionTime = fcfs.completionTime(process); // Calling completionTime Method
                    System.out.println("Completion time for processes are...");
                    fs.printArray(completionTime);
                    break;
                case 2:
                    ArrayList<Integer> turnAroundTime = fcfs.turnAroundTime(process); // Calling turnAroundTime Method
                    System.out.println("Turn Around time for processes are...");
                    fs.printArray(turnAroundTime);
                    break;
                case 3:
                    ArrayList<Integer> waitingTime = fcfs.waitTime(process); // Calling waitTime Method
                    System.out.println("Waiting time for processes are...");
                    fs.printArray(waitingTime);
                    break;
                case 4:
                    System.out.println("Average Waiting Time is..." + fcfs.averageWaitingTime(process)); // Calling and
                                                                                                         // printing
                                                                                                         // averageWaitingTime
                    break;
                case 5:
                    System.out.println("Maximum Waiting Time is..." + fcfs.maxWaitingTime(process)); // Calling and
                                                                                                     // printing
                                                                                                     // maxWaitingTime
                    break;
                default:
                    break;
            }
            if (choice == 6) {
                break;
            }
        }
        sc.close();
    }
}
