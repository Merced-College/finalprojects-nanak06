import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// World class manages the full NPC simulation
public class World {

    // HashMap stores NPCs using ID as the key for fast searching
    private HashMap<Integer, NPC> npcMap;

    // LinkedList stores the history of actions taken by NPCs
    private LinkedList<String> actionHistory;

    // Queue controls the order NPCs take turns in the simulation
    private Queue<NPC> actionQueue;

    // Array stores the available actions NPCs can choose from
    private Action[] actions;

    // DecisionEngine chooses the best action for each NPC
    private DecisionEngine decisionEngine;

    // Constructor sets up the world and available actions
    public World() {
        npcMap = new HashMap<Integer, NPC>();
        actionHistory = new LinkedList<String>();
        actionQueue = new LinkedList<NPC>();
        decisionEngine = new DecisionEngine();

        actions = new Action[3];
        actions[0] = new Action("Eat", -30, -5, 10);
        actions[1] = new Action("Sleep", 10, 40, 5);
        actions[2] = new Action("Explore", 15, -20, 20);
    }

    // Adds an NPC to the HashMap and Queue
    public void addNPC(NPC npc) {
        npcMap.put(npc.getId(), npc);
        actionQueue.add(npc);
    }

    // Searches for an NPC by ID using the HashMap
    public NPC findNPC(int id) {
        return npcMap.get(id);
    }

    // Displays all NPCs currently in the simulation
    public void showAllNPCs() {
        if (npcMap.isEmpty()) {
            System.out.println("No NPCs have been added yet.");
            return;
        }

        for (NPC npc : npcMap.values()) {
            System.out.println(npc);
        }
    }

    // Runs one step of the simulation
    public void runSimulationStep() {
        if (actionQueue.isEmpty()) {
            System.out.println("No NPCs available to simulate.");
            return;
        }

        // Remove the next NPC from the front of the queue
        NPC npc = actionQueue.remove();

        // Choose the best action using the decision algorithm
        Action chosenAction = decisionEngine.chooseBestAction(npc, actions);

        // Apply the action effects to the NPC stats
        chosenAction.applyTo(npc);

        // Store the result in the action history LinkedList
        String result = npc.getName() + " chose to " + chosenAction.getName();
        actionHistory.add(result);

        System.out.println(result);
        System.out.println(npc);

        // Add NPC back to the queue so they can take another turn later
        actionQueue.add(npc);
    }

    // Displays all actions that have happened so far
    public void showActionHistory() {
        if (actionHistory.isEmpty()) {
            System.out.println("No actions have happened yet.");
            return;
        }

        for (String action : actionHistory) {
            System.out.println(action);
        }
    }

    // Calculates and displays average mood using recursion
    public void showAverageMood() {
        if (npcMap.isEmpty()) {
            System.out.println("No NPCs available.");
            return;
        }

        NPC[] npcArray = npcMap.values().toArray(new NPC[0]);
        int totalMood = decisionEngine.recursiveMoodTotal(npcArray, 0);
        double average = (double) totalMood / npcArray.length;

        System.out.println("Average NPC mood: " + average);
    }
}