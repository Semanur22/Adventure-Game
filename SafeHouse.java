public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Guvenli Ev");
    }
    @Override
    public boolean getLocation(){
        player.setHealthy(player.getReHeal());
        System.out.println("Tamamen iyilestiniz.");
        System.out.println("Su an guvenli evdesiniz.");
        return true;
    }
    
}
