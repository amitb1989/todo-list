import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + description;
    }
}

public class taskdetail {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List:");
            displayTasks();
            System.out.println("Options: 1-Add, 2-Mark Complete, 3-Delete, 4-Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskCompleted();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
    }

    private static void markTaskCompleted() {
        System.out.print("Enter task number to mark as completed: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).markCompleted();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= tasks.size()) {
            tasks.remove(index - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
