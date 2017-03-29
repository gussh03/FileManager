import java.sql.*;
import java.sql.Connection;
import java.util.Vector;

class ConnectDB {
    Connection con;
    String url;
    String id;
    String password;
    public void connect(){
        con = null;
        url = "jdbc:mysql://localhost:3306/filemanager";
        id = "root";
        password = "1q2w3e4r";
        try{
            con = DriverManager.getConnection(url, id, password);
            System.out.println("Connecting");
        }catch(Exception e){
            System.out.println("connecting failed");
            System.out.println( e.getMessage());
        }
    }
    public void signinDB(String name, String filename, String pw){
        PreparedStatement ps = null;
        String sql = "insert into user values(?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2,filename);
            ps.setString(3,pw);
            int n = ps.executeUpdate();
            if(n>0)
                System.out.println("Good");
            else
                System.out.println("Failed");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void folder(String user ,String folder){
        PreparedStatement ps = null;
        String sql = "insert into userFolder values(?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,folder);
            int num = ps.executeUpdate();
            if(num > 0)
                System.out.println("폴더 이름 저장");
            else{
                System.out.println("폴더 저장 no");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String joinCheck(String name)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String filename = null;
        String sql = "select * from user where name = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("아이디 존재");
                return "F";
            }
            else {
                System.out.println("아이디 없음");
                return "T";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public String check(String name, String pw){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String filename = null;
        String sql = "select * from user where name = ? and password = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pw);
            rs = ps.executeQuery();
            if(rs.next()) {
                filename = rs.getString("filename");
                System.out.println("File name : " + filename);
                return filename;
            }
            else{
                System.out.println("ID존재하지않음");
                return "F";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "F";

    }

    public Vector folderCheck(String user){
        Vector vec = new Vector();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from userFolder where userName = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while(rs.next()){
                vec.addElement(rs.getString("folderName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return vec;
    }

}
