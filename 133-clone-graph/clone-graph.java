/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node node, Node copy, Node[] visited){
        visited[copy.val] = copy; //copy is our current node so we are storing it at the index corresponding to its value so it can be marked as visited
        for(Node n:node.neighbors){
            if(visited[n.val]==null){
                //if not visited
                Node newNode = new Node(n.val); //create new node
                copy.neighbors.add(newNode); //add new node to neighbors of the copied node, ie, our current node
                dfs(n,newNode,visited); //check adjacent nodes
            }
            else{
                //if already visited
                copy.neighbors.add(visited[n.val]); //wecan access the neighbors of our copied node from the visited array
            }
        }
    }
    public Node cloneGraph(Node node) {
       if(node == null) {
           return null; //there is nothing to copy
       }
       Node copy = new Node(node.val); //copy of node
       Node[] visited = new Node[101]; //Rather than just tracking which node has been visited, this array stores all neighbors of visited nodes. Also, 101 because of given constraints
       Arrays.fill(visited, null);

       dfs(node, copy, visited);

       return copy;
    }
}