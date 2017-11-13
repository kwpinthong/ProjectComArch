/**
 * Created by ASUS on 10/19/2017.
 */

import instruction.*;

import java.io.IOException;
import java.util.ArrayList;

public class assembly{

    /*
    ใช้ทดลอง วนอ่านค่า label ทั้งหมดก่อน
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
    static ArrayList<String > label = new ArrayList<>();
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

   public void initLable(){
       for(int i = 0; i < nRows; i++) {
           //----Set all value----//
           if(data[i][0].isEmpty()){
               //add label
           }else{
               if(label.contains(data[i][0])){
                   System.out.println("Error: Find Duplicate Label");
                   System.exit(1);
               }else{
                   //add label
               }
           }
           label.add(data[i][0]);
       }
            //---------------------//
   }

    public void working()throws IOException{
       for(int i = 0; i < nRows; i++){
           this.inst = data[i][1];
           try{
               this.field0 = data[i][2];
               this.field1 = data[i][3];
               this.field2 = data[i][4];
               this.comment = data[i][5];
           }catch (Exception e){
                if(inst.equals("halt") || inst.equals("noop")){
                   this.field0 = "";
                   this.field1 = "";
                   this.field2 = "";
                   this.comment = "";
               }
           }
          String temp;
           if(inst.equals(".fill")){
               if(isNumber(field0)){
                   System.out.println(field0);
               }else{
                   System.out.println(label.indexOf(field0));
               }
           }else{
               if(!field2.isEmpty())checkLabel();
               switch(inst){
                   case "add":
                       add add = new add(field0,field1,field2);
                       temp = add.doAdd();
                       System.out.println(temp);
                       break;
                   case "nand":
                       nand nand = new nand(field0,field1,field0);
                       temp = nand.doNand();
                       System.out.println(temp);
                       break;
                   case "lw" :
                       try{
                           lw lw = new lw(field0, field1, field2, label, data);
                           System.out.println(lw.doLw());
                       }catch (IOException e){
                           System.out.println(e.getMessage());
                           System.exit(1);
                       }
                       break;
                   case "sw" :
                       //Do anything same lw in assembler
                       try {
                           sw sw = new sw(field0, field1, field2, label, data);
                           System.out.println(sw.doSw());
                       }catch (IOException e){
                           System.out.println(e.getMessage());
                           System.exit(1);
                       }
                       break;
                   case "beq" :
                       beq beq = new beq(field0,field1,field2,label,i);
                       System.out.println(beq.doBeq());
                       break;
                   case "jalr" :
                       jalr jalr = new jalr(field0,field1);
                       temp = jalr.toJalr();
                       System.out.println(temp);
                       break;
                   case "halt" :
                       halt halt = new halt();
                       temp=halt.dohalt();
                       System.out.println(temp);
                       break;
                   case "noop" :
                       noop noop = new noop();
                       temp = noop.doNoop();
                       System.out.println(temp);
                       break;
                   default:
                       System.out.println("Error: Wrong OPCODE at line "+(i+1));
                       System.exit(1);
               }
           }
       }
       System.exit(0);
    }

    private boolean isNumber(String field0){
        try{
            int temp = Integer.parseInt(field0);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    private void checkLabel(){
        //Check Label at field2 and check if label is undefine
        if(isNumber(field2)){
            return;//Go to switch cases
        }else{
            if(label.contains(field2)){
                return;//Go to switch cases
            }else{
                System.out.println("Error: Undefine Label");
                System.exit(1);
            }
        }
    }

}
