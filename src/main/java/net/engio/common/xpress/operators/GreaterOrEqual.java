package net.engio.common.xpress.operators;

import net.engio.common.xpress.BooleanExpression;
import net.engio.common.xpress.ast.nodes.BinaryNode;
import net.engio.common.xpress.ast.nodes.Node;
import net.engio.common.xpress.ast.nodes.ValueNode;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public interface GreaterOrEqual<IN, OUT> {

    public OUT GreaterOrEqual(IN other);


    public static class GreaterOrEqualNode extends BinaryNode{

        public GreaterOrEqualNode(Node first, Object second) {
            super(first, new ValueNode(second));
        }

        public GreaterOrEqualNode(Object first, Object second) {
            super(new ValueNode(first), new ValueNode(second));
        }

        public GreaterOrEqualNode(Node first, Node second) {
            super(first, second);
        }
    }

}
