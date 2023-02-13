package loginfilter.connection;
import java.sql.*;
import static java.lang.Class.*;

public class MariaDBConnect {
    private static String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    private static String URL = "jdbc:mariadb://localhost:3306/hoang";
    private static String USER_NAME = "root";
    private static String PASSWORD = "hoangdz99";
    public static Connection getConnection(){
        Connection connection = null;
        try {
            //Đăng ký sử dụng driver cho cơ sở dữ liệu MYSQL
            Class.forName(DRIVER_NAME);
            //Mở kết nối tới CSDL theo driver đã chỉ định
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }catch (Exception e){
            System.out.println("Lỗi kết nối tới CSDL : " + e.getMessage());
        }
        return connection;
    }
}
