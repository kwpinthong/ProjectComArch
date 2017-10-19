import com.sun.org.apache.xalan.internal.xsltc.dom.EmptyFilter;
import sun.invoke.empty.Empty;

import java.util.List;

/**
 * Created by ASUS on 10/19/2017.
 */
public class Assembly {
    String[] assembly;

    public Assembly(String file){
        assembly = file.split("\t",-1); //split each label to each array 0 - 5 (first-label,instruction,value1,value2,value3,comment)
        callFunction();                             //send to callFunction
    }

    public void callFunction(){
        if(assembly[0].equals("start")){
            System.out.println("Have Start"); //Start loop
            instruction(assembly[1]);
        }else{
            instruction(assembly[1]);
        }
    }

    public void instruction(String command){
        if(command.equals("add")){
            //call function
            System.out.println("do add");
        }
        if(command.equals("nand")){
            //call function
            System.out.println("do nand");
        }
        if(command.equals("lw")){
            //call function
            System.out.println("do lw");
        }
        if(command.equals("sw")){
            //call function
            System.out.println("do sw");
        }
        if(command.equals("beq")){
            //call function
            System.out.println("do beq");
        }
        if(command.equals("jalr")){
            //call function
            System.out.println("do jalr");
        }
        if(command.equals("halt")){
            //call function
            System.out.println("do halt");
        }
        if(command.equals("noop")){
            //call function
            System.out.println("do noop");
        }
    }

}
