package org.mipt.drawer;

import com.tinkerpop.blueprints.Vertex;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//        JOptionPane.showMessageDialog(null, "Custom class demo");
//        JFrame myFrame = new JFrame();
//        myFrame.setSize(1024, 1024);
//        myFrame.setVisible(true);
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
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(new FileOutputStream(new File("tree.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        outFile.println();
    }
}
