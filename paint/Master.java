package scripts.SPXAIOMiner.paint;


import java.awt.*;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class Master {

    public PaintManager paintManager;

    public Master(PaintManager paintManager) {
        this.paintManager = paintManager;
    }

    //<editor-fold defaultstate="collapsed" desc="Draw Master Info">
    public void drawMasterInfo(Graphics g) {
        g.drawString("Master Trades: " + paintManager.getMuleTrades(), 282, 348);
        g.drawString("Master Trades P/H: " + paintManager.getMasterTradesHr(), 282, 374);
        g.drawString(" ", 282, 450);
    }
    //</editor-fold>

}