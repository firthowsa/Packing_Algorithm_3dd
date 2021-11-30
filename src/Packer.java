import java.util.ArrayList;
import java.util.Iterator;

public class Packer {
    private final ArrayList<Node> root = new ArrayList();

    public Packer(int numofpackets, double l, double w,double h) {
        for(int i = 0; i< numofpackets;i++){
            this.root.add(new Node(0, 0,0, l, w,h));
        }
    }


    public void fit(ArrayList<Node> blocks) {
        Node node;
        Node block;
        Iterator<Node> blockItr = blocks.iterator();
        int n=0;
        while (blockItr.hasNext()) {
            block = blockItr.next();
            if ((node = this.findNode(this.root.get(n), block.l, block.w, block.h))!=null) {
                block.fit = this.splitNode(node, block.l, block.w, block.h);
                if(node.isroot){
                    block.fit.isroot = true;
                }
            }else{
                n++;
            }
        }
    }

    public Node findNode(Node root, double l, double w,double h) {
        if (root.used) {
            Node right = findNode(root.right, l, w,h);
            Node down =findNode(root.down, l, w,h);
            Node up =findNode(root.up, l, w,h);
            if(right != null){
                return right;
            } else if (down != null) {
                return down;
            }else
            {
                return up;
            }
            //return (right != null ? right : findNode(root.down, l, w,h));
        } else if ((l <= root.l) && (w <= root.w) && (h <= root.h)) {
            return root;
        } else {
            return null;
        }
    }

    public Node splitNode(Node node, double l, double w,double h) {
        node.used = true;
        node.down = new Node(node.x, node.y + w,node.z  , node.l, node.w-w,h);
        node.right = new Node(node.x + l, node.y, node.z , node.l - l, w,h);
        node.up=new Node(node.x , node.y, node.z +h , node.l , node.w, node.h-h);
        return node;
    }

}
