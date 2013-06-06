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
public interface Equals<IN, OUT> {

    public OUT Equals(IN other);


    public static class EqualsNode extends BinaryNode{


        public EqualsNode(Node left, Node right) {
            super(left, right);
        }

        public EqualsNode(Node left, Object right) {
            super(left, right);
        }

        public EqualsNode(Object left, Object right) {
            super(left, right);
        }
    }

}
