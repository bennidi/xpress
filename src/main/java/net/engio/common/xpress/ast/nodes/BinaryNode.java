package net.engio.common.xpress.ast.nodes;

import java.util.ArrayList;
import java.util.List;

import static net.engio.common.xpress.ast.nodes.Node.Utils.*;


/**
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public class BinaryNode implements Node{

    private Node left;

    private Node right;

    public BinaryNode(Object left, Object right){
        this.left = isNode(left) ? (Node)left : new ValueNode(left);
        this.right = isNode(right) ? (Node)right : new ValueNode(right);
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return  right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public List<Node> getChildren() {
        List<Node> children = new ArrayList<Node>(2);
        children.add(this.left);
        children.add(this.right);
        return children;
    }
}
