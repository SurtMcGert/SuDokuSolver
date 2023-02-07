/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.doku;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics extends JPanel {
    JFrame frame;
    private static Graphics graphicsInstance = null;

    public static Graphics getGraphicsInstance() {

        if (graphicsInstance == null) {

            graphicsInstance = new Graphics();

        }
        return graphicsInstance;
    }

    /**
     * paint method
     */
    @Override
    public void paint(java.awt.Graphics g) {

    }

    /**
     * constructor
     */
    private Graphics() {

        frame = new JFrame();
        frame.setBackground(Color.black);
        frame.add(this);

        frame.setSize(900, 700);

        // frame.setSize(sizeX, sizeY);
        // setting start position of the frame
        frame.setLocationRelativeTo(null);

        // closing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        frame.setTitle("console");

        frame.setBackground(Color.white);

        // set frame visibility
        frame.setVisible(true);

    }

}
