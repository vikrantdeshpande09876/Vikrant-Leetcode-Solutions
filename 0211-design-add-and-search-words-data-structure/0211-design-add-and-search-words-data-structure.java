class TrieNode {
    TrieNode[] hmap = new TrieNode[26+1];
}

class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()){
            int index = c-'a';
            if (curr.hmap[index] == null)
                curr.hmap[index] = new TrieNode();
            curr = curr.hmap[index];
        }
        curr.hmap[26] = new TrieNode();
    }
    
    
    public boolean searchBFS(String word, int i, TrieNode curr){
        if (i == word.length())
            return curr.hmap[26] != null;
        
        int index = word.charAt(i)-'a';
        if (word.charAt(i) != '.'){
            if (curr.hmap[index] == null)
                return false;
            return searchBFS( word, i+1, curr.hmap[index] );
        }

        for (int j=0; j<27; j++){
            if ( (curr.hmap[j] != null) && searchBFS( word, i+1, curr.hmap[j] ) )
                return true;
        }
        return false;
    }
    
    public boolean search(String word) {
        return searchBFS(word, 0, this.root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */