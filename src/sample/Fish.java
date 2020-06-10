package sample;

public class Fish {
    private String[] fish= new String[] {"Karas","Rotan"};
    public String caughtFish(){
        int random_number = 0 + (int) (Math.random() * 2);
        return fish[random_number];
    }
}
