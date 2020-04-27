import java.util.*;
import java.io.*;

public class Queries {
    String name, size, user;
    Node directory;
    Scanner l = new Scanner(System.in);
    Node n1 = new Node(name, size, directory, user);
    public void query1() {
        System.out.println("Which directory would you like to inspect?");
        String dir = l.nextLine();
        String files = "";
        
        for (int i = 0; i < n1.arr.size(); i++) {
            if(n1.arr.get(i).directory.equals(dir)) files = files + " " + n1.arr.get(i).name + ",";
        }
        
        System.out.println("The files inside the directory " + dir + " are:" + files);
    }
    
    public void query2() {
        System.out.println("Which directory would you like to inspect?");
        String dir = l.nextLine();
        System.out.println("What should be the minimum memory used? Give the quantity in kilobytes");
        int mem = l.nextInt();
        double newMem = 0;
        String list = "";
        
        for(int i = 0; i < n1.arr.size(); i++) {
            if(n1.arr.get(i).size.contains("M")) {
                newMem = Double.parseDouble(n1.arr.get(i).size.substring(0, n1.arr.get(i).size.indexOf('M'))) * 1000;
            }
            if(n1.arr.get(i).size.contains("K")) {
                newMem = Double.parseDouble(n1.arr.get(i).size.substring(0, n1.arr.get(i).size.indexOf('K')));
            }
            if(newMem > mem) {
                list += " " + n1.arr.get(i).name + ",";
            }
        }
        
        System.out.println("The files inside the directory " + dir + " that have more than " + mem + " kilobytes are:" + list);
    }
    
    public void query3() {
        System.out.println("Which user would you like to search?");
        String u = l.nextLine();
        String list = "";
        
        for(int i = 0; i < n1.arr.size(); i++) {
           if(n1.arr.get(i).user.equals(u)) {
                list += " " + n1.arr.get(i).name + ",";
           }
        }
        
        System.out.println("The files whose user is " + u + " are:" + list);
    }
}
