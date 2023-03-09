//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> result=new ArrayList<>();
        Node curr=head;
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        
        while(curr!=null){
            if(isAnagram(curr,new HashMap<>(map))){
                Node prev=null;
                result.add(curr);
                for(int i=0;i<s.length();i++){
                    prev=curr;
                    curr=curr.next;
                }
                prev.next=null;
            }
            else curr=curr.next;
        }
        return result;
    }
    public static boolean isAnagram(Node node,Map<Character,Integer> map){
        while(node!=null && map.isEmpty()==false){
            if(!map.containsKey(node.data)) return false;
            map.put(node.data,map.get(node.data)-1);
            if(map.get(node.data)==0) map.remove(node.data);
            node=node.next;
        }
        return map.isEmpty();
    }
}