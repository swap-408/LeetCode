class Solution {
    private Map<Node, Node> mp = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (mp.containsKey(node)) return mp.get(node);

        Node clone = new Node(node.val);
        mp.put(node, clone);

        for (Node nei : node.neighbors) {
            clone.neighbors.add(dfs(nei));
        }

        return clone;
    }
}