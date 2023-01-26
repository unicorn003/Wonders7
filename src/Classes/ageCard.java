package Classes;

import java.util.List;

public class ageCard {
    private int age;
    private String name;
    private String description;
    private String category;
    private int minimumPlayers;
    private boolean direction;
    protected List<Resource> requiredResources;
    protected Effect effects;

    public ageCard(int a, String n, String d, String c, int mp, boolean dir, List<Resource> r,Effect ef){
        this.age = a;
        this.name = n;
        this.description = d;
        this.category = c;
        this.minimumPlayers = mp;
        this.direction = dir;
        this.requiredResources = r;
        this.effects = ef;
    }
    public int getAge() {
        return age;
    }

    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public boolean isDirection() {
        return direction;
    }

    public Effect getEffects() {
        return effects;
    }

    public List<Resource> getRequiredResources() {
        return requiredResources;
    }

    public String getDescription() {
        return description;
    }
}
