package kata6.view;
import java.util.List;
import kata6.controller.Attribute;
import kata6.model.Mail;
import kata6.model.Histogram;

public class MailHistogramBuider<T> {

    private final List <T> items;
    public MailHistogramBuider (List <T> items){
        this.items=items;
    }
    public <A>Histogram<A> build(Attribute <T,A> attribute){
        Histogram<A> histo = new Histogram<>();
        for (T item : items) {
            A value = attribute.get(item);
            histo.increment(value);
        }
        return histo;
    }
}
