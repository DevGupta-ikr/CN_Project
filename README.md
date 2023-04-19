
# Chat Application - Project Report 

DEPARTMENT OF COMPUTER SCIENCE AND ENGINEERING
OF HERITAGE INSTITUTE OF TECHNOLOGY


## Authors :ledger:

### SUBMITTED TO: 
- Dr. Mohuya Byabartta Kar
### SUBMITTED BY:
- Himanshu Rai, 2051266
- Srinjoy Ray, 2051073
- Shreya Mazumdar, 2051060
- Moitreyo Datta, 2051058
- Dev Kumar Gupta, 2051057
- Sanhati Kundu, 2051050
- Aditya Kant, 2051043 

&nbsp;

## Abstract 

Real-time communication through teleconferencing or chatting allows messages to be transmitted instantly from the sender to the receiver, bridging geographical barriers and bringing people and ideas closer together with the help of technology.

## Introduction :bulb:

- Chat Application is a desktop based application.
- This client server chat application is based on java swing and uses socket packages. It's simple and easy and requires only core java knowledge. 
- This application/program is a good example of using java.io, java.net package to create a chat application. A beginner of java language, who is familiar with these packages can benefit.

## Main Objective :dart:

The aim of this project is to express how we can implement a simple chat application between a server and a client. The application is a desktop based application and is implemented using Swing and AWT. The project is developed in Java language executed on a single stand-alone java across a network using loopback address concept.

### Application consists of two programs:

- Server
- Client

## Server
The server module of the application waits for the client to connect to it. Then if connection is granted a client interacts, communicates and connects to the server, it can mutually communicate with the server. The duty of the server is to let clients exchange the messages.

## Client
The client module is the one that the utilizer sends requests to the server. Utilizer utilizes the client as the means to connect to the server. Once he establishes the connection, he can communicate to the connected server.

&nbsp;

## Working Model :gear:

### Server for 1:1 Chatting Application
<hr>
<img src="https://user-images.githubusercontent.com/77541795/233034073-920d2e30-4699-4ed1-8017-d96a9d35f0be.png" width="218" height="270">

### Server and Client for 1:1 Chatting Application
<hr>
<img src="https://user-images.githubusercontent.com/77541795/233035755-1e2e5447-6800-4854-b998-8bf71b92ff5c.png" width="480" height="270">


### Server and Clients for Group Chatting Application
<hr>
<img src="https://user-images.githubusercontent.com/77541795/233037423-c94fa91f-b4c3-4c5a-a963-592497c054ca.png" width="480" height="270">

&nbsp;
## Requirements

### User Interface

The user interface required to be developed for the system should be user friendly and attractive.
There are two sets of Java APIs for graphics programming: AWT (Abstract Windowing Toolkit) and Swing.

- AWT API was introduced in JDK 1.0. Most of the AWT components have become obsolete and should be replaced by newer Swing components.
- Swing API, a much more comprehensive set of graphics libraries that enhances the AWT, was introduced as part of Java Foundation Classes (JFC) after the release of JDK 1.1 . JFC consists of Swing, Java2D, Accessibility, Internationalization, and Pluggable Look-and-Feel Support APIs. JFC was an add-on to JDK 1.1 but has been integrated into core Java since JDK 1.2

## Operational Concepts and Scenarios :book:
Operation of the application based on the inputs given by the user:

- When the run button is clicked then the chat form is initialized with a connection between the host and the client machine.
Note: server must be started first before a client starts.

- Contains a rich textbox which send messages from one user to another
- Contains a textbox for messages to be written that is sent across the network.
- Contains a Send button
When the sent button is clicked, in the background, the text in the textbox is encoded and sent as a packet over the network to the client machine. Here this message is decoded and is shown in the rich textbox.

&nbsp;
## Documentation :bookmark:

Please read the complete Documentation [**here**](https://github.com/HIMU-2001/CN_Project/blob/main/DOCUMENTATION.pdf)



## License

[**MIT**](https://choosealicense.com/licenses/mit/)


## Conclusion
- We developed network applications in Java by using sockets and threads concepts. 
- This software is portable, efficient, and easily maintainable for a large number of clients. 
- Our developed chatting software is unique in its features and more importantly easily customizable. The java.net package provides a powerful and flexible set of classes for implementing network applications. Typically, programs running on client machines make requests to programs on a server Machine. These involve networking services provided by the transport layer. The most widely used transport protocols on the Internet are TCP (Transmission control Protocol) and UDP (User Datagram Protocol).
- TCP is a connection-oriented protocol providing a reliable flow of data between two computers. On the other hand, UDP is a simpler message-based connectionless protocol which sends packets of data known as datagrams from one computer to another with no guarantees of arrival.

