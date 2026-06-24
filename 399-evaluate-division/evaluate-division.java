class Solution {
    public class Pair{
        String name;
        double val;
        public Pair(String name, double val){
            this.name = name;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            Double w = values[i];
            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());
            
            graph.get(u).add(new Pair(v,w));
            graph.get(v).add(new Pair(u,1/w));
        }
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if(!graph.keySet().contains(src) || !graph.keySet().contains(dest))
            {res[i] = -1;continue;}

            if(src.equals(dest)){res[i] = 1;continue;}

            res[i] = bfs(graph,src,dest);
        }
        return res;
    }

    public double bfs(HashMap<String,List<Pair>> graph, String u, String v){
        Queue<Pair> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(new Pair(u,1.0));
        visited.add(u);
        while(!q.isEmpty()){
            Pair cur = q.poll();
            String curr = cur.name;

            if(curr.equals(v)) return cur.val;
            for(Pair p: graph.get(curr)){
                if(!visited.contains(p.name)){
                    visited.add(p.name);
                    q.offer(new Pair(p.name,cur.val*p.val));
                }
            }
        }

        return -1;
    }
}