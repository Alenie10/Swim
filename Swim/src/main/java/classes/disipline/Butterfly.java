
package classes.disipline;


public class Butterfly extends Discipline {
    String description = "Beskrivelse af hvordan man svømmer Butterfly";

    public Butterfly() {
        super("Butterfly");
    }

    @Override
    public String toString() {
        return "Butterfly{" + "description=" + description + '}';
    }
    
    
}
