public class Symbol{
    public static String[] symbols={"֍","☼","◊","⌂","♫","§","¤","Ѫ"};

    public static String getSymbol(int i) {
        if ( i < 8) {
            return symbols[i];
        } else {
            return symbols[0];
        }
    }
}