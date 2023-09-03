import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) throws IOException {
        // Open your connection to a server, at port 1254
        Socket s = new Socket("localhost", 3333);
        
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = din.read();
        System.out.println("Number of frames are " + n); 
        int i;
        String b[] = new String[n];

        for(i=0;i<n;i++) {
            b[i] = din.readUTF();
        }
        b[2] = "-1";

        for(i=0;i<n;i++){
            System.out.print(b[i] + " ");
        }
        

        for(i=0;i<n;i++){
            if(b[i]=="-1"){
                dout.write(i);
                b[i] = din.readUTF();
            }
        }
        
        System.out.println("");  
        for(i=0;i<n;i++){
            System.out.print(b[i] + " ");
        }

        // When done, just close the connection and exit
        din.close();
        
        s.close();
    }
}