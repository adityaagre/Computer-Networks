import java.net.*;
import java.io.*;
import java.util.*;

public class dns2
{

public static void main(String args[])
{

Scanner sc = new Scanner(System.in);

System.out.println("Enter choice");
int choice = sc.nextInt();
sc.nextLine();

if (choice == 1)
{

String s = sc.nextLine();

try{
InetAddress add = InetAddress.getByName(s);
System.out.println(add.getHostAddress());

}
catch(Exception e)
{
    System.out.println(e);
}

}

else
{

String IP = sc.nextLine();

try
{

InetAddress add = InetAddress.getByName(IP);
System.out.println(add.getHostName());


}

catch(Exception e)
{
    System.out.println(e);
}

}

}

}