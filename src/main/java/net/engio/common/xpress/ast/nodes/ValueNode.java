package net.engio.common.xpress.ast.nodes;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/24/13
 */
public class ValueNode extends Leaf {

    private Object value;

    public ValueNode(Object value) {
        this.value = value;
    }

    public <T> T getValue() {
        return (T)value;
    }
}
