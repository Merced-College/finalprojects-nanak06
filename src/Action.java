// Action class represents something an NPC can do
public class Action {

    // Name of the action, such as Eat, Sleep, or Explore
    private String name;

    // These values change the NPC's stats when the action happens
    private int hungerChange;
    private int energyChange;
    private int moodChange;

    // Constructor initializes the action name and stat effects
    public Action(String name, int hungerChange, int energyChange, int moodChange) {
        this.name = name;
        this.hungerChange = hungerChange;
        this.energyChange = energyChange;
        this.moodChange = moodChange;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getHungerChange() {
        return hungerChange;
    }

    public int getEnergyChange() {
        return energyChange;
    }

    public int getMoodChange() {
        return moodChange;
    }

    // Applies this action's effects to an NPC
    public void applyTo(NPC npc) {
        npc.changeStats(hungerChange, energyChange, moodChange);
    }
}