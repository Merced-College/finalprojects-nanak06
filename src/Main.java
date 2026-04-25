import java.util.Scanner;

// Main class runs the program and handles the user menu
public class Main {
    public static void main(String[] args) {

        // Scanner reads user input from the terminal
        Scanner input = new Scanner(System.in);

        // World object manages NPCs, actions, and simulation steps
        World world = new World();

        boolean running = true;

        // Main program loop
        while (running) {
            System.out.println("\n=== Dynamic NPC Decision Simulator ===");
            System.out.println("1. Add NPC");
            System.out.println("2. Show all NPCs");
            System.out.println("3. Search NPC by ID");
            System.out.println("4. Run simulation step");
            System.out.println("5. Show action history");
            System.out.println("6. Show average mood");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter NPC ID: ");
                int id = input.nextInt();
                input.nextLine();

                System.out.print("Enter NPC name: ");
                String name = input.nextLine();

                System.out.print("Enter hunger (0-100): ");
                int hunger = input.nextInt();

                System.out.print("Enter energy (0-100): ");
                int energy = input.nextInt();

                System.out.print("Enter mood (0-100): ");
                int mood = input.nextInt();

                // Create a new NPC object and add it to the world
                NPC npc = new NPC(id, name, hunger, energy, mood);
                world.addNPC(npc);

                System.out.println("NPC added successfully.");

            } else if (choice == 2) {
                // Displays all NPCs stored in the simulation
                world.showAllNPCs();

            } else if (choice == 3) {
                // Searches for one NPC using its ID
                System.out.print("Enter NPC ID to search: ");
                int id = input.nextInt();

                NPC npc = world.findNPC(id);

                if (npc == null) {
                    System.out.println("NPC not found.");
                } else {
                    System.out.println(npc);
                }

            } else if (choice == 4) {
                // Runs one turn of the simulation
                world.runSimulationStep();

            } else if (choice == 5) {
                // Shows the list of previous actions
                world.showActionHistory();

            } else if (choice == 6) {
                // Shows average mood using recursive calculation
                world.showAverageMood();

            } else if (choice == 7) {
                running = false;
                System.out.println("Program ended.");

            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}