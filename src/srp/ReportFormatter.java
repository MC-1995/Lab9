package srp;

public class ReportFormatter {
    public String format(Report report) {
        return "=== Report ===\n" +
                "Sum: " + report.sum() + "\n" +
                "Average: " + report.average() + "\n" +
                "Generated at: " + report.generatedAt() + "\n";
    }
}