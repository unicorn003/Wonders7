package Classes;

import java.util.ArrayList;

public class CommercialStructures extends Effect{
    public CommercialStructures(int w, String c) {
        super("CommercialStructures", "Commercial Structures", w);
        this.category = c;
    }
    private String category;
    public int CountCategoryPoints(ArrayList<ageCard> cards){
        int k = 0;
        for (ageCard card : cards){
            if(card.getCategory().equals(category) )
                k++;
        }
        return this.getWinningPoints() * k;
    }
}
