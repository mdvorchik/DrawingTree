package org.mipt.drawer;

import com.tinkerpop.blueprints.Vertex;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputStream is = GraphMLParser.class.getClassLoader().getResourceAsStream("full_binary_5.xml");
        if (args.length > 0) {
            try {
                is = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        GraphMLParser graphMLParser = new GraphMLParser(is);
        Vertex rootVertex = graphMLParser.getRootVertex();
        BinaryTreeDrawer binaryTreeDrawer = new BinaryTreeDrawer(rootVertex);

        binaryTreeDrawer.drawTreeToFile("tree.png");
        String s = args.length > 0 ? args[0] : "";
        System.out.println("Done! " + s);

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
            }

            ImageIcon icon = new ImageIcon("tree.png");
            JOptionPane.showMessageDialog(
                    null,
                    "Hello world",
                    "Hello", JOptionPane.INFORMATION_MESSAGE,
                    icon);
            JOptionPane.showMessageDialog(
                    null,
                    new JLabel("Hello world", icon, JLabel.LEFT),
                    "Hello", JOptionPane.INFORMATION_MESSAGE);

        });
    }
}
