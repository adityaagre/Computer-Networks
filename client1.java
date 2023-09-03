import java.net.*;
import java.io.*;

public class client1{

    public static void main(String args[])throws Exception
    
    {
    
    Socket s = new Socket("localhost", 3333);
    
    DataInputStream din = new DataInputStream(s.getInputStream());
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String str="";
    String str2="";
    
    while(!str.equals("stop"))
    {
    
        str2=br.readLine();
        dout.writeUTF(str2);
        dout.flush();
        
        str=din.readUTF();
        System.out.println(str);
    
    }
    
    din.close();
    s.close();
    
    
    
    
    
    }
}