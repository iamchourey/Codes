class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        float temp=0,temp2=0;
        if(coordinates[1][0]-coordinates[0][0]==0)
            temp=-111111;
        else
            temp=((float)(coordinates[1][1]-coordinates[0][1])/
                  (float)(coordinates[1][0]-coordinates[0][0]));
        
        for(int i=1;i<coordinates.length-1;i++)
        {
            if(coordinates[i+1][0]-coordinates[i][0]==0)
                 temp2=-111111;
            else
             temp2=((float)(coordinates[i+1][1]-coordinates[i][1])/
                  (float)(coordinates[i+1][0]-coordinates[i][0]));
            
            
            if(temp2!=temp)
                return false;
        }
        
        return true;
    }
}