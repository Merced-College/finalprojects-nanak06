public class NPC {
    private int id;
    private String name;
    private int hunger;
    private int energy;
    private int mood;

    public NPC(int id, String name, int hunger, int energy, int mood) {
        this.id = id;
        this.name = name;
        this.hunger = hunger;
        this.energy = energy;
        this.mood = mood;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMood() {
        return mood;
    }

    public void changeStats(int hungerChange, int energyChange, int moodChange) {
        hunger = limitStat(hunger + hungerChange);
        energy = limitStat(energy + energyChange);
        mood = limitStat(mood + moodChange);
    }

    private int limitStat(int value) {
        if (value < 0) {
            return 0;
        }
        if (value > 100) {
            return 100;
        }
        return value;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Hunger: " + hunger +
               " | Energy: " + energy + " | Mood: " + mood;
    }
}