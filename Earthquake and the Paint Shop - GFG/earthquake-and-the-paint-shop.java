//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String s[] = new String[N];
            for (int i = 0; i < N; i++) s[i] = read.readLine();
            Solution ob = new Solution();
            alphanumeric ans[] = ob.sortedStrings(N, s);
            for (int i = 0; i < ans.length; i++)
                System.out.println(ans[i].name + " " + ans[i].count);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class alphanumeric {
    public String name;
    public int count;
    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
};
class Solution {
    alphanumeric[] sortedStrings(int N, String A[]) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:A) map.put(s,map.getOrDefault(s,0)+1);
        PriorityQueue<alphanumeric> pq=new PriorityQueue<>(new Comparator<alphanumeric>(){
            public int compare(alphanumeric a1,alphanumeric a2){
                return a1.name.compareTo(a2.name);
            }
        });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.add(new alphanumeric(entry.getKey(),entry.getValue()));
        }
        alphanumeric[] res=new alphanumeric[pq.size()];
        int index=0;
        while(pq.isEmpty()==false) res[index++]=pq.poll();
        return res;
    }
};