/**
 * Created by ASUS on 10/19/2017.
 */

import instruction.*;
import instruction.I_Type.beq;
import instruction.I_Type.sw_lw;
import instruction.J_Type;

import java.io.IOException;
import java.util.ArrayList;

public class assembler {
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
    static ArrayList<String> label = new ArrayList<>();
    String inst;
    String field0;
    String field1;
    String field2;
    String comment;

    String[][] data;
    int nRows;
    int nCols;

   public assembler(String[][] data, int nRows, int nCols){
       this.data = data;
       this.nRows = nRows;
       this.nCols = nCols;
   }
   public void initLable(){
       for(int i = 0; i < nRows; i++) {
           //----Set all value----//
           label.add(data[i][0]);
       }   //---------------------//
   }
    public void working()throws IOException{
       initLable();
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
               }else if(inst.equals("jalr")){
                   this.field0 = data[i][2];
                   this.field1 = data[i][3];
                   this.field2 = "";
                   this.comment = "";
               }
           }
          String temp;
           if(inst.equals(".fill")){
               if(isNumeric(field0)){
                   System.out.println(field0);
               }else{
                   System.out.println(label.indexOf(field0));
               }
           }else{
               //if(!field2.isEmpty())checkLabel();
               switch(inst){
                   case "add":
                   case "nand":
                       R_Type RType = new R_Type(inst,field0,field1,field2);
                       temp = RType.doAdd_oR_Nand();
                       System.out.println(temp);
                       break;
                   case "lw" :
                   case "sw" :
                       try{
                           sw_lw sw_lw = new sw_lw(inst,field0, field1, field2, label, data);
                           System.out.println(sw_lw.doLw_oR_Sw());
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
                       J_Type J_Type = new J_Type(field0,field1);
                       temp = J_Type.toJalr();
                       System.out.println(temp);
                       break;
                   case "halt" :
                   case "noop" :
                       O_Type OType = new O_Type();
                       temp = OType.dohalt_oR_Noop(inst);
                       System.out.println(temp);
                       break;
                   default:
                       //If don't find any match opcode = wrong opcode
                       System.out.println("Error: Wrong OPCODE");
                       System.exit(1);
               }
           }
       }
       System.exit(0);
    }
    public static boolean isNumeric(String str){
        try{
            double d = Double.parseDouble(str);
        } catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }
    private void checkLabel(){
        //Check Label at field2 and check if label is undefine
        if(!isNumeric(field2)){
            if(!label.contains(field2)){
                System.out.println("Error: Undefined Label");
                System.exit(1);
            }
        }
        return;
    }
}
