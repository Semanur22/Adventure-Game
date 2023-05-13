public abstract class BettleLoc extends Location {
    protected Obstacle canavar;
    protected String award;
    BettleLoc(Player player, String name, Obstacle canavar,String award) {
        super(player);
        this.name=name;
        this.canavar=canavar;
        this.award=award;
    }
    public boolean getLocation(){
        int obsCount=canavar.obstacleCount();
        System.out.println("Su an buradasiniz: "+this.getName());
        System.out.println("Dikkatli olun. Burada "+obsCount+ " tane "+canavar.getName()+" var.");
        System.err.println("<S>avas veya <K>ac");
        String selCase=input.next();
        selCase=selCase.toUpperCase();
        if(selCase.equals("S") ){
           if( Combat(obsCount)){
               if(this.award.equals("food") && player.getInv().getFood()==false){
                   System.out.println(this.award+" kazandiniz!");
                   player.getInv().setFood(true);
               }else if(this.award.equals("firewood") && player.getInv().getFood()==false){
                System.out.println(this.award+" kazandiniz!");
                player.getInv().setFirewood(true);
              }else if(this.award.equals("water") && player.getInv().getFood()==false){
                System.out.println(this.award+" kazandiniz!");
                player.getInv().setWater(true);
              }
               System.out.println(this.getName()+" bolgesindeki tum dusmanlari temizlediniz.");

                return true;
           }
           if(player.gethealthy()<=0){
                System.out.println("Oldunuz!"); 
                return false;
            }           
        }

        return true;
    }
    public boolean Combat(int obsCount){
        int defCanHealth=canavar.getHealth();
        for(int i=0;i<obsCount;i++){
            playerStats();
            enemyStats();
            while(player.gethealthy()>0 && canavar.getHealth()>0){
                 
                   System.out.println("<V>ur veya <K>ac");
                    String selcase=input.next();
                    selcase=selcase.toUpperCase();
                    if(selcase.equals("V")){
                        System.out.println("Siz vurdunuz !");
                        canavar.setHealth(canavar.getHealth()-player.getTotaldamage());
                        afterHit();
                        if(canavar.getHealth()>0){
                        System.out.println("Canavar size vurdu !");
                        player.setHealthy(player.gethealthy()-canavar.getDamage()+player.getInv().getArmor());
                        afterHit();
                    }
                }
                    else{
                        System.out.println("Kactiniz ! ");
                        break;
                    }

            }
            if(canavar.getHealth()< player.gethealthy() && canavar.getHealth()<=0){
                System.out.println("Dusmani yendiniz !");
                player.setMoney(player.getMoney()+canavar.getAward());
                System.out.println("Guncel paraniz: "+player.getMoney());
                canavar.setHealth(defCanHealth);
                afterHit();
            }
            else{
                return false;
            }
        }
        return true;
    }
    private void afterHit() {
        System.out.println("Oyuncu cani: "+player.gethealthy());
        System.out.println(canavar.getName()+" cani: "+canavar.getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Oyuncu Degerleri: ");
        System.out.println("Can: "+player.gethealthy());
        System.out.println("Hasar: "+player.getTotaldamage());
        System.out.println("Para: "+player.getMoney());
        
        if(player.getInv().getDamage()>0){
            System.out.println("Silah: "+player.getInv().getWName());
        }
        if(player.getInv().getArmor()>0){
            System.out.println("Zirh: "+player.getInv().getAName());
        }
        
    }
    public void enemyStats(){
        System.out.println("");
        System.out.println(canavar.getName()+" Degerleri: ");
        System.out.println("Can: "+canavar.getHealth());
        System.out.println("Hasar: "+canavar.getDamage());
        System.out.println("Odul: "+canavar.getAward());
       
    
    }
}
