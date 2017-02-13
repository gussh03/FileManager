import sun.reflect.annotation.ExceptionProxy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

class Connect {
    ServerSocket s_socket;
    Socket c_socket;
    String userData;
    InputStream inData;
    public Connect() {
        try {
            s_socket = new ServerSocket(8888);
            c_socket = s_socket.accept();
            System.out.println("Success");
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getData(){
        String data1= null;
        try{
            inData = c_socket.getInputStream();
            byte[] message1 = new byte[1000];
            inData.read(message1);
            data1 = new String(message1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data1;
    }
    public void sendData(String data){
        try{
            OutputStream message = c_socket.getOutputStream();
            String mes = data;
            message.write(mes.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void endConnect(){
        try{
            s_socket.close();
            c_socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}