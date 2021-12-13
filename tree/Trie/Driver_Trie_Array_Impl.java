package Trie;

import static Trie.Trie_Impl_Using_Array.*;

public class Driver_Trie_Array_Impl {

    public static void main(String[] args) {

        String keys[] = {"the", "the", "there", "answer", "any",
                "by", "bye", "their"};

        for(String i:keys){
            insert(i);
        }

        search("the");
        search("there");
        remove(root,"the",0);
        search("the");
        search("there");
    }
}
