class TrieNode {
    Map<Character,TrieNode> hmap = new HashMap<>();
}
class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()){
            curr.hmap.putIfAbsent(c, new TrieNode());
            curr = curr.hmap.get(c);
        }
        curr.hmap.put('#', null);
    }
    
    
    public boolean searchBFS(String word, int i, TrieNode curr, char prev){
        if (i == word.length())
            return curr.hmap.containsKey('#');
        
        if (word.charAt(i) != '.'){
            if (!curr.hmap.containsKey(word.charAt(i)))
                return false;
            return searchBFS( word, i+1, curr.hmap.get(word.charAt(i)), word.charAt(i) );
        }

        for (char c : curr.hmap.keySet())
            if ( c != '#' && searchBFS( word, i+1, curr.hmap.get(c), c ) )
                return true;
        return false;
    }
    
    public boolean search(String word) {
        return searchBFS(word, 0, this.root, '-');
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */