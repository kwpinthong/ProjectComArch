package instruction;

/**
 * Created by ASUS on 27/10/2560.
 */
public class halt {

    static String op = "110" ;

    public halt( ){

    }

    public String dohalt(){
        return String.valueOf(Integer.parseInt("0000000"+op+"0000000000000000000000",2));
    }
}
