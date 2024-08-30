import java.util.List;
import java.util.ArrayList;

class DFSImplementation {

    /*
     * Depth First Search with Adjacency Matrix
     */
    public static void dfs(boolean[][] adjMatrix) {
        int n = adjMatrix.length;
        if (n == 0)
        {
            System.out.println("No nodes in the given graph.");
            return;
        }

        boolean[] visited = new boolean[n];

        // Mark all nodes as false.
        for (int i=0; i<n; i++)
        {
            visited[i] = false;
        }

        int currentNode = 0;
        List<Integer> stack = new ArrayList<>();
        stack.add(0, currentNode);
        while(!stack.isEmpty())
        {
            currentNode = stack.get(0); 
            System.out.println(currentNode);
            visited[currentNode] = true;
            stack.remove(0);
            for (int j=0; j<n; j++)
            {
                if (currentNode != j && adjMatrix[currentNode][j] && !visited[j])
                {
                    stack.add(0, j);
                }
            }
        }

    }

    public static void main(String[] args) {
        boolean[][] adjMatrix = 
        {{false, true, false, false},
        {false, false, true, false},
        {true, false, false, true},
        {false, false, false, false}};

        dfs(adjMatrix);
    }
}