/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.model;

/**
 *
 * @author usuario
 */
public class Person {
    private int id;
    private String name;
    private Character gender;
    private String birthDate;
    private float weigth;
    private String mail;
    
    public Person(int id,String name,Character gender,String birthdate,float weigth,String mail){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.birthDate=birthdate;
        this.weigth=weigth;
        this.mail=mail;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Character getGenero(){
        return this.gender;
    }
    
    public String getBirthDate(){
        return this.birthDate;
    }
    
    public float getWeigth(){
        return this.weigth;
    }
    
    public String getMail(){
        return this.mail;
    }
    
    
    
    
    
    
}
