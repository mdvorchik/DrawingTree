import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GraphMLParser {
    private Graph graph;

    public GraphMLParser(String xmlFileName) {
        this.graph = new TinkerGraph();
        GraphMLReader reader = new GraphMLReader(graph);
        InputStream is = GraphMLParser.class.getClassLoader().getResourceAsStream(xmlFileName);

        try {
            reader.inputGraph(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Edge> getAllEdgesFromXMLFile() {
        List<Edge> edges = new ArrayList<>();

        for (Edge edge : graph.getEdges()) {
            edges.add(edge);
        }

        return edges;
    }
}
