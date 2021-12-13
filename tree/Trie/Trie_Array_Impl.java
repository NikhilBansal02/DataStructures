package Trie;

public class Trie_Array_Impl {

    static TrieNodeA root;

    public static void insert(String key){

        if(root == null){
            System.out.println("Root is allocated");
            root = new TrieNodeA();
        }
        key = key.toLowerCase();

        int length = key.length();
        int index=0;

        TrieNodeA crawler = root;

        for(int level=0;level<length;level++){

            index = key.charAt(level) - 'a';
            if(crawler.children[index] == null){
                crawler.children[index] = new TrieNodeA();
            }

            crawler = crawler.children[index];
        }
        crawler.endOfWord=true;
    }

    public static void search(String key){

        if(root == null){
            System.out.println("There is no dictionary to be searched..!!!!");
            return;
        }

        int index=0;
        int length = key.length();
        TrieNodeA crawler = root;

        for(int level=0;level<length;level++){

            index = key.charAt(level) -'a';
            if(crawler.children[index] == null){
                System.out.println(key +" - is not present in dictionary");
                return;
            }
            crawler = crawler.children[index];

        }

        if(crawler.endOfWord){
            System.out.println(key +" - is present in dictionary");
        }else{
            System.out.println(key +" - is not present in dictionary");
        }
    }
}
