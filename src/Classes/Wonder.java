package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wonder {
    private String name;
    private boolean isTaken;
    private boolean side;
    private MyStage localStage;
    private Resource startingResource;
    private List<Resource> availableResources = new ArrayList<>();
    private MyStage stage1;
    private MyStage stage2;
    private MyStage stage3;
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
    }
    public void addMilitaryToken(militaryToken m){
        myMilitaryTokens.add(m);
    }
    public void addAgeCard(ageCard card){
        if (this.IsEnoughResources(card.requiredResources))
            myCards.add(card);
        else return;
    }
    public void addTreasure(Treasure t){
        myTreasures.add(t);
    }
    ArrayList<ageCard> myCards = new ArrayList<ageCard>();
    ArrayList<militaryToken> myMilitaryTokens = new ArrayList<militaryToken>();
    ArrayList<Treasure> myTreasures = new ArrayList<Treasure>();

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
    public int countMilitaryForce(){
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
    public void fight(int rightPlayer, int leftPlayer){
        militaryToken point5 = new militaryToken(5);
        militaryToken point3 = new militaryToken(3);
        militaryToken point1 = new militaryToken(1);
        militaryToken pointMinus = new militaryToken(-1);
        int yourShields = countMilitaryForce();
        if(yourShields < rightPlayer)
            myMilitaryTokens.add(pointMinus);
        if (yourShields < leftPlayer)
            myMilitaryTokens.add(pointMinus);
        if (rightPlayer > rightPlayer && localStage.getAge() == 1 )
            myMilitaryTokens.add(point1);
        if (rightPlayer > leftPlayer && localStage.getAge() == 1 )
            myMilitaryTokens.add(point1);
        if (rightPlayer > rightPlayer && localStage.getAge() == 2 )
            myMilitaryTokens.add(point3);
        if (rightPlayer > leftPlayer && localStage.getAge() == 2 )
            myMilitaryTokens.add(point3);
        if (rightPlayer > rightPlayer && localStage.getAge() == 3 )
            myMilitaryTokens.add(point5);
        if (rightPlayer > leftPlayer && localStage.getAge() == 3 )
            myMilitaryTokens.add(point5);
    }
    public Resource getStartingResource() {
        return startingResource;
    }
    public List<Resource> getResourceLocalStage(){
         return  localStage.getResources();
    }
    public void nextStage(){
        if (localStage.equals(stage1))
            localStage = stage2;
        else if (localStage.equals(stage2))
            localStage = stage2;
        else return;
    }
    public int countWinningPoint(){
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
            else result += (card.getEffects().getWinningPoints()) ;
        }
        return result;
    }
    public boolean IsEnoughResources(List<Resource> resourcesWeNeed){
        List<Resource> rest = this.resourcesNeed(resourcesWeNeed);
        if (rest.isEmpty())
            return true;
        else return false;
    }
    public List<Resource> resourcesNeed(List<Resource> resourcesWeNeed){
        ArrayList<Resource> copyAvailable = new ArrayList<Resource>();
        Collections.copy(availableResources, copyAvailable);
        resourcesWeNeed.removeAll(copyAvailable);
        return resourcesWeNeed;
    }
}
