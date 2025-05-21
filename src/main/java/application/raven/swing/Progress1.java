
package application.raven.swing;

import javax.swing.Icon;
import javax.swing.JProgressBar;


public class Progress1 extends JProgressBar {

    public ProgressType getProgressType() {
        return progressType;
    }
    
    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
        repaint();
    }

    private ProgressType progressType = ProgressType.NON;
    
    public Progress1() {
        setOpaque(false);
        setUI(new ProgressCircleUI1(this));
    }
    
    public static enum ProgressType {
        NON, DOWN_FILE, CANCEL, FILE
    }
}