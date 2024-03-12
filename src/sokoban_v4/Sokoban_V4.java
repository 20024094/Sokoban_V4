package sokoban_v4;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class Sokoban_V4 extends JFrame {
    private static final int TILE_SIZE = 32; // Tile size is now 32px

    // Define characters for level elements
    private static final char WALL = 'W';
    private static final char FLOOR = 'F';
    private static final char DIAMOND = 'D';
    private static final char CRATE = 'C';
    private static final char PLAYER = 'P';
    
    char[][] level1 = {
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'D', 'C', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'W', 'W', 'F', 'W', 'F', 'F', 'C', 'F', 'W'},
            {'W', 'F', 'F', 'C', 'F', 'C', 'F', 'F', 'D', 'W'},
            {'W', 'D', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'W'},
            {'W', 'F', 'C', 'W', 'W', 'F', 'F', 'W', 'F', 'W'},
            {'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'D', 'F', 'F', 'F', 'C', 'F', 'P', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };

    public Sokoban_V4() {
        setTitle("Sokoban Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int rows = level1.length;
        int cols = level1[0].length;

        // Set the panel size based on the tile size and the number of tiles
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        panel.setPreferredSize(new Dimension(cols * TILE_SIZE, rows * TILE_SIZE));

        // Load and add tiles based on the level1 array
        for (char[] row : level1) {
            for (char tile : row) {
                panel.add(createTile(tile));
            }
        }

        // Add the panel to the frame and set the frame's size
        getContentPane().add(panel, BorderLayout.CENTER);
        setPreferredSize(new Dimension(325, 325)); // Set the preferred size of the frame
        setResizable(false); // Make the frame non-resizable

        // Pack the components within the window based on their preferred sizes
        pack();

        // Manually set the size of the window to account for window borders
        setSize(325 + getInsets().left + getInsets().right,
                325 + getInsets().top + getInsets().bottom);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Display the window
        setVisible(true);
    }

    private JLabel createTile(char tileType) {
        String fileName = "";
        switch (tileType) {
            case WALL:
                fileName = "src/sokoban_v4/graphics/Wall.png";
                break;
            case FLOOR:
                fileName = "src/sokoban_v4/graphics/Floor.png";
                break;
            case DIAMOND:
                fileName = "src/sokoban_v4/graphics/Diamond.png";
                break;
            case CRATE:
                fileName = "src/sokoban_v4/graphics/Crate.png";
                break;
            case PLAYER:
                fileName = "src/sokoban_v4/graphics/WarehouseKeeper.png";
                break;
            // Add other cases as necessary
        }
        // Assuming GameElement extends JLabel and sets the icon based on the provided file path
        return new GameElement(fileName);
    }

    public static void main(String[] args) {
        // Run the application
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Sokoban_V4();
            }
        });
    }
}

