package Classes;

import java.util.ArrayList;

public class CommercialStructures extends Effect{ //implementation of effect class for commercial structures
    public CommercialStructures(int w, String c) {
        super("CommercialStructures", "Commercial Structures", w);
        this.category = c;
    }
    private String category; //add category characteristics
    public int CountCategoryPoints(ArrayList<ageCard> cards){
        int k = 0;
        for (ageCard card : cards){ //count the number of cards of given category
            if(card.getCategory().equals(category) )
                k++;
        }
        return this.getWinningPoints() * k; //multiple number of cards by number of points per card
    }
}
