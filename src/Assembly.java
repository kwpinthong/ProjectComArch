import com.sun.org.apache.xalan.internal.xsltc.dom.EmptyFilter;
import sun.invoke.empty.Empty;

import java.util.List;

/**
 * Created by ASUS on 10/19/2017.
 */
public class Assembly {
    String[] assembly;
    String label;
    String inst;
    String field0;
    String field1;
    String field2;
    String comment;

    /*
    ///////////////////////////////////////////////////////
    //List value from assembly[] to String variables
    ///////////////////////////////////////////////////////
    label   = assembly[0];
    inst    = assembly[1];
    field0  = assembly[2];
    field1  = assembly[3];
    field2  = assembly[4];
    comment = assembly[5];
    */


    public Assembly(String file){
        assembly = file.split("\t",-1); //split each label to each array 0 - 5 (first-label,instruction,value1,value2,value3,comment)
        for (int i = 0 ; i < assembly.length ; i++)System.out.println("test : Assembly No." + i +"\t" + assembly[i]);
        instruction(assembly[1]);                           //send to callFunction
    }


    //Not use Yet
    /*
    public void callFunction(){

        //For test how it work
        //for (int i = 0 ; i < assembly.length ; i++)System.out.println("test : Assembly No." + i +"\t" + assembly[i]);

        
        if(assembly[0].equals("start")){
            System.out.println("Have Start"); //Start loop
            instruction(assembly[1]);
        }else{
            instruction(assembly[1]);
        }
    }

    */

    public void instruction(String command){
        System.out.println("do : " + command);
        switch (command){
            case "add":
                //call function
                break;
            case "nand":
                //call function
                break;
            case "lw" :
                //call function
                break;
            case "sw" :
                //call function
                break;
            case "beq" :
                //call function
                inst = "100";
                break;
            case "jalr" :
                //call function
                break;
            case "halt" :
                //call function
                break;
            case "noop" :
                //call function
                inst = "111";
                break;
            default:break;

        }
        System.out.println("\n");

    }

}
