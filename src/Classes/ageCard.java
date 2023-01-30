package Classes;

import java.util.List;

public class ageCard { //main game card, we use it as a model
    private int age; //in general, we have 3 stage, so 3 age
    private String name;
    private String description;
    private String category; // color of card
    private int minimumPlayers; // number of minimum players
    private boolean direction; //direction can be right or left, so we can use true or false
    protected List<Resource> requiredResources; // list of resources which we need to build this card
    protected Effect effects; //how many winning point we can get from this card

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
