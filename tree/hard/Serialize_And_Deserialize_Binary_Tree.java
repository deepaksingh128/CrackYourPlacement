public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        serializeHelper (root, sb);
        return sb.toString();
    }

    public void serializeHelper (TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        } 

        sb.append(root.val+",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] idx = {0};
        return deserializeHelper (arr, idx);
    }

    public TreeNode deserializeHelper(String[] data, int[] idx) {
        if (idx[0] >= data.length || data[idx[0]].equals("null")) {
            idx[0] ++;
            return null;
        }

        TreeNode node = new TreeNode (Integer.parseInt(data[idx[0]++]));

        node.left = deserializeHelper(data, idx);
        node.right = deserializeHelper(data, idx);

        return node;
    }
}
