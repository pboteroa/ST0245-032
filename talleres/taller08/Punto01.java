package taller8;
import java.util.Stack;

public class Punto01 {

	public static void main(String[] args) {
		
		System.out.println(polaca("3 4 * 4 +")); //insertar operacion

	}
	
	public static int polaca (String string){
		
        String[] prefixStr = string.split(" "); 
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prefixStr.length; i++){
        	
            if(prefixStr[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(prefixStr[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(prefixStr[i].equals("-")){
                stack.push(stack.pop() - stack.pop());
            }
            else if(prefixStr[i].equals("/")){
                stack.push(stack.pop() / stack.pop());
            }
            else{
                stack.push(Integer.parseInt(prefixStr[i]));
            }
        }
        return stack.pop();
    }

}
