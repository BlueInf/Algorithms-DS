public class MinTree {

    static Tree tree = new Tree(24,
            new Tree(-3,
                    null,
                    new Tree(67, null, null)),
            new Tree(0,
                    new Tree(99, null, null),
                    new Tree(-1, null, null)));

    public static void main(String[] args) {
        MinTree mt = new MinTree();
        System.out.println("Minimum is :" + mt.findMin(tree));
        System.out.println("Maximum is :" + mt.findMax(tree, Integer.MIN_VALUE));
    }

    /**
     * Recursive findMin in a tree structure
     * First way
     * Using only one the node
     * @param tree
     * @return
     */
    public int findMin(Tree tree) {

        if (tree==null) return Integer.MAX_VALUE;

        int result=tree.getVal();
        int leftBranchResult=findMin(tree.left());
        int rightBranchResult=findMin(tree.right());

        if(leftBranchResult<result){
            result=leftBranchResult;
        }
        else if(rightBranchResult<result) result=rightBranchResult;

        return result;

    }


    /**
     * Recursive findMax in a tree structure
     * 2nd Way of recursion for traversing through a Tree Structure
     * @param tree
     * @param max
     * @return
     */
    public int findMax(Tree tree, int max) {

        if (max < tree.getVal()) max = tree.getVal();

        if (tree.left() != null) {
            if (max < findMax(tree.left(), max)) max=findMax(tree.left(),max);

        }

        if (tree.right() != null) {

            if (max < findMax(tree.right(), max)) max=findMax(tree.right(), max);
        }

        return max;

    }
}

class Tree {

    private int val;
    private Tree left, right;

    public Tree(int val, Tree left, Tree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public Tree left() {
        return left;
    }

    public Tree right() {
        return right;
    }
}
