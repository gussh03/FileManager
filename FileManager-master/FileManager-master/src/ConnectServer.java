import java.io.*;
import java.net.Socket;
import java.util.*;

class ConnectServer {
    Socket c_socket;
    String IPaddress = "127.0.0.1";
    int portnum = 8888;

    public ConnectServer() {
        try {
            c_socket = new Socket(IPaddress, portnum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vector getVecData() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Vector vec = new Vector();
        try {
            fis = new FileInputStream("/Users/hyeon-yeong/Desktop/objectData");
            ois = new ObjectInputStream(fis);
            vec = (Vector) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) try {
                fis.close();
            } catch (IOException e) {
            }
            if (ois != null) try {
                ois.close();
            } catch (IOException e) {
            }
        }

        return vec;
    }

    public void Login(String name, String pw) {
        try {
            OutputStream message = c_socket.getOutputStream();
            String mes = "A," + name + "," + pw + ",";
            message.write(mes.getBytes());
            System.out.println(mes);
            message.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void joinData(String data1, String data2, String data3, String data4) {
        try {
            OutputStream message = c_socket.getOutputStream();
            String mes = "C," + data1 + "," + data2 + "," + data3 + "," + data4 + ",";
            message.write(mes.getBytes());
            message.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendData(String data) {
        try {
            OutputStream message = c_socket.getOutputStream();
            String mes = data;
            message.write(mes.getBytes());
            message.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getData() {
        String data1 = null;
        try {
            InputStream inData = c_socket.getInputStream();
            byte[] message1 = new byte[4096];
            inData.read(message1);
            data1 = new String(message1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data1;
    }

    public String getData1() { /*Login -> id, pwd check*/
        String data1 = null;
        try {
            InputStream inData = c_socket.getInputStream();
            byte[] message1 = new byte[4096];
            inData.read(message1);
            data1 = new String(message1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data1;
    }

    public void fileSend(String directory, String fileName) {
        File sendFile;
        FileInputStream fileIn;
        InputStream in;
        OutputStream out;
        BufferedReader reader;
        BufferedWriter writer;
         try{
            if(c_socket.isConnected()){
                sendFile = new File(directory + File.separator +fileName);
                fileIn = new FileInputStream(sendFile);

                in = c_socket.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                out = c_socket.getOutputStream();
                writer = new BufferedWriter(new OutputStreamWriter(out));
            }else{
                System.out.println("Not connect!");
                return;
            }
            out.write(fileName.getBytes("UTF-8"));

            int len;
            byte data[] = new byte[4096];
            while((len = fileIn.read(data))!= -1){
                out.write(data,0,len);
                data = new byte[4096];
            }
            System.out.println("Complete File Send!");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}