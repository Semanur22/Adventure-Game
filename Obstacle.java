import java.util.Random;

public class Obstacle {
    private String name;
    private int damage, health, award,maxNumber;


public Obstacle(String name, int damage,int healt,int award, int maxNumber){
    this.name=name;
    this.damage=damage;
    this.health=healt;
    this.award=award;
    this.maxNumber=maxNumber;
}
public int obstacleCount(){
    Random rnd= new Random();

    return rnd.nextInt(this.maxNumber)+1;
}
public String getName(){
    return name;
}
public void setName(String name){
    this.name=name;
}
public int getDamage(){
    return damage;
}
public void setDamage(int damage){
    this.damage=damage;
}
public int getHealth(){
    return health;
}
public void setHealth(int healt){
    this.health=healt;
}
public int getAward(){
    return award;
}
public void setAward(int award){
    this.award=award;
}
public int getMaxNumber(){
    return maxNumber;
}
public void setMaxNumber(int maxNumber){
    this.maxNumber=maxNumber;
}
}