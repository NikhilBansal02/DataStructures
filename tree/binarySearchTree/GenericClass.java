package binarySearchTree;

public class GenericClass<T> {

    public static <T> void inorder(T t){

        System.out.println("Inorder Traversal of Given Tree");
        //inorderTraversal(t);
        System.out.println();
    }
    //Inorder Traversal of BST always provide sorted values.
    public static <T> void inorderTraversal(T t, Class c){

        if(t ==null){
            return;
        }
       // Class type = c.getClass();
        if(c.toString().equals("avl.Node") ){
            System.out.println("yes");
        }else{
            System.out.println(c.toString());
        }
        /*inorderTraversal(t.left);
        System.out.print(t.data+" ");
        inorderTraversal(t.right);*/
    }
}
