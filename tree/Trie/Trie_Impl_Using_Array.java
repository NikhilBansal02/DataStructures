package Trie;

/**
 *Class provides the implementation of Trie using Array.
 * Operations -
 * insert()
 * search()
 * remove()
 */
public class Trie_Impl_Using_Array {

    static TrieNodeA root;

    public static void insert(String key){

        if(root == null){
            root = new TrieNodeA();
        }

        int index=0;
        TrieNodeA crawler = root;

        for(int level=0;level<key.length();level++){

            index = key.charAt(level) -'a';
            if(crawler.children[index] == null){
                crawler.children[index] = new TrieNodeA();
            }

            crawler = crawler.children[index];

        }
        if(crawler.endOfWord){
            System.out.println(key +" already exist in Trie..!!!!");
            return;
        }
        crawler.endOfWord=true;
        System.out.println(key +"- inserted...!!!!");

    }

    public static void search(String key){

        if(root == null){
            System.out.println("Trie is Empty...!!!!");
            return;
        }
        int index=0;
        TrieNodeA crawler = root;

        for(int level=0;level<key.length();level++){
            index = key.charAt(level) -'a';
            if(crawler.children[index] == null){
                System.out.println(key +"- is  not present in Trie.");
                return;
            }

            crawler = crawler.children[index];
        }
        if(crawler.endOfWord){
            System.out.println(key +"- is present in Trie.");
        }else{
            System.out.println(key +"- is not present in Trie.");
        }

    }

    public static boolean isEmpty(TrieNodeA root){

        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                return false;
            }
        }
        return true;
    }

    public static TrieNodeA remove(TrieNodeA root, String key, int depth){

        if(root == null){
            return null;
        }

        if(depth == key.length()){

            if(root.endOfWord)
                root.endOfWord = false;

            if(isEmpty(root)){
               return null;
            }
            return root;

        }

        int index = key.charAt(depth) -'a';
        root.children[index]= remove(root.children[index],key,++depth);

        if(isEmpty(root) && root.endOfWord == false){
            return null;
        }

        return root;
    }

}
