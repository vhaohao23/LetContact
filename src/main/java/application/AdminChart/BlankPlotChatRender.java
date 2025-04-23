package application.AdminChart;

import application.raven.chart.blankchart.BlankPlotChart;
import application.raven.chart.blankchart.SeriesSize;
import java.awt.Graphics2D;

public abstract class BlankPlotChatRender {

    public abstract String getLabelText(int index);

    public abstract void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);
}
