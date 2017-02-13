import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileManagerServer{

    public static void main(String args[]) {
        try {
            ConnectDB co = new ConnectDB();
            co.connect();
            Connect cs = new Connect();
            String log = cs.getData();
            String loginfo[] = log.split(",");
            String Che =  co.check(loginfo[0], loginfo[1]);

            cs.sendData(Che);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
