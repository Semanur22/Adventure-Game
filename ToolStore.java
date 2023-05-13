public class ToolStore extends NormalLoc {
    
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
    public boolean getLocation(){
        System.out.println("Para: "+player.getMoney());
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Çıkış");
        System.out.print("Yapmak istediginiz islemi giriniz: ");
        int selTool=input.nextInt();
        int selItemID;
        while(selTool<1 || selTool>3){
            System.out.print("1-3 arasi sayi giriniz: ");
            selTool=input.nextInt();
        } 
        switch(selTool){
            case 1: 
                selItemID=weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID=armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                System.out.print("Magazadan ciktiniz. Gitmek istediginiz yeri secin.");   
                break;
            default:

        }
        return true;
    }
    public int weaponMenu(){
        System.out.println("1- Tabanca, Hasar: 2, Para:25" );
        System.out.println("2- Kilic,   Hasar: 3, Para:35" );
        System.out.println("3- Tufek,   Hasar: 7, Para:45" );
        System.out.println("4- Cikis");
        System.out.print("Silah seciniz: ");
        int selWeapon=input.nextInt();
        while(selWeapon<1 || selWeapon>4){
            System.out.print("1-3 arasi sayi giriniz: ");
            selWeapon=input.nextInt();
        } 
        return selWeapon;
    }
    public void buyWeapon(int ItemID){
        int damage=0,price=0;
        String wName=null;
    
            switch(ItemID){
                case 1: 
                damage=2;
                wName="Tabanca";
                price=25;
                break;
                case 2: 
                damage=3;
                wName="Kilic";
                price=35;
                break; 
                case 3: 
                damage=7;
                wName="Tufek";
                price=45;
                break;
                case 4:
                System.out.print("Magazadan ciktiniz. Gitmek istediginiz yeri secin.");
                break;
                default:
                System.out.println("Gecersiz islem.");
                break;
            }
        if(ItemID<=4 || ItemID>1){
        if(player.getMoney()>=price){
        player.getInv().setDamage(damage);
        player.getInv().setWName(wName);
        player.setMoney(player.getMoney()-price);
        System.out.println(wName+ " satın aldiniz. Onceki hasariniz: "+player.getDamage()+", yeni hasariniz: "+(player.getTotaldamage()));
        System.out.println("Kalan para: "+(player.getMoney()));
    }
        else{
            System.out.println("Paraniz yetersiz. Bakiyeniz: "+player.getMoney());

        }
    }
       
    }
    public int armorMenu(){
        System.out.println("1- Hafif, Hasar: 1, Para:15" );
        System.out.println("2- Orta,  Hasar: 3, Para:25" );
        System.out.println("3- Agir,  Hasar: 5, Para:40" );
        System.out.println("4- Cikis");
        System.out.print("Zirh seciniz: ");
        int selArmor=input.nextInt();
        while(selArmor<1 || selArmor>4){
            System.out.print("1-3 arasi sayi giriniz: ");
            selArmor=input.nextInt();
        } 
        return selArmor;
    }
    public void buyArmor(int selID){
        int avoid=0,price=0;
        String aName=null;
    
            switch(selID){
                case 1: 
                avoid=1;
                aName="Hafif Zirh";
                price=15;
                break;
                case 2: 
                avoid=3;
                aName="Orta Zirh";
                price=25;
                break; 
                case 3: 
                avoid=5;
                aName="Agir Zirh";
                price=40;
                break;
                case 4: 
                System.out.print("Magazadan ciktiniz. Gitmek istediginiz yeri secin.");
                break;
                default:
                System.out.println("Gecersiz islem.");
                break;
            }
            if(selID<=4 || selID>1){
        if(player.getMoney()>=price){
        player.getInv().setArmor(avoid);
        player.getInv().setAName(aName);
        player.setMoney(player.getMoney()-price);
        System.out.println(aName+ " satın aldiniz. Engellenen hasar: "+player.getInv().getDamage());
        System.out.println("Kalan para: "+(player.getMoney()));
        }
        
        
    
        else
        {
            System.out.println("Paraniz yetersiz. Bakiyeniz: "+player.getMoney());
            

        }
    }
    }

}
