import java.sql.*;
import java.sql.Connection;

class ConnectDB {
    Connection con;
    String url;
    String id;
    String password;
    public void connect(){
        con = null;
        url = "jdbc:mysql://localhost:3306/filemanager";
        id = "root";
        password = "qwe40433630.";
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
            rs.next();
            filename = rs.getString("filename");
            System.out.println("File name : "+filename);
        }catch(Exception e){
            e.printStackTrace();
        }
        return filename;

    }
    public void endDB() {
        try {
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
