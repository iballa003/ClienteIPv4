
package clienteipv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ClienteIPv4 {

    public static void main(String[] args) {
        //Ip y puerto del servidor.
        String host = "localhost";
        int port = 12341;
        int count = 0;
        
        List<String> ipsArray = Arrays.asList("172.16.1.13/16", "192.168.1.25/24", "192.168.25.45/24",
                "172.16.5.4/16", "10.16.1.13/8","11.17.1.14/8","192.168.1.67/24");
        Random rand = new Random();
        try {
            //COnectarse al servidor
            Socket socket = new Socket(host,port);
            System.out.println("Conectado al servidor "+host+" en el puerto "+port+".");
            while(true){
                PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                String randomIp = ipsArray.get(rand.nextInt(ipsArray.size()));
                String randomIp2 = ipsArray.get(rand.nextInt(ipsArray.size()));

                if(count >= 5){
                    String answer = input.readLine();
                    System.out.println(answer);
                    System.out.println("0.0.0.0/0");
                    output.println("0.0.0.0/0");
                    break;
                }else{
                    String answer = input.readLine();
                    System.out.println(answer);
                    System.out.println("Primera Ip: "+randomIp);
                    output.println(randomIp);
                    
                    String answer2 = input.readLine();
                    System.out.println(answer2);
                    
                    System.out.println("Segunda Ip: "+randomIp2);
                    output.println(randomIp2);
                }
                count++;
                
                
            }
            
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
