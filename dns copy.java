import java.net.*;
import java.util.*;

public class dns
{

static public void main(String args[]) throws Exception
{

Scanner scan = new Scanner(System.in);

System.out.println("Enter choice");
int choice = scan.nextInt();
scan.nextLine ();                           // Most important Line ****

if (choice ==1)
{

System.out.println("Enter url");
String url = scan.nextLine();

try{

InetAddress add = InetAddress.getByName(url);
System.out.println(add.getHostAddress());

}

catch(Exception e)
{
    System.out.println(e);
}


}


else
{
    System.out.println("Enter IP");
    String IP = scan.nextLine();

    InetAddress add = InetAddress.getByName(IP);
    System.out.println("Host name: " + add.getHostName());

}
scan.close();

}

}

