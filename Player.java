import java.util.Scanner;

public class Player {
    private int damage,healthy, money,reHeal;
    private String name, cname;
    private Inventory inv;
    Scanner input=new Scanner(System.in);

    public void selectCha(){
        switch(charMenu()){
            case 1: //Samuray
            Init("Samuray", 5, 21, 15);
            break;
            case 2: //Okcu
            Init("Okcu", 7, 18, 20);
            break;
            case 3: //Sovalye
            Init("Sovalye", 8, 24, 5);
            break;
            default: 
            Init("Samuray", 5, 21, 15);
            break;
        }
        System.out.println("Karakteriniz: "+getCName()+"  Hasar: "+getDamage()+ "  Saglik: "+gethealthy()+"  Para: "+getMoney());
    }
    public void Init(String cName,int dmg,int hlthy,int mny){
        setCName(cName);
        setDamage(dmg);
        setHealthy(hlthy);
        setMoney(mny);
        setReHeal(hlthy);
    }
    public int charMenu(){
        System.out.println("Karakterler: ");
        System.out.println("1. Karakter -> Tur:  Samuray, Hasar: 5, Saglik: 21, Para: 15 ");
        System.out.println("2. Karakter -> Tur:  Okcu,    Hasar: 7, Saglik: 18, Para: 20"); 
        System.out.println("3. Karakter -> Tur:  Sovalye, Hasar: 8, Saglik: 24, Para: 5"); 
        System.out.print("Seciniz: ");
        int chaID=input.nextInt();

        while(chaID<1 || chaID>3){
            System.out.print("Lutfen geceerli bir karakter seciniz: ");
            chaID=input.nextInt();
        }

        return chaID;
    }
    public int getTotaldamage(){
        return this.getDamage()+this.getInv().getDamage();
    }
    public Player(String name){
        this.name=name;
        this.inv=new Inventory();
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public int gethealthy(){
        return healthy;
    }
    public void setHealthy(int healthy){
        this.healthy=healthy;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public int getReHeal(){
        return reHeal;
    }
    public void setReHeal(int reHeal){
        this.reHeal=reHeal;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getCName(){
        return cname;
    }
    public void setCName(String cName){
        this.cname=cName;
    }
    public Inventory getInv(){
        return inv;
    }
    public void setInv(Inventory inv){
        this.inv=inv;
    }
}
