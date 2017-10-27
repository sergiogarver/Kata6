package kata4.controller;
import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuider;
import kata4.view.MailListReader;

public class Kata4 {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\emailsFile.txt";
        List<String> mailList = MailListReader.read(filename);
        Histogram<String> histogram = MailHistogramBuider.build(mailList);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();        

    }

    
}
