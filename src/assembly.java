import instruction.*;

import java.util.ArrayList;

/**
 * Created by ASUS on 10/19/2017.
 */
public class assembly {
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
           label.add(data[i][0]);
           //---------------------//
       }
   }

    public void working()throws Exception{
       for(int i = 0; i < nRows; i++){
           this.inst = data[i][1];
           try{
               this.field0 = data[i][2];
               this.field1 = data[i][3];
               this.field2 = data[i][4];
               this.comment = data[i][5];
           }catch (Exception e){
               //This case for non-fill tab all of field in file.txt//
               if(inst.equals(".fill")){
                   this.field1 = "";
                   this.field2 = "";
                   this.comment = "";
               }else{
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
                       loadStore lw = new loadStore(field0, field1, field2, label, data);
                       System.out.println(lw.doLw());
                       break;
                   case "sw" :
                       //Do anything same lw in assembler
                       loadStore sw = new loadStore(field0, field1, field2, label, data);
                       System.out.println(sw.doLw());
                       break;
                   case "beq" :
                       beq beq = new beq(field0,field1,field2,label,i);
                       System.out.println(beq.doBeq());
                       break;
                   case "jalr" :
                       //call function
                       break;
                   case "halt" :
                       //call function
                       halt halt = new halt();
                       temp=halt.dohalt();
                       System.out.println(temp);
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
    private boolean isNumber(String field0){
        try{
            int temp = Integer.parseInt(field0);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}
