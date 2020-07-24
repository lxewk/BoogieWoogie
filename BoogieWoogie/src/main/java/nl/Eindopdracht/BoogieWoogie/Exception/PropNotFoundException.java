package nl.Eindopdracht.BoogieWoogie.Exception;

public class PropNotFoundException extends RuntimeException {
    public PropNotFoundException(long id) {
       super("Prop with id: " + id + " does not exist");
    }

    public PropNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
