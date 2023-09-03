import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) throws IOException {
        // Open your connection to a server, at port 1254
        Socket s1 = new Socket("localhost", 1254);
        // Get an input file handle from the socket and read the input
        InputStream s1In = s1.getInputStream();
        DataInputStream dis = new DataInputStream(s1In);
        OutputStream s1out = s1.getOutputStream();
        DataOutputStream dos = new DataOutputStream(s1out);

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        
        int n = dis.read();
        System.out.println("Number of frames are " + n); 
        int i;
        int b[] = new int[n];

        System.out.println("");
        for(i=0;i<n;i++) {
            System.out.println("Reading frame " + (i+1));
            b[i] = dis.read();
        }
        b[2] = -1;
        
        System.out.println("\nReceived Frames:");
        for(i=0;i<n;i++){
            System.out.print(b[i] + " ");
        }
        
        for(i=0;i<n;i++){
            if(b[i]==-1){
                dos.write(i);
                break;
            }
        }
        
        System.out.println("\n");
        for(;i<n;i++){
            System.out.println("Reading " + i);
            b[i] = dis.read();
            //System.out.println("b[" + i +"]= " + b[i]);
        }

        System.out.println("\nFrames after Go-Back-N: ");  
        for(i=0;i<n;i++){
            System.out.print(b[i] + " ");
        }
        System.out.println("");

        // When done, just close the connection and exit
        dis.close();
        s1In.close();
        s1.close();
    }
}