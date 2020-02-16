package part2;

import java.util.List;

public abstract class ReportDecorator implements IReport {

    private IReport report;

    public ReportDecorator(IReport report) {
        this.report = report;
    }

    @Override
    public void output(List<ReportItem> items) {
        report.output(items);
    }
}
