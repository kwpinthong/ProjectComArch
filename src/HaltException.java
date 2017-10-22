/**
 * Created by ASUS on 22/10/2560.
 */
public class HaltException extends Exception
{
    //exception parameter
    public HaltException(){
        super();
    }

    //exception with exception massage
    public HaltException(String msg){
        super(msg);
    }

}
