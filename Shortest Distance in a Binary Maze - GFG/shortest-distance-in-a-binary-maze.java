//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    class Pair{
        int x,y,dist;
        public Pair(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int m=grid.length,n=grid[0].length;
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(source[0],source[1],0));
        grid[source[0]][source[1]]=0;
        int result=Integer.MAX_VALUE;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        
        while(queue.isEmpty()==false){
            int size=queue.size();
            while(size-->0){
                Pair p=queue.poll();
                if(destination[0]==p.x && destination[1]==p.y){
                    result=Math.min(result,p.dist);
                    break;
                }
                for(int[] dir:dirs){
                    int newx=p.x+dir[0];
                    int newy=p.y+dir[1];
                    
                    if(newx>=0 && newy>=0 && newx<m && newy<n && grid[newx][newy]==1){
                        queue.add(new Pair(newx,newy,p.dist+1));
                        grid[newx][newy]=0;
                    }
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
