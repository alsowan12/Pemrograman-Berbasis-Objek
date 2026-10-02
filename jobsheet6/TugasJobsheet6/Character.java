package jobsheet6.TugasJobsheet6;

public class Character {
    protected String nama;
    protected int level;
    protected int health;

    public Character(String nama, int level, int health){
        this.nama = nama;
        this.level = level;
        this.health = health;
    }
    public void attack(Character target){
        target.health -= 10;
    }
    public void showStatus(){
        System.out.println( nama + "Level" + level + "1 HP" + health);
        
    }

    
}
