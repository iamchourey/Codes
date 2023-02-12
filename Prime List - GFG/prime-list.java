//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    Node primeList(Node head){
        //code here
        
        Node curr=head;
        while(curr!=null){
            int val=curr.val;
            if(isPrime(val)==false){
                curr.val=getNearestPrime(val);
            }
            curr=curr.next;
        }
        return head;
    }
    public boolean isPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5;i<=Math.sqrt(n);i+=6){
            if(n%i==0 || n%(i+2)==0) return false;
        }
        return true;
    }
    public int getNearestPrime(int val){
        if(val==1) return 2;
        int left=val,right=val;
        while(left>1 && right<=val*val){
            left--;
            if(isPrime(left)) return left;
            right++;
            if(isPrime(right)) return right;
        }
        return 0;
    }
}