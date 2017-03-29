
import java.io.File;
import java.util.Vector;

public class FileManagerServer {
    public static void main(String args[]) {
        String log;
        String datasp[];
        String Che = null;
        String user = null;
        String path = null;
        Vector vec = new Vector();
        try {
            ConnectDB connectDb = new ConnectDB();
            connectDb.connect();
            Connect connectServer = new Connect();
            while(true)
            {
                log = connectServer.getData();
                datasp = log.split(",");
                if(!(datasp[0].equals("A")) && !(datasp[0].equals("B")) && !(datasp[0].equals("C")) && !(datasp[0].equals("D"))){
                    connectServer.receiveFile(user);
                }
                if(datasp[0].equals("A")) /* 로그인 정보 */
                {
                    Che =  connectDb.check(datasp[1], datasp[2]);
                    connectServer.folderInfo(Che);
                    connectServer.sendData(Che+",");
                    user = datasp[1];
                    vec = connectDb.folderCheck(user);
                    if(vec != null) {
                        connectServer.sendVecData(vec);
                    }
                }
                if(datasp[0].equals("B")) /* Id Check 버튼 */
                {
                    Che = connectDb.joinCheck(datasp[1])+",";
                    connectServer.sendData(Che);
                }
                if(datasp[0].equals("C")) /* Join 버튼 눌렀을때 디비에 데이터 넣음 */ {
                    connectDb.signinDB(datasp[1], datasp[4], datasp[2]);
                    connectServer.folderInfo(datasp[4]);
                }

                if(datasp[0].equals("D")){ /*폴더 이름 받아올 떄*/
                    String check = connectServer.dirCheck(datasp[1]);
                    if(check.equals("F")){
                        connectServer.sendData("F,");
                        connectDb.folder(user,datasp[1]);
                    }else if(check.equals("T")){
                        connectServer.sendData("T,");
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}




