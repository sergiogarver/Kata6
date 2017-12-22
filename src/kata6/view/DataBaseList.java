/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.view;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kata6.model.Mail;
import kata6.model.Person;

/**
 *
 * @author usuario
 */
public class DataBaseList {
    public static List<Person> read() throws ClassNotFoundException,SQLException{
    
    List<Person> listPerson = new ArrayList<>();
    Class.forName("org.sqlite.JDBC");
    Connection connec = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
    
    Statement st = connec.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM PEOPLE;");
    
    while(rs.next()){
        int id=rs.getInt(1);
        String name=rs.getString(2);
        Character genero=rs.getString(3).charAt(0);
        String fechaNacimiento=rs.getString(4);
        float peso = rs.getFloat(5);
        String mail = rs.getString(6);
        listPerson.add(new Person(id, name, genero, fechaNacimiento, peso, mail));      
    
    }
    return listPerson;
    
    
    }
    
}
