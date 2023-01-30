package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyStage { //represents stage model in game
    private int age; // we can have 3 stages
    private int victoryPoints; //how many victory points we can have from one stage if we will build it
    private List<Resource> resources; // list of resources which we need to build this card
    private boolean isBuild; // flag is our stage ois build or not

    public MyStage(int a, int v, List<Resource>  r){
        age = age;
        victoryPoints = v;
        resources = r;
        isBuild = false;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public boolean isBuild() {
        return isBuild;
    }

    public List<Resource> getResources() {
        return resources;
    }
    public boolean IsEnoughResources(List<Resource> availableResources){ // logic method is we need something more or not
        List<Resource> rest = this.resourcesNeed(availableResources);
        if (rest.isEmpty())
            return true;
        else return false;
    }
    public List<Resource> resourcesNeed(List<Resource> availableResources){ //we create a copy of array what we have and what we need. After we delete all common from list what we need. And after we will return result
        ArrayList<Resource> copyAvailable = new ArrayList<Resource>();
        ArrayList<Resource> copyResources = new ArrayList<Resource>();
        Collections.copy(availableResources, copyAvailable);
        Collections.copy(resources, copyResources);
        copyResources.removeAll(copyAvailable);
        return copyResources;
    }
    public void BuildStage(ArrayList<Resource> availableResources){ //method for build stage
        if (IsEnoughResources(availableResources))
            isBuild = true;
        else return;
    }
    public int getAge() {
        return age;
    }
}
