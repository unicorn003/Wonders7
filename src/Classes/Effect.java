package Classes;

public abstract class Effect { //this class help us with counting point. class abstract, so we need to inherit another from it
    private String name;
    private String description;
    private int winningPoints;

    public Effect(String n,String d, int w){ //constructor
        name = n;
        description = d;
        winningPoints = w;
    }

    public int getWinningPoints() { //return how many points we can get
        return winningPoints;
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
}
