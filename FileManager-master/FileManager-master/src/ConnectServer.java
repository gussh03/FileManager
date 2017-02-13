import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class ConnectServer{
    Socket c_socket;
    String IPaddress = "127.0.0.1";
    int portnum = 8888;
    InputStream inData;
    public ConnectServer(){
        try {
            c_socket = new Socket(IPaddress, portnum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Login(String name, String pw){
        try{
            OutputStream message = c_socket.getOutputStream();
            String mes = name+","+pw+",";
            message.write(mes.getBytes());
            System.out.println(mes);
        }catch(Exception e){
            e.printStackTrace();
        }

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
    public String getData(){
        String data1 = null;
        try{
            InputStream inData = c_socket.getInputStream();
            byte[] message1 = new byte[100];
            inData.read(message1);
            data1 = new String(message1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data1;
    }
    public void closePG(){
        try{
            c_socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}