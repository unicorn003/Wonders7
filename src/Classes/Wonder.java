package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wonder { // main game class which represent an idea of 7 wonders
    private String name;
    private boolean isTaken; // is someone take this wonder or not
    private boolean side; // they are two sides of wonder
    private MyStage localStage; // local state of game
    private Resource startingResource; // resource which wonder has from  the start
    private List<Resource> availableResources = new ArrayList<>(); //resource which wonder has
    private MyStage stage1; // 1 stage of game
    private MyStage stage2; // 2 stage of game
    private MyStage stage3; // 3 stage of game
    public Wonder(String n, boolean s, Resource r, MyStage s1, MyStage s2, MyStage s3){
       this.availableResources.add(r);
        this.localStage = s1;
        this.name = n;
        this.isTaken = false;
        this.side = s;
        this.startingResource = r;
        this.stage1 = s1;
        this.stage2 = s2;
        this.stage3 = s3;
    }

    public void MakeTaken(){
        isTaken = true;
    } // make our wonder taken
    public void addMilitaryToken(militaryToken m){ // add our military token
        myMilitaryTokens.add(m);
    }
    public void addAgeCard(ageCard card){ // we can add age card to list if we have enough resources
        if (card.requiredResources.equals(null) || this.IsEnoughResources(card.requiredResources))
            myCards.add(card);
        else return;
    }
    public void addTreasure(Treasure t){
        myTreasures.add(t);
    } //add treasure coin
    ArrayList<ageCard> myCards = new ArrayList<ageCard>(); // all age cards of the wonder
    ArrayList<militaryToken> myMilitaryTokens = new ArrayList<militaryToken>(); // all military token
    ArrayList<Treasure> myTreasures = new ArrayList<Treasure>(); // all treasure coin

    public String getName() {
        return name;
    }

    public boolean isSide() {
        return side;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public MyStage getLocalStage() {
        return localStage;
    }
    public int countMilitaryForce(){ // here we count a number of red cards which we can use in war state
        int result  = 0;
        for (ageCard card : myCards){
            if (card.getCategory().equals("Red")){
                if(card.getName().equals("2 shields"))
                    result += 2;
                else
                    result++;
            }
        }
        return result;
    }
    public void fight(int rightPlayer, int leftPlayer){ // here we compare our military forces with another players. And in case of stage or situation we will add military token
        militaryToken point5 = new militaryToken(5);
        militaryToken point3 = new militaryToken(3);
        militaryToken point1 = new militaryToken(1);
        militaryToken pointMinus = new militaryToken(-1);
        int yourShields = this.countMilitaryForce();
        if(yourShields < rightPlayer)
            myMilitaryTokens.add(pointMinus);
        if (yourShields < leftPlayer)
            myMilitaryTokens.add(pointMinus);
        if (yourShields  > rightPlayer && localStage.getAge() == 1 )
            myMilitaryTokens.add(point1);
        if (yourShields  > leftPlayer &&localStage.getAge() == 1 )
            myMilitaryTokens.add(point1);
        if (yourShields  > rightPlayer && localStage.getAge() == 2 )
            myMilitaryTokens.add(point3);
        if (yourShields  > leftPlayer && localStage.getAge() == 2 )
            myMilitaryTokens.add(point3);
        if (yourShields  > rightPlayer && localStage.getAge() == 3 )
            myMilitaryTokens.add(point5);
        if (yourShields > leftPlayer && localStage.getAge() == 3 )
            myMilitaryTokens.add(point5);
    }
    public Resource getStartingResource() {
        return startingResource;
    }
    public List<Resource> getResourceLocalStage(){
         return  localStage.getResources();
    }
    public void nextStage(){ // here we can move to the next stage
        if (localStage.equals(stage1))
            localStage = stage2;
        else if (localStage.equals(stage2))
            localStage = stage2;
        else return;
    }
    public int countWinningPoint(){ // here we count all victory points of wonder what we have
        int result = 0;
        for (militaryToken mil : myMilitaryTokens) {
            result += (mil.getWinningPoints());
        }
        int treasAmount = 0;
        for (Treasure treas : myTreasures) {
            treasAmount += (treas.getWinningPoints());
        }
        result += treasAmount/3;
        if (stage1.isBuild())
            result += (stage1.getVictoryPoints());
        if (stage2.isBuild())
            result += (stage2.getVictoryPoints());
        if (stage3.isBuild())
            result += (stage3.getVictoryPoints());
        for (ageCard card : myCards){
            if (card.getEffects() instanceof CommercialStructures)
                result += (((CommercialStructures) card.getEffects()).CountCategoryPoints(myCards));
            else if(card.getEffects() instanceof ScientificStructures)
                result += (((ScientificStructures) card.getEffects()).ReturnGreenPoints(myCards));
            else if(card.getEffects() instanceof CivilianStructures)
                result += (card.getEffects().getWinningPoints());
            else result += 0 ;
        }
        return result;
    }
    public boolean IsEnoughResources(List<Resource> resourcesWeNeed){ // logic method is we need something more or not
        List<Resource> rest = this.resourcesNeed(resourcesWeNeed);
        if (rest.isEmpty())
            return true;
        else return false;
    }
    public List<Resource> resourcesNeed(List<Resource> resourcesWeNeed){ //we create a copy of array what we have and what we need. After we delete all common from list what we need. And after we will return result
        ArrayList<Resource> copyAvailable = new ArrayList<Resource>();
        Collections.copy(availableResources, copyAvailable);
        resourcesWeNeed.removeAll(copyAvailable);
        return resourcesWeNeed;
    }
}
