/**
This class represents the Server of the Group Chatting Application.
*/

package group.chatting.application;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server implements Runnable 
{

    Socket socket;
    
    // Vector to store all the clients connected to the server
    public static Vector client = new Vector();
    
    // Constructor for Server class
    public Server (Socket socket) 
    {
        try 
        {
            this.socket = socket;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run() 
    {
        // Creating input and output streams to communicate with clients
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            // Adding client's output stream to the vector of output streams
            client.add(writer);
            
            // Continuously read messages from the client and send them to all other clients
            while(true) 
            {
                // Reading the message sent by the client
                String data = reader.readLine().trim();
                System.out.println("Received " + data);
                
                // Sending the message to all other clients connected to the server
                for (int i = 0; i < client.size(); i++) 
                {
                    try 
                    {
                        BufferedWriter bw = (BufferedWriter) client.get(i);
                        bw.write(data);
                        bw.write("\r\n");
                        bw.flush();
                    } 
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace(); // If there is an error, print the stack trace for debugging purposes
        }
    }


    public static void main(String[] args) throws Exception 
    {
        // Creating a server socket to accept incoming client connections
        ServerSocket s = new ServerSocket(2003);
        while(true) 
        {
            // Accepting client connection requests and starting a new thread to handle each client
            Socket socket = s.accept();
            Server server = new Server(socket);
            Thread thread = new Thread(server);
            thread.start();
        }
    }
}
