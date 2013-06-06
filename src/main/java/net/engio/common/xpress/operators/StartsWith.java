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
public interface StartsWith<IN, OUT> {

    public OUT StartsWith(IN other);


    public static class StartsWithNode extends BinaryNode{


        public StartsWithNode(Node left, Node right) {
            super(left, right);
        }

        public StartsWithNode(Node left, Object right) {
            super(left, right);
        }

        public StartsWithNode(Object left, Object right) {
            super(left, right);
        }
    }

}
