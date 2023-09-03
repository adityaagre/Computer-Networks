import java.net.*;
import java.io.*;

public class server1
{
public static void main(String args[])throws Exception
{

ServerSocket ss = new ServerSocket(3333);
Socket s = ss.accept();

DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

Scanner sc = new Scanner(System.in);

int n,i;
System.out.print("Enter number of frame: ");
n = Integer.parseInt(br.readLine());
System.out.println("n = " + n);

int a[] = new int[n];

dout.writeUTF(n);

for(i=0;i<n;i++){
    a[i] = sc.nextInt();
 } 

 for (i=1;i<=n;i++) {
    System.out.println("Sending frame number" + i);
    dout.writeUTF(a[i-1]);
 }




din.close();
s.close();
ss.close();

	

}


}