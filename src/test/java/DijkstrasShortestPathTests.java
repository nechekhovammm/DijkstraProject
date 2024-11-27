import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DijkstrasShortestPathTests {
    @Test
    public void testSingleNode() {
        DijkstrasShortestPath dsp = new DijkstrasShortestPath();
        dsp.addEdge("A", "A", 0);
        assertEquals(0, dsp.shortestPath("A", "A"));
    }

    @Test
    public void testSimpleGraph() {
        DijkstrasShortestPath dsp = new DijkstrasShortestPath();
        dsp.addEdge("A", "B", 1);
        dsp.addEdge("B", "C", 2);
        dsp.addEdge("A", "C", 4);

        assertEquals(3, dsp.shortestPath("A", "C"));
        assertEquals(-1, dsp.shortestPath("C", "A"));
    }
}
