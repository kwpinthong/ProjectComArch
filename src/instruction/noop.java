package instruction;

public class noop {
    static String op = "111" ;


    public noop(){

    }

    public String doNoop(){
        return String.valueOf(Integer.parseInt("0000000"+op+"0000000000000000000000",2));
    }
}

