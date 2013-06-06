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
public interface LessOrEqual<IN, OUT> {

    public OUT LessOrEqual(IN other);


    public static class LessOrEqualNode extends BinaryNode{


        public LessOrEqualNode(Node left, Node right) {
            super(left, right);
        }

        public LessOrEqualNode(Node left, Object right) {
            super(left, right);
        }

        public LessOrEqualNode(Object left, Object right) {
            super(left, right);
        }
    }

}
