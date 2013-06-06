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
public interface IsEmpty<IN, OUT> {

    public OUT IsEmpty(IN other);


    public static class IsEmptyNode<S> extends BinaryNode {


        public IsEmptyNode(Node left, Node right) {
            super(left, right);
        }

        public IsEmptyNode(Node left, Object right) {
            super(left, right);
        }

        public IsEmptyNode(Object left, Object right) {
            super(left, right);
        }
    }

}
