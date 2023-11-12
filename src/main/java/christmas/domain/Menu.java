package christmas.domain;

public class Menu {
    private String name;
    private String type;
    private int price;

    public Menu(String name, String type, int price){
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public boolean equals(Object o){
        String name = (String) o;

        return name.equals(this.name);
    }
}
