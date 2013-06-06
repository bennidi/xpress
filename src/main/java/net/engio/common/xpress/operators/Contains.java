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
public interface Contains<IN, OUT> {

    public OUT Contains(IN other);


    public static class ContainsNode<S> extends BinaryNode {


        public ContainsNode(Node left, Node right) {
            super(left, right);
        }

        public ContainsNode(Node left, Object right) {
            super(left, right);
        }

        public ContainsNode(Object left, Object right) {
            super(left, right);
        }
    }

}
