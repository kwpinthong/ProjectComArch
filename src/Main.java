/**
 * Created by ASUS on 10/18/2017.
 */

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner assemblyLine = new Scanner(new File("example.txt"));
        List<String> line = new ArrayList<>();

        while (assemblyLine.hasNextLine()){
            line.add(assemblyLine.nextLine());

        }
        String[] temp = line.toArray(new String[0]);
        Assembly assembly = new Assembly(temp);
    }
}

