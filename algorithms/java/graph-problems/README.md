# Graph Problems

## Ways to represent graphs
- Adjacency List: List of Lists. 
[0] -> [1], [2], [3]
[1] -> [3]

- Adjacency Matrix: nxn 2-D array where a[i][j] is true is there is an edge between vertices i and j.

## Common Algorithms

### Depth First Search
Pseudocode:
edge conditions:
If graph is empty

pick an unvisited vertex A
push A onto stack S
1. pop S -> A
2. mark A as visited -> print A
3. For each unvisited neighbour of A : U
4. Push U onto stack
5. Repeat steps 1-4 until S is empty


### Breadth First Search
### Topological Search
### Djikstras Algorithm



