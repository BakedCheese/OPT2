package Enums;

public enum Logs {
    NotValid ("Input is niet geldig, probeer opnieuw."),
    OutOfBounds ("Input is Out of Bounds, probeer opnieuw."),
    ;

    public final String label;

    Logs(String label) {
        this.label = label;
    }

    public void PrintOutLog(){
        System.out.println(this.label);
    }
}
