public class Inventory {
    private boolean water,food,firewood;
    private String wName,aName;
    private int damage,armor;

    Inventory(){
        this.water=false;
        this.food=false;
        this.firewood=false;
        this.damage=0;
        this.armor=0;
        this.aName=null;
        this.wName=null;
    }
    public boolean getWater(){
        return water;
    }
    public void setWater(Boolean water){
        this.water=water;
    }
    public boolean getFood(){
        return food;
    }
    public void setFood(Boolean food){
        this.food=food;
    }
    public boolean getFirewood(){
        return firewood;
    }
    public void setFirewood(Boolean firewood){
        this.firewood=firewood;
    }
    public String getWName(){
        return wName;
    }
    public void setWName(String wName){
        this.wName=wName;
    }
    public String getAName(){
        return aName;
    }
    public void setAName(String aName){
        this.aName=aName;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public int getArmor(){
        return armor;
    }
    public void setArmor(int armor){
        this.armor=armor;
    }

}
