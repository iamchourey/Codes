// { Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        // code here
        int count[]=new int[26];
        for(char c:arr.toCharArray()){
            count[c-'a']++;
        }
        
        for(int i=1;i<26;i++){
            count[i]=count[i-1]+count[i];
        }
        char output[]=new char[arr.length()];
        
        for(int i=arr.length()-1;i>=0;i--){
            output[count[arr.charAt(i)-'a']-1]=arr.charAt(i);
            count[arr.charAt(i)-'a']--;
        }
        
        return new String(output);
    }
}