package kata6.view;
import java.util.List;
import kata6.model.Mail;
import kata6.model.Histogram;

public class MailHistogramBuider {
    public static Histogram<String> build(List<String> mail){
        Histogram<String> histo = new Histogram<>();
        for (String mail1 : mail) {
            histo.increment(new Mail(mail1).getDomain());
        }
        return histo;
    }
}
