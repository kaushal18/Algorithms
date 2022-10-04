class DSU {
  // id of parent
  int[] parent;
  // size of set at index i
  int[] rank;
  int numComponents;

  // maximum of the component/set
  int[] max;
  // minimum of the component/set
  int[] min;

  public DSU(int n) {
    this.parent = new int[n];
    this.rank = new int[n];
    for(int i=0; i<n; i++) {
      // each node will be in its own set --> denoted by self loop
      parent[i] = i;
      // each set will be of size 1
      rank[i] = 1;

      max[i] = i;
      min[i] = i;
    }

    numComponents = n;
  }
    
  // Find the root of the component/set
  public int find(int p) {
    int root = p;
    // while we dont find root of set (root will have self node) move upwards
    while (parent[root] != root) {
      root = parent[root];
    }

    // Compress the path leading back to the root.
    // Doing this operation is called "path compression"
    // and is what gives us amortized time complexity.
    while (p != root) {
      int next = parent[p];
      parent[p] = root;
      p = next;
    }
    return root;
  }

  // Return whether or not the elements 'p' and
  // 'q' are in the same components/set.
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  // Return the size of the components/set 'p' belongs to
  public int componentSize(int p) {
    return rank[find(p)];
  }

  // Unify the components/sets containing elements 'p' and 'q'
  public void unify(int p, int q) {
    int root1 = find(p);
    int root2 = find(q);

    // elements are already connected
    if(root1 == root2) {
      return;
    }

    // Merge smaller component/set into the larger one.
    if (rank[root1] < rank[root2]) {
      // new set will have root2 as top parent
      rank[root2] += rank[root1];
      // point root1 to root2
      parent[root1] = root2;
      rank[root1] = 0;

      // update root2 min and max arrays
      min[root2] = Math.min(min[root1], min[root2]);
      max[root2] = Math.max(max[root1], max[root2]);
    } else {
      rank[root1] += rank[root2];
      parent[root2] = root1;
      rank[root2] = 0;

      min[root1] = Math.min(min[root1], min[root2]);
      max[root1] = Math.max(max[root1], max[root2]);
    }

    // Since the roots found are different we know that the
    // number of components/sets has decreased by one
    numComponents--;
  }
}