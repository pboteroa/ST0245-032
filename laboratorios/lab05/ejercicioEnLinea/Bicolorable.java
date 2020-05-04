package lab05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*; 
  
class Bicolorable { 
	
	 public static void main (String[] args)throws Exception{ 
	     
		 File file = new File("C:\\Users\\samue\\Desktop\\grafo.txt");
         BufferedReader br = new BufferedReader(new FileReader(file));
         String l = br.readLine();
         while((l != null) && (!l.equals(""))) {
             int vert = Integer.parseInt(l);
             int G[][] = new int[vert][vert];
             int numCon = Integer.parseInt(br.readLine());

             for (int i = 0; i < numCon; i++) {
                 String line = br.readLine();
                 String[] con = line.split(" ");
                 int num1 = Integer.parseInt(con[0]);
                 int num2 = Integer.parseInt(con[1]);
                 G[num1][num2] = 1;
             }
             Bicolorable b = new Bicolorable();
             if (b.isBicolorable(G, 0, vert))
                 System.out.println("BICOLORABLE");
             else
                 System.out.println("NOT BICOLORABLE");
             l = br.readLine();
         }
	 }
  
    boolean isBicolorable(int G[][], int src, int V) { 
         
        int colorArr[] = new int[V];
        
        for (int i = 0; i < V; i++) { 
            colorArr[i] = -1; 
        }
  
        colorArr[src] = 1; 
  
        LinkedList<Integer>q = new LinkedList<Integer>(); 
        q.add(src); 
         
        while (q.size() != 0) { 
                
            int u = q.poll(); 
              
            if (G[u][u] == 1) { 
                return false;
            }
              
            for (int v = 0; v < V; v++) {      
                if (G[u][v] == 1 && colorArr[v] == -1) {                    
                    colorArr[v] = 1 - colorArr[u]; 
                    q.add(v); 
                }  
                else if (G[u][v] == 1 && colorArr[v] == colorArr[u]) { 
                    return false;
                }
            } 
        } 
         
        return true; 
    } 

}
