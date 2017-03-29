import java.io.*;
import java.net.*;
import java.util.*;

class Connect {
    ServerSocket s_socket;
    Socket c_socket;
    String userData;
    String folderName;
    public String route = "/Users/hyeon-yeong/Desktop/serverTest";
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
    public void folderInfo(String folderName){
        this.folderName = folderName;
        makeDir();
    }
    public String dirCheck(String dir){ /* 사용자 계정 -> 폴더생성*/
        String userFolder = route + File.separator + folderName;
        System.out.println(userFolder);
        File file = new File(userFolder+File.separator + dir);
        if(file.exists()){
            return "T";
        }else{
            file.mkdir();
            return "F";
        }
    }
    public void makeDir(){ /* 로그인 시 폴더 생성 */
        try {
            File mkDir = new File(route +  File.separator + folderName);
            if (!mkDir.exists()) {
                mkDir.mkdir(); /*폴더 없을시 생성*/
                System.out.println("폴더 생성");
            } else {
                System.out.println("폴더 존재");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void receiveFile(String user){
        File writeFile;
        FileOutputStream fileOut = null;
        try{
            byte data[] = new byte[4096];
            int len = inData.read(data);
            byte[] fileNameArr = new byte[len];
            System.arraycopy(data,0,fileNameArr,0,len);
            String fileName = new String(fileNameArr,"UTF-8");
            writeFile = new File("/Users/hyeon-yeong/Desktop"+ File.separator+fileName);
            fileOut = new FileOutputStream(writeFile);

            System.out.println(fileName + "Downloading...");
            while((len = inData.read(data))!=-1){
                data = new byte[4096];
                fileOut.write(data,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void sendVecData(Vector v){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("/Users/hyeon-yeong/Desktop/objectData");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(v);
            System.out.println("객체 저장");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getData(){
        String data1= null;
        try{
            inData = c_socket.getInputStream();
            byte[] message1 = new byte[8192];
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
            message.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

