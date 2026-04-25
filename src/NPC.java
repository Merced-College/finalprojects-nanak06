// NPC class represents a single character in the simulation
public class NPC {

    // Unique identifier for each NPC
    private int id;

    // Name of the NPC
    private String name;

    // NPC stats (range 0–100)
    private int hunger;
    private int energy;
    private int mood;

    // Constructor initializes all NPC attributes
    public NPC(int id, String name, int hunger, int energy, int mood) {
        this.id = id;
        this.name = name;
        this.hunger = hunger;
        this.energy = energy;
        this.mood = mood;
    }

    // Getter methods to access private variables
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

    // Method to update NPC stats after an action
    public void changeStats(int hungerChange, int energyChange, int moodChange) {
        // Apply changes to each stat
        hunger = limitStat(hunger + hungerChange);
        energy = limitStat(energy + energyChange);
        mood = limitStat(mood + moodChange);
    }

    // Ensures stats stay within 0–100 range
    private int limitStat(int value) {
        if (value < 0) {
            return 0;
        }
        if (value > 100) {
            return 100;
        }
        return value;
    }

    // Returns a formatted string representation of the NPC
    public String toString() {
        return "ID: " + id + " | Name: " + name +
               " | Hunger: " + hunger +
               " | Energy: " + energy +
               " | Mood: " + mood;
    }
}