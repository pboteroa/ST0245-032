import java.io.*;
import java.util.*;

public class Ejercicio1_3
{
    public void neveras(Queue<String> neveras, Queue<String> solicitudes) {
        while(neveras.poll()!=null && solicitudes.poll()!=null) {
            String nextOrder= solicitudes.poll();
            int value= Integer.parseInt (nextOrder.substring(1, nextOrder.length()));
            for (int i=0; i<value; i++)
                System.out.print(nextOrder + neveras.poll());
        }
    }
}
