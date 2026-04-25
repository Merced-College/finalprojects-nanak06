// DecisionEngine handles how NPCs choose actions
public class DecisionEngine {

    // Chooses the best action based on calculated scores
    public Action chooseBestAction(NPC npc, Action[] actions) {

        // Start by assuming the first action is the best
        Action bestAction = actions[0];
        int bestScore = calculateScore(npc, bestAction);

        // Loop through all actions to find the highest score
        for (int i = 1; i < actions.length; i++) {
            int currentScore = calculateScore(npc, actions[i]);

            // If a better score is found, update best action
            if (currentScore > bestScore) {
                bestScore = currentScore;
                bestAction = actions[i];
            }
        }

        // Return the action with the highest score
        return bestAction;
    }

    // Calculates a score for each possible action
    public int calculateScore(NPC npc, Action action) {

        // If action is Eat, prioritize high hunger
        if (action.getName().equals("Eat")) {
            return npc.getHunger() * 2;
        }

        // If action is Sleep, prioritize low energy
        if (action.getName().equals("Sleep")) {
            return (100 - npc.getEnergy()) * 2;
        }

        // If action is Explore, balance mood and energy
        if (action.getName().equals("Explore")) {
            return npc.getEnergy() + npc.getMood() - npc.getHunger();
        }

        // Default score if no match
        return 0;
    }

    // Recursive method to calculate total mood of all NPCs
    public int recursiveMoodTotal(NPC[] npcs, int index) {

        // Base case: stop when index reaches end
        if (index >= npcs.length) {
            return 0;
        }

        // Add current NPC mood + recursive call
        return npcs[index].getMood() + recursiveMoodTotal(npcs, index + 1);
    }
}