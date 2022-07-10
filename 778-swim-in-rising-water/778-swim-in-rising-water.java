class Solution {
    
    class Node{
        int val;
        int x,y;
        
        public Node(int val,int x,int y){
            this.val=val;
            this.x=x;
            this.y=y;
        }
    }
    public int swimInWater(int[][] grid) {
        
        PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1,Node n2){
                return n1.val-n2.val;
            }
        });
        
        pq.add(new Node(grid[0][0],0,0));
        int time=0,n=grid.length;
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean visited[][]=new boolean[n][n];
        
        while(pq.isEmpty()==false){
            Node curr=pq.poll();
            time=Math.max(time,curr.val);
            visited[curr.x][curr.y]=true;
            
            if(curr.x==n-1 && curr.y==n-1) return time;
            
            for(int[] dir:dirs){
                int newX=curr.x+dir[0];
                int newY=curr.y+dir[1];
                
                if(newX>=0 && newY>=0 && newX<n && newY<n && visited[newX][newY]==false){
                    pq.add(new Node(grid[newX][newY],newX,newY));
                }
            }
        }
        
        return -1;
    }
}