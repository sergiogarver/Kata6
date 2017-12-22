package kata6.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuider;
import kata6.view.MailListReader;


public class Kata6 {
    private String nameFile;
    private List<Mail> listMail;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    private MailHistogramBuider<Mail> builder;
    public static void main(String[] args) throws IOException {
        Kata6 kata6 = new Kata6();
        kata6.execute();      
    }
    public void execute() throws FileNotFoundException, IOException{
        input();
        process();
        output();
    }
    
    public void input() throws FileNotFoundException, IOException{
        nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata6\\emailsFile.txt";
        listMail = MailListReader.read(nameFile);
    
    }
    
    public void process(){
        builder = new MailHistogramBuider<>(listMail);
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
        
    }
    
    public void output(){
        new HistogramDisplay(domains,"Dominios").execute();
        new HistogramDisplay(letters,"Primer Caracter").execute();
    }

    
}
