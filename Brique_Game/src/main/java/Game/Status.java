package Game;

public enum Status {
    ON ("ON"),
    OVER ("OVER"),
    P1_WINS ("P1_WINS"),
    P2_WINS ("P2_WINS");

    private String gameStatus;
    Status(String s){ gameStatus = s;}
    public String getString() {return gameStatus;}
}
