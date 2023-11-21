package Action.SecondTask.Except;

public class InvalidSize extends Exception {
    static final String MESSAGE = "Wrong matrix size!";
    public InvalidSize() {
        super(MESSAGE);
    }
}