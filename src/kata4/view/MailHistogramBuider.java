package kata4.view;
import java.util.List;
import kata4.model.Mail;
import kata4.model.Histogram;

public class MailHistogramBuider {
    public static Histogram<String> build(List<String> mail){
        Histogram<String> histo = new Histogram<>();
        for (String mail1 : mail) {
            histo.increment(new Mail(mail1).getDomain());
        }
        return histo;
    }
}
