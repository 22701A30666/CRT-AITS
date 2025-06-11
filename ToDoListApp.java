import java.util.*;

public class ToDoListApp {
    private static List<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addTask();
                case "2" -> displayTasks();
                case "3" -> removeTask();
                case "4" -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addTask() {
        System.out.print("Enter new task: ");
        String task = scanner.nextLine().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            System.out.println("Task added.");
        } else {
            System.out.println("Task cannot be empty.");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }

        System.out.print("Enter task number or exact name to remove: ");
        String input = scanner.nextLine().trim();

        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < tasks.size()) {
                System.out.println("Removed: " + tasks.remove(index));
            } else {
                System.out.println("Invalid index.");
            }
        } catch (NumberFormatException e) {
            if (tasks.remove(input)) {
                System.out.println("Removed: " + input);
            } else {
                System.out.println("Task not found.");
            }
        }
    }
}
