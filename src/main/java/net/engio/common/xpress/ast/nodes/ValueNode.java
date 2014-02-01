package net.engio.common.xpress.ast.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/24/13
 */
public class ValueNode implements Node{

    private static final List<Node> Empty = Collections.unmodifiableList(new ArrayList<Node>());

    @Override
    public List<Node> getChildren() {
        return Empty;
    }

    private Object value;

    public ValueNode(Object value) {
        this.value = value;
    }

    public <T> T getValue() {
        return (T)value;
    }
}
