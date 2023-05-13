import java.util.Scanner;
public class Game {
    Player player;
    Location location;
    Scanner input=new Scanner(System.in);
    public void logIn(){
       
        System.out.println("Macera Oyununa Hoşgeldiniz");
        System.out.print("Baslamadan once isminizi giriniz: ");
        String playerName=input.nextLine();
        player=new Player(playerName);
        player.selectCha();
        start();
        
    }
    public void start(){
        int secim;
        while(true){
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("Yerler: ");
        System.out.println("1- Guvenli ev--> Size ait guvenli bir mekan, dusman yok !");
        System.out.println("2- Magara    --> Karsiniza zombi cikabilir.");
        System.out.println("3- Orman     --> Karsiniza vampir cikabilir.");
        System.out.println("4- Nehir     --> Karsiniza ayi cikabilir.");
        System.out.println("5- Magaza    --> Silah veya zirh alabilirsiniz.");
        System.out.print("Seciniz: ");
        secim=input.nextInt();

        while(secim<0 || secim>5){
            System.out.print("Lutfen gecerli bir yer seciniz: ");
            secim=input.nextInt();
        }
        switch (secim) {
            case 1:
            location=new SafeHouse(player); 
            break;
            case 2: 
            location=new Cave(player);
            break;
            case 3: 
            location=new Forest(player);
            break; 
            case 4:
            location=new River(player);
            break;
            case 5:
            location=new ToolStore(player);
            break;
            default:
            location=new SafeHouse(player); 
             break;
        }
        if(location.getClass().getName().equals("SafeHouse")){
            if(player.getInv().getFood() && player.getInv().getFirewood() && player.getInv().getWater()){
                System.out.println("Kazandiniz.");
                break;
            }
        }
        if(!location.getLocation()){
            System.out.println("Oyun bitti.");
            break;
        }
        
    }
    }
    
}
