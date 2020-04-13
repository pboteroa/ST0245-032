package punto02;

import java.util.LinkedList;

public class Punto02 {
    public static void main(String[] args){
    	
        String x = "This_is_a_[Beiju]_text";
        String y = "[[]][][]Happy_Birthday_to_Tsinghua_University";
        String z = "asd[fgh[jkl";
       
        System.out.println(sort(x));
        System.out.println(sort(y));
        System.out.println(sort(z));
    }
    
    public static String sort(String string){
    	
        String character = "";
        int count = 0;
        Boolean hasBracket = false;
        
        LinkedList<Character> list = new LinkedList<>();
        
        for (int i = 0; i < string.length(); i++) {
           
        	character = Character.toString(string.charAt(i));
        	
            if (character.equals("[")){
            	hasBracket = true;  
                count = 0;
            }
            else if (character.equals("]")){
            	hasBracket = false;   
            }
            else if (hasBracket == false){
            	list.offer(string.charAt(i));
            }
            else if (hasBracket == true){
                list.add(count, string.charAt(i));
                count ++;
            }
        }
        
        String newString = "";
        
        for (int i = 0; i < list.size(); i++) {
        	newString += list.get(i);
        }
        
        return newString;
    }
}
