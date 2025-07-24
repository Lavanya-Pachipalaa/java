import java.io.*;
import java.util.*;

public class StringSplitting {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        if(s.isEmpty())
          System.out.println(0);
        else
        {String[] str=s.trim().split("[\\s!,?._'@]+");
        System.out.println(str.length);
        for(String stri:str)
          System.out.println(stri);}
        scan.close();
    }
}

