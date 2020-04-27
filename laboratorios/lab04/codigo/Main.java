import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String []args) {
        Scanner l = new Scanner(System.in);
        DataRead dr = new DataRead();
        Queries q = new Queries();
        try {
            dr.readFile();
        } catch (Exception e) {
            System.out.println("The file couldn't be found");
        }
        
        System.out.println("Enter the number of the operation you would like to consult: ");
        System.out.println("1. Look for the files inside an specific directory");
        System.out.println("2. look for the files inside an specific directory that have a memory use greater than certain amount");
        System.out.println("3. Look for the files from certain user");
        int value = l.nextInt();
        
        switch(value){
            case(1):
                q.query1();
            case(2):
                q.query2();
            case(3):
                q.query3();
        }
    }
}
