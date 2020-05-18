1：前序遍历
public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) {
        list.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        list.addAll(right);
        }
        return list;
        }
        2：中序遍历
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) {
        List<Integer> left = inorderTraversal(root.left);
        list.addAll(left);
        list.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        list.addAll(right);
        }
        return list;
        }

        3：后续遍历
public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        list.addAll(left);
        list.addAll(right);
        list.add(root.val);
        }

        return list;
        }

        4.检查两颗树是否相同
public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (p != null && q== null) )
        return false;
        if(p == null && q == null)
        return true;
        if(p.val != q.val)
        return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

        }
        5、另一个树的子树
public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (p != null && q== null) )
        return false;
        if(p == null && q == null)
        return true;
        if(p.val != q.val)
        return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

        }
public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;
        //前序遍历
        if(isSameTree(s, t)) return true;
        //t是否是s左树的子树
        if(isSubtree(s.left, t)) return true;
        //t是否是s右树的子树
        if(isSubtree(s.right, t))return true;
        return false;
        }

        6、二叉树的最大深度
public int maxDepth(TreeNode root) {
        if (root == null) {
        return 0;
        } else {
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right ? left : right) + 1;
        }
        }
        7、前序遍历的解法
public boolean isBalanced(Node root) {
        if(root == null) {
        return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight-rightHeight) < 2
        && isBalanced(root.left)
        && isBalanced(root.right);
        //当root为平衡树之后，需要再去判断root.left
        和 right是否是平衡树，所以加了并且;
        }
        8、对称二叉树
public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree != null || leftTree!=null && rightTree==null){
        return false;
        }
        if(leftTree == null && rightTree == null) {
        return true;
        }
        if(leftTree.val != rightTree.val) {
        return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right) && isSymmetricChild(leftTree.right,rightTree.left);
        }

public boolean isSymmetric(TreeNode root) {
        if(root == null) {
        return true;
        }
        return isSymmetricChild(root.left,root.right);
        }

