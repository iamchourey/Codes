//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    class Trie{
        TreeSet<String> set;
        Trie[] children;
        public Trie(){
            this.set=new TreeSet<>();
            this.children=new Trie[26];
        }
    }
    public void addToTrie(String word,Trie root){
        Trie curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null) curr.children[c-'a']=new Trie();
            curr=curr.children[c-'a'];
            curr.set.add(word);
        }
    }
    public Set<String> getContacts(String prefix,Trie root){
        Trie curr=root;
        for(char c:prefix.toCharArray()){
            if(curr.children[c-'a']==null) return new TreeSet<>();
            curr=curr.children[c-'a'];
        }
        return curr.set;
    }
    ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        
        Trie root=new Trie();
        for(String word:contact) addToTrie(word,root);
        
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        String prefix="";
        for(char c:s.toCharArray()){
            prefix+=c;
            Set<String> set=getContacts(prefix,root);
            if(set.size()!=0) res.add(new ArrayList<>(set));
            else{
                ArrayList<String> temp=new ArrayList<>();
                temp.add("0");
                res.add(temp);
            }
        }
        return res;
    }
}