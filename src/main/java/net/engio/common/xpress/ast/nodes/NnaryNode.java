package net.engio.common.xpress.ast.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public class NnaryNode implements Node{

    private Node first;

    private Node[] rest;

    public NnaryNode(Node first, Node[] rest) {
        this.first = first;
        this.rest = rest;
    }

    public Node getFirst() {
        return first;
    }

    public Node[] getRest() {
        return  rest;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public void setRest(Node[] rest) {
        this.rest = rest;
    }

    @Override
    public List<Node> getChildren() {
        List<Node> children = new ArrayList<Node>(1);
        children.add(this.first);
        for(Node nextNode : rest){
            children.add(nextNode);
        }
        return children;
    }
}
