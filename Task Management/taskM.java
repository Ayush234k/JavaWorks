import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class taskM {

    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = getChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting Task Manager...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nTask Manager Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Edit Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
    }

    private static int getChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void addTask() {
        scanner.nextLine(); 

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("\nTasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void editTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number to edit: ");
            int taskNumber = scanner.nextInt() - 1;
            scanner.nextLine(); 

            if (taskNumber >= 0 && taskNumber < tasks.size()) {
                Task taskToEdit = tasks.get(taskNumber);

                System.out.print("Enter new description (leave blank to keep current): ");
                String newDescription = scanner.nextLine();
                if (!newDescription.isEmpty()) {
                    taskToEdit.setDescription(newDescription);
                }

                System.out.println("Task updated successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number to delete: ");
            int taskNumber = scanner.nextInt() - 1;

            if (taskNumber >= 0 && taskNumber < tasks.size()) {
                tasks.remove(taskNumber);
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}

class Task {
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description; 
    }
}