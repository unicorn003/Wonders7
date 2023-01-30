package Classes;

public class Resource { // class which represents what we need or how we call it resources which we use as a model
    private String category;
    private String name;
    public Resource(String c, String n){
        category = c;
        name = n;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
