class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for(int i=0;i<paths.length;i++) {
            populate(paths[i], map);
        }
        for (List<String> entry : map.values()) {
            if(entry.size() > 1)
                res.add(entry);
        } 
        return res;
    }
    
    public void populate(String path, Map<String, List<String>> map) {
        String[] info = path.split(" ");
        String dir = info[0];
        
        for(int i=1;i<info.length;i++) {
            int in1 = info[i].indexOf("(");
            String data = info[i].substring(in1+1, info[i].length() - 1);
            
            List<String> paths = map.get(data);
            if(paths == null) {
                paths = new ArrayList<>();
            }
            paths.add(dir+"/"+info[i].substring(0, in1));
            map.put(data, paths);
        }
    }
}