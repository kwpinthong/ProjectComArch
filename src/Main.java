/**
 * Created by ASUS on 10/18/2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //----Read file and input each line in array-list----//
        Scanner assemblyLine = new Scanner(new File("example_testadd.txt"));
        List<String> line = new ArrayList<>();
        while (assemblyLine.hasNextLine()){line.add(assemblyLine.nextLine());}
        //---------------------------------------------------//
        String[] temp = line.toArray(new String[0]);   //Add every lines form array-list to array
        Assembly assembly = new Assembly();
        for(int i = 0; i < temp.length; i++){assembly.SplitForKeep(temp[i]);}assembly.printListFirstLabel();
        for(int i = 0; i < temp.length; i++){assembly.DoProcess(temp[i]);}
    }
}