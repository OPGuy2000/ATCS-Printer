import java.awt.print.*;

public class Main {
    public static void main(String[] args) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(new TestPrinter());
        boolean doPrint = printerJob.printDialog();

        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
}
