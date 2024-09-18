package backend.academy.gallow_game.exceptions;

public class GallowsStateNotFoundException  extends Throwable{

    public GallowsStateNotFoundException() {super();}

    public GallowsStateNotFoundException(String message) {super(message);}

    public GallowsStateNotFoundException(Throwable cause) {super(cause);}

    public GallowsStateNotFoundException(String message, Throwable cause) {super(message, cause);}
}
