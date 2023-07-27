public class Tree {
     static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right =null;
        }
    }

    static class BinaryTree{
        static int ind=-1;
        public static Node buildTree(int nodes[]){
        if(nodes[++ind]==-1){
            return null;
        }
         Node nw=new Node(nodes[ind]);
        nw.left=buildTree(nodes);
        nw.right=buildTree(nodes);
        return nw;
        }
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder((root.right));
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder((root.right));
    }

    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder((root.right));
        System.out.print(root.data+" ");
    }

    public static int height(Node root){
        if(root ==null){
            return 0;
        }

        return (int)(Math.max( height(root.left),height(root.right))+1);
    }

    static class Treeinfo{
         int hgt;
         int diam;
         Treeinfo(int hgt,int diam){
             this.hgt=hgt;
             this.diam=diam;
         }
    }

    public static Treeinfo diameter2(Node root){
         if(root==null){
             return new Treeinfo(0,0);
         }

        Treeinfo l= diameter2((root.left));
        Treeinfo r= diameter2(root.right);
         int h=(int)Math.max(l.hgt,r.hgt)+1;
         int diam=l.hgt+r.hgt+1;
         int dial=l.diam;
         int diar=r.diam;
         int d=(int)(Math.max(Math.max(dial,diar),diam));

         Treeinfo info=new Treeinfo(h,d);
return info;

    }
    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        
        postorder(root.left);
        postorder((root.right));
        System.out.print(root.data+" ");
    }

    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree=new BinaryTree() ;
        Node root=tree.buildTree(nodes);
       preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        System.out.println((height(root)));
        System.out.println(diameter2(root).diam);
    }
}
