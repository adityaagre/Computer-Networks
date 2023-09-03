import java.net.*;
import java.io.*;
import java.util.*;

public class server2
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
n = sc.nextInt();

System.out.println("n = " + n);

int a[] = new int[n];

dout.write(n);

for(i=0;i<n;i++)
{
    a[i] = sc.nextInt();
} 

for (i=1;i<=n;i++) 
{
    System.out.println("Sending frame number " + i);
    dout.write(a[i-1]);
 }

 int temp = din.read();

 System.out.println("");
for(i=temp;i<n;i++)
{
    System.out.println("Sending frame number " + i);
    dout.write(a[i]);
    dout.flush();
}


din.close();
s.close();
ss.close();

	

}


}