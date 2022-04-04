import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;

import java.io.InputStream;

public class GraphMLParser {
    private static final String XML_FILE = "full_binary_5.xml";

    public static void main(String[] args) throws Exception {
        Graph graph = new TinkerGraph();
        GraphMLReader reader = new GraphMLReader(graph);

        InputStream is = GraphMLParser.class.getClassLoader().getResourceAsStream(XML_FILE);
        reader.inputGraph(is);

        Iterable<Vertex> vertices = graph.getVertices();

        for (Vertex vertex : vertices) {
            Iterable<Edge> edges = vertex.getEdges(Direction.IN);
            for (Edge edge : edges) {
                Vertex outVertex = edge.getVertex(Direction.OUT);
                Vertex inVertex = edge.getVertex(Direction.IN);
            }
        }

        System.out.println("End work");
    }
}
