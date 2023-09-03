import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {

    public static void main(String args[]) throws IOException {
        
        ServerSocket ss = new ServerSocket(3333);
        Socket s1 = ss.accept(); 

        DataInputStream din = new DataInputStream(s1.getInputStream());
        DataOutputStream dout = new DataOutputStream(s1.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int n,i;
        System.out.println("Enter number of frame: ");
        //n = sc.nextInt();
        n = Integer.parseInt(br.readLine());
        System.out.println("n = " + n);
        
        String a[] = new String[n];

        dout.write(n);

        for(i=0;i<n;i++){
           a[i] = br.readLine();
        } 

        for (i=1;i<=n;i++) {
           System.out.println("Sending frame number" + i);
           dout.writeUTF(a[i-1]);
        }
        int temp = din.read();
        dout.writeUTF(a[temp]);

        dout.close();
       
        s1.close();

    }
}