package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Driver;
import com.company.repositories.interfaces.IDriverRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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
public boolean createDriver(Driver driver){
Connection con = null;
try{
con = this.db.getConnection();
String sql = "INSERT INTO Drivers(id,name,surname,PhoneNumber,CarID) VALUES (?,?,?,?,?)";
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
public Driver getDriver(int id){
Connection con = null;
try{
con = this.db.getConnection();
String sql = "SELECT id,name,surname,PhoneNumber,CarID FROM Drivers WHERE id=?";
PreparedStatement st =con.prepareStatement(sql);
st.setInt(1,id);
    ResultSet resultSet =st.executeQuery();
if(!resultSet.next()){
return null;
}
Driver driver = new Driver(resultSet.getInt("id") , resultSet.getString("name") , resultSet.getString("surname") , resultSet.getString("PhoneNumber") , resultSet.getString("CarID"));

}
}
}
