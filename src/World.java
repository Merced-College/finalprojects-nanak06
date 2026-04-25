import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class World {
    private HashMap<Integer, NPC> npcMap;
    private LinkedList<String> actionHistory;
    private Queue<NPC> actionQueue;
    private Action[] actions;
    private DecisionEngine decisionEngine;

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

    public void addNPC(NPC npc) {
        npcMap.put(npc.getId(), npc);
        actionQueue.add(npc);
    }

    public NPC findNPC(int id) {
        return npcMap.get(id);
    }

    public void showAllNPCs() {
        if (npcMap.isEmpty()) {
            System.out.println("No NPCs have been added yet.");
            return;
        }

        for (NPC npc : npcMap.values()) {
            System.out.println(npc);
        }
    }

    public void runSimulationStep() {
        if (actionQueue.isEmpty()) {
            System.out.println("No NPCs available to simulate.");
            return;
        }

        NPC npc = actionQueue.remove();
        Action chosenAction = decisionEngine.chooseBestAction(npc, actions);

        chosenAction.applyTo(npc);

        String result = npc.getName() + " chose to " + chosenAction.getName();
        actionHistory.add(result);

        System.out.println(result);
        System.out.println(npc);

        actionQueue.add(npc);
    }

    public void showActionHistory() {
        if (actionHistory.isEmpty()) {
            System.out.println("No actions have happened yet.");
            return;
        }

        for (String action : actionHistory) {
            System.out.println(action);
        }
    }

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