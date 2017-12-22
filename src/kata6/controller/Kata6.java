package kata6.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuider;
import kata6.view.MailListReader;


public class Kata6 {
    private String nameFile;
    private List<Mail> listMail;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    private MailHistogramBuider<Mail> builder;
    private List<Person> people;
    private MailHistogramBuider<Person> builderPerson;
    private Histogram<Character> gender;
    private Histogram<Float> peso;
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        
        Kata6 kata6 = new Kata6();
        kata6.execute();      
    }
    public void execute() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        input();
        process();
        output();
    }
    
    public void input() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        people= DataBaseList.read();
        nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata6\\emailsFile.txt";
        listMail = MailListReader.read(nameFile);

    
    }
    
    public void process(){
        builder = new MailHistogramBuider<>(listMail);
        builderPerson= new MailHistogramBuider<>(people);
        
        domains = builder.build(new Attribute<Mail,String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
    
    
        });
        
        letters= builder.build(new Attribute<Mail,Character>(){
            @Override
            public Character get(Mail item){
                return item.getMail().charAt(0);
            }
        });
        
        gender = builderPerson.build(new Attribute<Person,Character>(){
            @Override
            public Character get (Person item){
                return item.getGenero();
            }
        });
        peso = builderPerson.build(new Attribute<Person,Float>(){
            @Override
            public Float get (Person item){
                return item.getWeigth();
            }
        });
        
    }
    
    public void output(){
        new HistogramDisplay(domains,"Dominios").execute();
        new HistogramDisplay(letters,"Primer Caracter").execute();
        new HistogramDisplay(gender,"Gender").execute();
        new HistogramDisplay(peso,"Peso").execute();
    }

    
}
