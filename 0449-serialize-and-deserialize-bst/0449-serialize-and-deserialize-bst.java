/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("");
        if (root == null)
            return res.toString();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int levelSize = q.size();
            for (int i=0; i<levelSize; i++){
                TreeNode curr = q.poll();
                if (curr == null){
                    res.append("#");
                }
                else{
                    res.append(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
                res.append("-");
            }
            res.append("*");
            res.append("-");
        }
        String result = res.substring(0, res.length()-1).toString();
        return result;
    }


    public TreeNode deserialize(String data) {
        if (data.length()==0)
            return null;
        
        Deque<TreeNode> q = new ArrayDeque<>();
        String[] arrData = data.split("-");
        TreeNode root = new TreeNode(Integer.valueOf(arrData[0]));
        q.offer(root);
        
        int i = 1;
        while (i < arrData.length){
            // if token == number / # , only then process it for queue-of-TreeNodes
            String l = arrData[i];
            if (!l.equals("*")){
                String r = arrData[++i];
                TreeNode curr = q.poll();
                if (!l.equals("#")){
                    curr.left = new TreeNode(Integer.valueOf(l));
                    q.offer(curr.left);
                }
                else
                    curr.left = null;
                if (!r.equals("#")){
                    curr.right = new TreeNode(Integer.valueOf(r));
                    q.offer(curr.right);
                }
                else
                    curr.right = null;
            }
            // else if token == * (end of level), do nothing. Move on to the next level.
            i++;
        }
        return root;
    }
}