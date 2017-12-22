package kata6.view;
import kata6.model.Histogram;
import java.awt.Dimension;
import org.jfree.ui.ApplicationFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.lang.String;
public class HistogramDisplay <T> extends ApplicationFrame {
    
    private final Histogram<T> histogram;
    private final String nameEjeX;
    public HistogramDisplay(Histogram<T> histogram,String nameEjeX){
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.nameEjeX=nameEjeX;
        setContentPane(createPanel());
        pack();
    }
    
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        setPreferredSize(new Dimension(500,400));
        return chartPanel;
        
    }
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", "Dominios email", "Nº de emails", dataSet, PlotOrientation.VERTICAL, 
                                         false, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "",(Comparable) key);
        }
        return dataSet;
        
    }
    
}
