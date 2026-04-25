public class Action {
    private String name;
    private int hungerChange;
    private int energyChange;
    private int moodChange;

    public Action(String name, int hungerChange, int energyChange, int moodChange) {
        this.name = name;
        this.hungerChange = hungerChange;
        this.energyChange = energyChange;
        this.moodChange = moodChange;
    }

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

    public void applyTo(NPC npc) {
        npc.changeStats(hungerChange, energyChange, moodChange);
    }
}