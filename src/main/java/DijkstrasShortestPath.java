import java.util.*;

public class DijkstrasShortestPath {
    private final Map<String, Map<String, Integer>> graph;

    public DijkstrasShortestPath() {
        this.graph = new HashMap<>();
    }

    public void addEdge(String source, String target, int weight) {
        graph.putIfAbsent(source, new HashMap<>());
        graph.get(source).put(target, weight);
    }

    public int shortestPath(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Set<String> visited = new HashSet<>();

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (!visited.add(current)) continue;

            for (Map.Entry<String, Integer> neighbor : graph.getOrDefault(current, Collections.emptyMap()).entrySet()) {
                int newDist = distances.get(current) + neighbor.getValue();
                if (newDist < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDist);
                    queue.add(neighbor.getKey());
                }
            }
        }

        return distances.getOrDefault(end, -1);
    }
}
