package widget;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import usu.widget.glass.ViewPortGlass;

/**
 *
 * @author usu
 */
public class ScrollPane extends JScrollPane {

    private static final double DEFAULT_SCROLL_SPEED = 20.0; // Kecepatan scroll default yang lebih cepat
    private double scrollSpeed;

    public ScrollPane() {
        super();
        this.scrollSpeed = DEFAULT_SCROLL_SPEED;
        setViewport(new ViewPortGlass());
        setOpaque(false);
        setBorder(new LineBorder(new Color(239, 244, 234)));
        setBackground(new Color(255, 255, 255));
    }

    @Override
    protected void processMouseWheelEvent(MouseWheelEvent e) {
        if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
            JScrollBar verticalScrollBar = getVerticalScrollBar();
            int units = e.getUnitsToScroll();
            int direction = (units < 0) ? -1 : 1;
            int increment = (int) (scrollSpeed * direction * verticalScrollBar.getUnitIncrement());
            verticalScrollBar.setValue(verticalScrollBar.getValue() + increment);
            e.consume();
        } else {
            super.processMouseWheelEvent(e);
        }
    }

    public void setScrollSpeed(double scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
    }
}
