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
public interface LessThan<IN, OUT> {

    public OUT LessThan(IN other);


    public static class LessThanNode extends BinaryNode{


        public LessThanNode(Node left, Node right) {
            super(left, right);
        }

        public LessThanNode(Node left, Object right) {
            super(left, right);
        }

        public LessThanNode(Object left, Object right) {
            super(left, right);
        }
    }

}
