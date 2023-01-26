// Create a trie for all words[]
// Created a visited set()
// for each word
//  for each cell, start dfs and check if trie's currentNode.hmap has currentChar
// See if we can improve above 2 steps with a holistic approach
class TrieNode {
    TrieNode[] hmap = new TrieNode[26];
    boolean isWord = false;
}

class Solution {
    HashSet<String> res;
    TrieNode root;
    
    public void insertIntoTrie(String word){
        TrieNode node = this.root;
        for (char c : word.toCharArray()){
            if (node.hmap[c-'a'] == null)
                node.hmap[c-'a'] = new TrieNode();
            node = node.hmap[c-'a'];
        }
        node.isWord = true;
    }

    
    public void dfs(char[][] board, int i, int j, int m, int n, String currWord, TrieNode node){
        if (i>=board.length || j>=board[0].length || i<0 || j<0 || board[i][j]=='#')
            return;
        
        // System.out.println("board["+i+"]["+j+"]="+board[i][j]+", currWord="+currWord+", isWord="+node.isWord);
        
        char temp = board[i][j];
        int charIndex = temp-'a';
        node = node.hmap[charIndex];
        if (node==null)
            return;

        currWord += board[i][j];
        if (node.isWord)
            this.res.add(currWord);
        
        board[i][j] = '#';
        dfs(board, i+1, j, m, n, currWord, node);
        dfs(board, i-1, j, m, n, currWord, node);
        dfs(board, i, j+1, m, n, currWord, node);
        dfs(board, i, j-1, m, n, currWord, node);
        board[i][j] = temp;
    }
    
    
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        this.res = new HashSet<>();
        this.root = new TrieNode();
        for (String word : words)
            insertIntoTrie(word);
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++)
                dfs(board, i, j, m, n, "", this.root);
        }
        
        List<String> output = new ArrayList<>();
        for (String x : this.res)
            output.add(x);
        return output;
    }
}
/*
[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
["oath","pea","eat","rain"]
[["a","b"],["c","d"]]
["abcb"]
[["a","b","c"],["a","e","d"],["a","f","g"]]
["eaafgdcba","eaabcdgfa"]
[["a","a"]]
["aaa"]
*/