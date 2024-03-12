package sokoban_v4;

/**
 *
 * @author danie
 */

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameElement extends JLabel {
    public GameElement(String iconName) {
        setIcon(new ImageIcon(iconName));
    }
}
