package com.company.repositories;
//package name com.company
import com.company.data.interfaces.IDB;
//import IDB class
import com.company.entities.Driver;
//import Driver class
import com.company.repositories.interfaces.IDriverRepository;
//import IDriverRepository
import java.sql.*;
//import java.sql
import java.util.List;
//import ArrayList
import java.util.ArrayList;
//import util.List
public class DriverRepo implements IDriverRepository {
private final IDB db;
public DriverRepo(IDB db){
    this.db = db;
}
/*    private int id;
    private String name;
    private String surname;
    private String PhoneNumber;
    private int CarID;*/
@Override
public boolean createDriver(Driver driver){
    //Connection SQL
Connection con = null;
//try/catch exception of insert to our DB
try{
    //Connection SQL
con = this.db.getConnection();
//Insert our values
String sql = "INSERT INTO driver(id,name,surname,phonenumber,carid) VALUES (?,?,?,?,?)";
PreparedStatement st = con.prepareStatement(sql);
st.setInt(1,driver.getId());
st.setString(2,driver.getName());
st.setString(3,driver.getSurname());
st.setString(4,driver.getPhoneNumber());
st.setInt(5,driver.getCarID());
boolean executed =st.execute();
return executed;
} catch (SQLException e){
 e.printStackTrace();
} catch (ClassNotFoundException d){
 d.printStackTrace();
} finally {
    try{
con.close();
    } catch (SQLException f){
f.printStackTrace();
    }
}
return false;
}
    //@Override tells the compiler
        @Override
        public Driver getDriver(int id){
            //Connection to SQL
        Connection con = null;
        try{
            //db get connection
            con = db.getConnection();
            //SELECT id which contain
            String sql = "SELECT id,name,surname,PhoneNumber,CarID FROM driver WHERE id=?";
            PreparedStatement st =con.prepareStatement(sql);
            st.setInt(1,id);
                ResultSet resultSet =st.executeQuery();
            if(resultSet.next()){
                Driver driver = new Driver(resultSet.getInt("id") ,
                        resultSet.getString("name") ,
                        resultSet.getString("surname") ,
                        resultSet.getString("PhoneNumber") ,
                        resultSet.getInt("CarID"));
        
            return driver;
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
        }
        
        @Override
        public List<Driver> getAllDrivers(){
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "SELECT id,name,surname,PhoneNumber,CarID FROM driver";
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);
                List<Driver> drivers = new ArrayList<>();
                while (rs.next()){
                    Driver driver = new Driver(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("PhoneNumber"),
                            rs.getInt("CarID"));
                    drivers.add(driver);
                }
                return drivers;
            } catch (SQLException throwables){
                throwables.printStackTrace();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            } finally {
                try{
                    con.close();
                } catch (SQLException throwables){
                    throwables.printStackTrace();
                }
            }
            return null;
        }
}
