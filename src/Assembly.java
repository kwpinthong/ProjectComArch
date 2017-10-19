import com.sun.org.apache.xalan.internal.xsltc.dom.EmptyFilter;
import sun.invoke.empty.Empty;

import java.util.List;

/**
 * Created by ASUS on 10/19/2017.
 */
public class Assembly {
    String[] assembly;

    public Assembly(String[] file){
        for(int i = 0; i < file.length; i++){
            assembly = file[i].split("\t",-1);
            callFunction();
        }
    }

    public void callFunction(){
        //System.out.println(assembly[1]);
        if(assembly[0]=="start"){
            //call function
            System.out.println("Have Start");
        }else{
                if(assembly[1].equals("add")){
                    //call function
                    System.out.println("do add");
                }
                if(assembly[1].equals("nand")){
                    //call function
                    System.out.println("do nand");
                }
                if(assembly[1].equals("lw")){
                    //call function
                    System.out.println("do lw");
                }
                if(assembly[1].equals("sw")){
                    //call function
                    System.out.println("do sw");
                }
                if(assembly[1].equals("beq")){
                    //call function
                    System.out.println("do beq");
                }
                if(assembly[1].equals("jalr")){
                    //call function
                    System.out.println("do jalr");
                }
                if(assembly[1].equals("halt")){
                    //call function
                    System.out.println("do halt");
                }
                if(assembly[1].equals("noop")){
                    //call function
                    System.out.println("do noop");
                }
        }
    }

}
