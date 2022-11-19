class Solution 
{
    class pair implements Comparable<pair>{
        int x,y;
        pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    public int compareTo(pair p)
    {
        if(this.x==p.x)
        return this.y-p.y;
        return this.x-p.x;
    }
    }
    public boolean cw(int x1,int x2,int x3,int y1,int y2,int y3)
    {
        return x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)>0;
    }
    public boolean aw(int x1,int x2,int x3,int y1,int y2,int y3)
    {
        return x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)<0;
    }
    public boolean cl(int x1,int x2,int x3,int y1,int y2,int y3)
    {
        return x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)==0;
    }
    public int[][] outerTrees(int[][] trees) 
    {
       Arrays.sort(trees,(a,b)->(a[0]-b[0]==0?a[1]-b[1]:a[0]-b[0]));
       Stack<pair> up=new Stack<>();
       Stack<pair> dn=new Stack<>();
       up.push(new pair(trees[0][0],trees[0][1]));
       dn.push(new pair(trees[0][0],trees[0][1]));
       int sx=trees[0][0];
       int sy=trees[0][1];
       int ex=trees[trees.length-1][0];
       int ey=trees[trees.length-1][1];
       for(int i=1;i<trees.length;i++)
       {
           int x=trees[i][0];
           int y=trees[i][1];
           if(i==trees.length-1||!aw(sx,x,ex,sy,y,ey))
           {
               pair aux=up.pop();
               int axx=aux.x;
               int axy=aux.y;
               while(up.size()>=1&&aw(up.peek().x,axx,x,up.peek().y,axy,y))
               {
                   aux=up.pop();
                   axx=aux.x;
                   axy=aux.y;
               }
               up.push(aux);
               up.push(new pair(x,y));
           }
           if(i==trees.length-1||!cw(sx,x,ex,sy,y,ey))
           {
               pair aux=dn.pop();
               int axx=aux.x;
               int axy=aux.y;
               while(dn.size()>=1&&cw(dn.peek().x,axx,x,dn.peek().y,axy,y))
               {
                   aux=dn.pop();
                   axx=aux.x;
                   axy=aux.y;
               }
               dn.push(aux);
               dn.push(new pair(x,y));
           }
       }
       pair a[]=new pair[dn.size()+up.size()];
       int k=0;
       while(!dn.isEmpty())
       a[k++]=dn.pop();
       while(!up.isEmpty())
       a[k++]=up.pop();
       for(;k<a.length-1;)
       a[k++]=new pair(-1,-1);
       Arrays.sort(a);
       //for(int i=0;i<a.length;i++)
       //System.out.print(a[i].x+" "+a[i].y+" ");
       ArrayList<pair> arr=new ArrayList<>();
       int i=0;
       while(a[i].x==-1)
       i++;
       for(;i<a.length-1;i++)
       {
          if(a[i].x!=a[i+1].x)
          arr.add(a[i]);
          else if(a[i].y!=a[i+1].y)
          arr.add(a[i]);
       }
       arr.add(a[a.length-1]);
       int ans[][]=new int[arr.size()][2];
       for(int j=0;j<arr.size();j++)
       {
           ans[j][0]=arr.get(j).x;
           ans[j][1]=arr.get(j).y;
       }
       //System.out.println(a.length);
       return ans;
    }
}