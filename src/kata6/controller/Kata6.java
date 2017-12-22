package kata6.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuider;
import kata6.view.MailListReader;

public class Kata6 {
    private List<String> mailList;
    private String filename;
    private Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException {
        Kata6 kata4 = new Kata6();
        kata4.execute();      
    }
    public void execute() throws FileNotFoundException, IOException{
        input();
        process();
        output();
    }
    
    public void input() throws FileNotFoundException, IOException{
        filename = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata6\\emailsFile.txt";
        mailList = MailListReader.read(filename);
    
    }
    
    public void process(){
        histogram = MailHistogramBuider.build(mailList);
    }
    
    public void output(){
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();      
    }

    
}
