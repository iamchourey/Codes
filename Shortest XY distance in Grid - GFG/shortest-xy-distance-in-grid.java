//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        // code here
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                if(grid.get(i).get(j)=='X') q.add(new int[]{i,j,0});
            }
        }
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        while(q.isEmpty()==false){
            int size=q.size();
            while(size-->0){
                int[] curr=q.poll();
                for(int[] dir:dirs){
                    int nx=curr[0]+dir[0];
                    int ny=curr[1]+dir[1];
                    if(nx>=0 && ny>=0 && nx<grid.size() && ny<grid.get(0).size() && grid.get(nx).get(ny)!='X'){
                        if(grid.get(nx).get(ny)=='Y') return curr[2]+1;
                        else q.add(new int[]{nx,ny,curr[2]+1});
                        grid.get(nx).set(ny,'X');
                    }
                }
            }
        }
        return -1;
    }
};