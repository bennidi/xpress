package net.engio.common.xpress.ast.nodes;

import java.util.ArrayList;
import java.util.List;

import static net.engio.common.xpress.ast.nodes.Node.Utils.*;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public class UnaryNode implements Node{

    private Node descendent;

    public UnaryNode(Object descendent) {
        this.descendent = isNode(descendent) ? (Node)descendent : new ValueNode(descendent);
    }

    public Node getDescendent(){
        return descendent;
    }

    public void setDescendent(Node descendent) {
        this.descendent = descendent;
    }

    @Override
    public List<Node> getChildren() {
        List<Node> children = new ArrayList<Node>(1);
        children.add(this.descendent);
        return children;
    }
}
