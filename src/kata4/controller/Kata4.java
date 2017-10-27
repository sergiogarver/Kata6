package kata4.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuider;
import kata4.view.MailListReader;

public class Kata4 {
    private List<String> mailList;
    private String filename;
    private Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException {
        Kata4 kata4 = new Kata4();
        kata4.execute();      
    }
    public void execute() throws FileNotFoundException, IOException{
        input();
        process();
        output();
    }
    
    public void input() throws FileNotFoundException, IOException{
        filename = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\emailsFile.txt";
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
