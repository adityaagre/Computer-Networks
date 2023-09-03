import java.net.*;
import java.io.*;
import java.util.*;

public class client2{

    public static void main(String args[])throws Exception
    
    {
    
    Socket s = new Socket("localhost", 3333);
    
    DataInputStream din = new DataInputStream(s.getInputStream());
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Scanner sc = new Scanner(System.in);



    int n = din.read();
    System.out.println("Number of frames are " + n); 
    int i;
    int b[] = new int[n];

    System.out.println("");
    for(i=0;i<n;i++) {
        System.out.println("Reading frame " + (i+1));
        b[i] = din.read();
    }

    b[2] = -1;

    System.out.println("\nReceived Frames:");
        for(i=0;i<n;i++){
            System.out.print(b[i] + " ");
        }


    for(i=0;i<n;i++)
    {
        if(b[i]==-1)
        {
            dout.write(i);
            break;
        }
    }

    System.out.println("\n");
        for(;i<n;i++){
            System.out.println("Reading " + i);
            b[i] = din.read();
            //System.out.println("b[" + i +"]= " + b[i]);
        }

    
        System.out.println("\nFrames after Go-Back-N: ");  
        for(i=0;i<n;i++){
            System.out.print(b[i] + " ");
        }
        System.out.println("");
    

    
    din.close();
    s.close();
    
    
    
    
    
    }
}