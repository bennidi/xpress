package net.engio.common.xpress.operators;

import net.engio.common.xpress.ast.nodes.BinaryNode;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public interface GreaterThan<IN, OUT> {

    public OUT GreaterThan(IN other);


    public static class GreaterThanNode extends BinaryNode{

        public GreaterThanNode(Object left, Object right) {
            super(left, right);
        }
    }

}
