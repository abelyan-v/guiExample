package Action.SecondTask.Except;

public class DivZero extends Exception {
    static final String MESSAGE = "You can't divide anything other than 0!";
    public DivZero() {
        super(MESSAGE);
    }

}