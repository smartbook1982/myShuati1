class Solution {
  // BFS
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map <Integer, List<Integer>> pidMap = new HashMap<>();
        
        List<Integer> res = new ArrayList<>();
        
        for (int i=0; i<pid.size(); i++) {
            int child = pid.get(i);
            int parent = ppid.get(i);
            pidMap.putIfAbsent (parent, new ArrayList<>());
            pidMap.get(parent).add (child);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add (kill);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            res.add (p);
            List<Integer> children = pidMap.get(p) == null ? new ArrayList<>() : pidMap.get(p);
            for (int child : children) {
                queue.add (child);
            }
        }
        
        return res;
        
    }
}
