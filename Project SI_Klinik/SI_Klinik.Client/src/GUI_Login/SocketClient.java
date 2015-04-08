package GUI_Login;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
//import java.util.Date;
// javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;

public class SocketClient implements Runnable{
    
    public int port;
    public String serverAddr;
    public Socket socket;
    public Login ui;
    public ObjectInputStream In;
    public ObjectOutputStream Out;
  //  public History hist;
    
    public SocketClient(Login frame) throws IOException{
        ui = frame; this.serverAddr = ui.serverAddr; this.port = ui.port;
        socket = new Socket(InetAddress.getByName(serverAddr), port);
            
        Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
        
       // hist = ui.hist;
    }
    
    
    public void send(Message msg){
        try {
            Out.writeObject(msg);
            Out.flush();
            System.out.println("3.Outgoing : "+msg.toString());
 
        } 
        catch (IOException ex) {
            System.out.println("4.Exception SocketClient send()");
        }
    }
    
    public void closeThread(Thread t){
        t = null;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
