public class Otter extends Animal{
    public Otter(){
        super("Otter Population", "12");
        daysTillDeath = (365*16)/(this.getPopulation());
        daysTillBirth = (16*2*365)/(this.getPopulation()*14);
    }
}
