import instruction.add;
import instruction.nand;
import instruction.noop;

import java.util.*;

/**
 * Created by ASUS on 10/19/2017.
 */
public class assembly {
    /*
    ///////////////////////////////////////////////////////
    //List value from assembly[][] to String variables
    ///////////////////////////////////////////////////////
    label   = assembly[0];
    inst    = assembly[1];
    field0  = assembly[2];
    field1  = assembly[3];
    field2  = assembly[4];
    comment = assembly[5];
    */
    String label;
    String inst;
    String field0;
    String field1;
    String field2;
    String comment;

    String[][] data;
    int nRows;
    int nCols;

   public assembly(String[][] data, int nRows, int nCols){
       this.data = data;
       this.nRows = nRows;
       this.nCols = nCols;
   }

    public void working(){
       for(int i = 0; i < nRows; i++){
           //----Set all value----//
           this.label = data[i][0];
           this.inst = data[i][1];
           this.field0 = data[i][2];
           this.field1 = data[i][3];
           this.field2 = data[i][4];
           this.comment = data[i][5];
           //---------------------//
            String temp = "";
           /* Test string-bin to dec
           String test;
           test = String.valueOf(Integer.parseInt("010"+"000"+"010"+"011"+"100"+"0000000000000",2));
           System.out.println(test);*/

           if(inst.equals(".fill")){

           }else{
               switch(inst){
                   case "add":
                       add add = new add(field0,field1,field2);
                       temp = add.doAdd();
                       System.out.println(temp);
                       break;
                   case "nand":
                       //call function
                       nand nand = new nand(field0,field1,field0);
                       temp = nand.doNand();
                       System.out.println(temp);
                       break;
                   case "lw" :
                       //call function
                       break;
                   case "sw" :
                       //call function
                       break;
                   case "beq" :
                       //call function
                       break;
                   case "jalr" :
                       //call function
                       break;
                   case "halt" :
                       //call function
                       break;
                   case "noop" :
                       //call function
                       noop noop = new noop();
                       temp = noop.doNoop();
                       System.out.println(temp);
                       break;
                   default:break;
               }
           }
       }
    }

    public void print(){
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                System.out.println(data[i][j]);
            }
        }
    }
}
