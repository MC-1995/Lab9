package srp;

import java.time.LocalDateTime;
import java.util.List;

public class ReportManager {
    private final ReportCalculator calculator;
    private final ReportFormatter formatter;
    private final ReportStorage storage;

    public ReportManager(List<Integer> data) {
        this(new ReportCalculator(data), new ReportFormatter(), new FileReportStorage());
    }

    public ReportManager(ReportCalculator calculator,
                         ReportFormatter formatter,
                         ReportStorage storage) {
        this.calculator = calculator;
        this.formatter = formatter;
        this.storage = storage;
    }

    public void generateReport() {
        Report report = new Report(
                calculator.calculateSum(),
                calculator.calculateAverage(),
                LocalDateTime.now()
        );

        String content = formatter.format(report);
        System.out.print(content);
        storage.save(content);
    }
}