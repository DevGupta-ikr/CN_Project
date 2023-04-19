/**
This class represents the Server of the Chatting Application.
*/

package chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class Server implements ActionListener 
{
    
    JTextField text; // text field to enter message
    JPanel a1; // panel to display messages
    static Box vertical = Box.createVerticalBox(); // vertical box to store messages declared statically
    static JFrame f = new JFrame(); // frame to display UI declared statically
    static DataOutputStream dout; // output stream to send messages from server to client declared statically
    
    Server() 
    {
        // Creating the UI for the application
        f.setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0, 128, 255));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);
        
        /**
         * This code attaches a mouse listener to the "back" button. 
         * When the button is clicked, it exits the program by calling the System.exit()  
        */
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);
        p1.add(video);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert);
        
        JLabel name = new JLabel("Student 1");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);
        
        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);
        
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        f.add(a1);
        
        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);
        
        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(0, 128, 255));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);
        
        f.setSize(450, 700);
        f.setLocation(200, 50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);
        
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {

        /**
         * This method is called when the user clicks the "Send" button in the chat window.
         * It sends the text message entered by the user to the server and displays it on the chat window.
        */
        try 
        {
            // Get the text entered by the user
            String out = text.getText();

            JPanel p2 = formatLabel(out);

            // Set the layout of the chat window and add the new JPanel to it
            a1.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            a1.add(vertical, BorderLayout.PAGE_START);
            
            // Send the text message to the server
            dout.writeUTF(out);

            // Clear the text field
            text.setText("");

            // Refresh the chat window
            f.repaint();
            f.invalidate();
            f.validate();   
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static JPanel formatLabel(String out) 
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // create a label with formatted text
        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        // set the background color of the label to blue
        output.setBackground(new Color(0, 128, 255));
        output.setOpaque(true);
        
        // set the empty border around the label
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        
         // add the label to the panel
        panel.add(output);
        
        // get the current time and format it
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        // create a label with the time and add it to the panel
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        // return the panel with the formatted label and time
        return panel;
    }
    
    public static void main(String[] args) 
    {
        // Create an instance of the Server class to start the server and display the UI
        new Server();
        
        try 
        {
            // Create a server socket on port 6001 to accept incoming connections
            ServerSocket skt = new ServerSocket(6001);

            // Continuously accept new client connections
            while(true) {
                Socket s = skt.accept();
                
                 // Create input and output streams for the client socket
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                
                while(true) {
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg);
                    
                    // Create a JPanel to hold the message, and add it to the chat window
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate(); // Update the UI to display the new message
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace(); // If there is an error, print the stack trace for debugging purposes
        }
    }
}
