import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-05-15
 * Time: 19:43
 */
class Node {
    public char val;
    public Node left;//左孩子-》左子树
    public Node right;//右孩子-》右子树
    public Node(char val) {
        this.val = val;
    }
}
class BinaryTree {

    /*public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        //E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
*/
    int i = 0;
    public Node buildTree(String str) {
        Node root = null;
        if(str.charAt(i) != '#') {
            root = new Node(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }else {
            i++;
        }
        return root;
    }
    // 前序遍历   递归来实现
    void preOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    // 遍历思路-求结点个数   前序遍历
    static int size = 0;
    void getSize1(Node root){
        if(root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    int getSize2(Node root){
        if(root == null) {
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }
    //遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leafSize++;
        }else {
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }
    }


    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }
    //求第K层的节点个数
    int getKLevelSize(Node root,int k) {
        if(root == null) {
            return 0;
        }else if(k == 1) {
            return 1;
        }else {
            return getKLevelSize(root.left,k-1)
                    +getKLevelSize(root.right,k-1);
        }
    }

    // 获取二叉树的高度
    int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight >  rightHeight? leftHeight+1 :
                rightHeight+1;
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找  前序遍历的方式
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, char val){
        if(root == null) {
            return null;
        }
        //1、判断根节点是否是查找的数字val
        if(root.val == val) {
            return root;
        }
        //2、左边
        //  递归--》左边全部递归完成后-》返回值是否是空
        Node left = find(root.left,val);
        if(left != null) {
            return left;
        }
        //3、右边
        Node right = find(root.right,val);
        if(right != null) {
            return right;
        }
        return null;
    }
    // 层序遍历
    void levelOrderTraversal(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //每一次进入这个循环，就相当于是每一层的数据
            Node cur = queue.poll();
            if(cur != null) {
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.println();
    }
    /*//把每一层的数据放到一个list  然后将这些list放到大的list当中
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //1、求当前队列的大小  size
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            //2、while(size > 0)  -->控制当前每一层的数据个数
            while (size > 0) {
                Node cur = queue.poll();
                if(cur != null) {
                    list.add(cur.val);
                    if(cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }*/

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root) {
        if(root == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        //看一下 队列里面是否都是空
        while (!queue.isEmpty()) {
           Node cur2 = queue.peek();
           if(cur2 != null) {
               return false;
           }else {
               queue.poll();
           }
        }
        return true;
    }
    // 前序遍历
    void preOrderTraversalNor(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }
    // 中序遍历
    void inOrderTraversalNor(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
        System.out.println();
    }

    // 后序遍历
    void postOrderTraversalNor(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                System.out.print(cur.val+" ");
                stack.pop();
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        System.out.println();
    }

    public  Node prev = null;

    public void ConvertChild(Node pCur) {
        if(pCur == null) return;
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }

    public Node Convert(Node pRootOfTree) {
        if(pRootOfTree == null)  return null;
        ConvertChild(pRootOfTree);
        Node head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
}
