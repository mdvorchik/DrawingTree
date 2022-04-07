public class Main {
    public static void main(String[] args) {
        GraphMLParser graphMLParser = new GraphMLParser("full_binary_5.xml");
        BinaryTreeDrawer binaryTreeDrawer = new BinaryTreeDrawer(graphMLParser.getAllEdgesFromXMLFile());

        binaryTreeDrawer.drawTreeToFile("tree.png");
        System.out.println("Done!");
    }
}
