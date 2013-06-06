package net.engio.common.xpress.ast.nodes;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/24/13
 */
public class AstRoot extends UnaryNode{

    public AstRoot(Node root) {
        super(root);
    }

    public Node getRoot() {
        return getDescendent();
    }
}
