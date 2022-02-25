class Solution {
    public int compareVersion(String version1, String version2) {
        
        ArrayList<Integer> ls1=new ArrayList<>();
        ArrayList<Integer> ls2=new ArrayList<>();
        
        for(int i=0;i<version1.length();){
            
            if(version1.charAt(i)=='.'){
                i++;
                continue;
            }
            
            int version=0;
            while(i<version1.length() && version1.charAt(i)!='.'){
                version=version*10+version1.charAt(i)-'0';
                i++;
            }
            ls1.add(version);
            version=0;
        }
        
        for(int i=0;i<version2.length();){
            
            if(version2.charAt(i)=='.'){
                i++;
                continue;
            }
            
            int version=0;
            while(i<version2.length() && version2.charAt(i)!='.'){
                version=version*10+version2.charAt(i)-'0';
                i++;
            }
            ls2.add(version);
            version=0;
        }
        int i=0;
        for(i=0;i<ls1.size() && i<ls2.size() ;i++){
            if(ls1.get(i)==ls2.get(i))
                continue;
            if(ls1.get(i)>ls2.get(i))
                return 1;
            else
                return -1;
        }
        
        while(i<ls1.size()){
            if(ls1.get(i)>0)
                return 1;
            i++;
        }
        
        while(i<ls2.size()){
            if(ls2.get(i)>0)
                return -1;
            i++;
        }
        return 0;
    }
}