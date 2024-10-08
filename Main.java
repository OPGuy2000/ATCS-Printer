import java.awt.print.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        Queue<StringPrinter> printerQueue = new Queue<>();

        boolean doPrint = printerJob.printDialog();

        System.out.println("Enter info in the format: {String} {x} {y} (EXIT to leave)");
        String input = scanner.nextLine();
        while (input != "EXIT") {
            String[] arr = input.split(" ", 3);
            String s = arr[0];
            int x = Integer.parseInt(arr[1]);
            int y = Integer.parseInt(arr[2]);

            printerQueue.offer(new StringPrinter(s, x, y));

            System.out.println("Enter info in the format: {String} {x} {y} (EXIT to leave)");
            input = scanner.nextLine();
        }
        scanner.close();

        if (doPrint) {
            try {
                while (printerQueue.peek() != null) {
                    printerJob.setPrintable(printerQueue.poll());
                    printerJob.print();
                }
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }

        
    }
}
