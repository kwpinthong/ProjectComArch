/**
 * Created by ASUS on 10/20/2017.
 */
public class Add {

    String detReg;
    int value1;
    int value2;

    public Add(String field0, String filed1, String filed2){
        /*filed0 = DetReg that will keep result
        * filed1 = value1 from regA
        * filed2 = value2 from regB */
        this.detReg = field0;
        this.value1 = Integer.valueOf(filed1);
        this.value2 = Integer.valueOf(filed2);
    }

    public void doAdd(){
        System.out.println(value1+value2);
    }
}
