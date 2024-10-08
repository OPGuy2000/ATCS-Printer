import java.awt.print.*;
import java.awt.*;

public class StringPrinter implements Printable {
  String s;
  int x;
  int y;

  public StringPrinter(String s, int x, int y) {
    this.s = s;
    this.x = x;
    this.y = y;
  }

  public int print(Graphics g, PageFormat pf, int page)
      throws PrinterException {

    // We have only one page, and 'page'
    // is zero-based
    if (page > 0) {
         return NO_SUCH_PAGE;
    }

    // User (0,0) is typically outside the
    // imageable area, so we must translate
    // by the X and Y values in the PageFormat
    // to avoid clipping.
    Graphics2D g2d = (Graphics2D)g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    // Now we perform our rendering
    g.drawString(s, x, y);

    // tell the caller that this page is part
    // of the printed document
    return PAGE_EXISTS;
  }
}
