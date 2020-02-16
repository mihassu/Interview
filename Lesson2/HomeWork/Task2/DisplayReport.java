package part2;

import java.util.List;

public class DisplayReport extends ReportDecorator {

    public DisplayReport(IReport report) {
        super(report);
    }

    public void output(List<ReportItem> items){
        super.output(items);
        System.out.println("Output to display");
        for(ReportItem item : items){
            System.out.format("Display %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
