package Trie;

public class TrieNodeA {

    boolean endOfWord;
    TrieNodeA children[] = new TrieNodeA[26];

    TrieNodeA(){
        endOfWord=false;
    }
}
