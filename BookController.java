/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Theory_JavaAdv;
/**
 *
 * @author xtir0
 */
import java.sql.*;

public class BookController {
    
    public ConnectSQL conn = new ConnectSQL();
    
    public BookController() {
        conn.Connect("DESKTOP-08KVPIP\\SQLEXPRESS", 1466, "sa", "1", "Java");
    }
    
    public ResultSet getAll() {
        String query = "select * from Book order by id asc";
        return conn.getData(query);
    }
    public ResultSet getById(int id) {
        String query = "select * from Book where id = '"+id+"'";
        return conn.getData(query);
    }

    public ResultSet getByUP(String username, String password) {
        String query = "select * from Users where username = '"+username+"' and password = '"+password+"'";
        return conn.getData(query); 
    }
    
    public ResultSet getByU(String username) {
        String query = "select * from Users where username = '"+username+"'";
        return conn.getData(query); 
    }
    
    public ResultSet getByBook(String masach) {
        String query = "select * from Book where masach = '"+masach+"'";
        return conn.getData(query);
    }
    
    public void insertUser(String username, String password) {
        String query = "insert into Users(username, password) values('"+username+"', '"+password+"')";
        conn.excute(query);
    }
    
    public void insertBook( String masach, String tensach, int gianhap, int giaban) {
        String query = "insert into Book(masach, tensach, gianhap, giaban) values('"+masach+"', '"+tensach+"', "+gianhap+", "+giaban+")";
        conn.excute(query);
    }       
    public void delete(int id) {
        String query = "delete from Book where id ='"+id+"'";
        conn.excute(query);
    }
    
    public void update(int id, String masach, String tensach, int gianhap, int giaban) {
        String query = "update Book set masach=N'"+masach+"', tensach= '"+tensach+"', gianhap= '"+gianhap+"', giaban= '"+giaban+"' where id='"+id+"'";
        conn.excute(query);
    }
    
    public int countRowAll() {
        int count = 0;
        try {
            ResultSet rs = getAll();
            while(rs.next()) {
                count++;
        }
        } catch (Exception e) {
        }
        return count;
    }
    
    public int countRowbyUP(String username, String password) {
        int count = 0;
        try {
            ResultSet rs = getByUP(username, password);
            while(rs.next()) {
                count++;
        }
        } catch (Exception e) {
        }
        return count;
    }
    
    public int countRowbyB(String masach) {
        int count = 0;
        try {
            ResultSet rs = getByBook(masach);
            while(rs.next()) {
                count++;
        }
        } catch (Exception e) {
        }
        return count;
    }
    public int countRowbyU(String username) {
        int count = 0;
        try {
            ResultSet rs = getByU(username);
            while(rs.next()) {
                count++;
        }
        } catch (Exception e) {
        }
        return count;
    }
}
