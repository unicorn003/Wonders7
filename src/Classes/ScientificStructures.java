package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class ScientificStructures extends Effect { //special class which inherit effect class for green cards
    public ScientificStructures() {
        super("ScientificStructures", "Scientific Structures", 1);
    }
    public int ReturnGreenPoints(ArrayList<ageCard> cards){
        //int result = 0;
        int Compass = 0; // count number of each type of green cards
        int Wheel = 0;
        int Stone = 0;
        for (ageCard card : cards){
            if (card.getCategory().equals("GreenCompass"))
                Compass++;
            if (card.getCategory().equals("GreenWheel"))
                Wheel++;
            if (card.getCategory().equals("GreenStone"))
                Stone++;
        }
        int[] greens = {Compass, Wheel, Stone};
        return  (greens[0] * 7 + greens[0]*greens[0] + greens[1]*greens[1] + greens[2]*greens[2]); // count green card points with special formula
        //return result;
    }
    public int TestCounter(ArrayList<ageCard> cards){ // tested counter system, because previous method didn't work well
        int compass = 0;
        int wheel = 0;
        int stone = 0;
        for (ageCard card : cards){
            if (card.getCategory() == "GreenCompass")
                compass++;
            if (card.getCategory() == "GreenWheel")
                wheel++;
            if (card.getCategory() == "GreenStone")
                stone++;
        }
        return compass + wheel + stone;
    }

}
