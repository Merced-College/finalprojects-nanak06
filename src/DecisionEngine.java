public class DecisionEngine {

    public Action chooseBestAction(NPC npc, Action[] actions) {
        Action bestAction = actions[0];
        int bestScore = calculateScore(npc, bestAction);

        for (int i = 1; i < actions.length; i++) {
            int currentScore = calculateScore(npc, actions[i]);

            if (currentScore > bestScore) {
                bestScore = currentScore;
                bestAction = actions[i];
            }
        }

        return bestAction;
    }

    public int calculateScore(NPC npc, Action action) {
        if (action.getName().equals("Eat")) {
            return npc.getHunger() * 2;
        }

        if (action.getName().equals("Sleep")) {
            return (100 - npc.getEnergy()) * 2;
        }

        if (action.getName().equals("Explore")) {
            return npc.getEnergy() + npc.getMood() - npc.getHunger();
        }

        return 0;
    }

    public int recursiveMoodTotal(NPC[] npcs, int index) {
        if (index >= npcs.length) {
            return 0;
        }

        return npcs[index].getMood() + recursiveMoodTotal(npcs, index + 1);
    }
}