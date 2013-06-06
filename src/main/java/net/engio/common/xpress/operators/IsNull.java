package net.engio.common.xpress.operators;

import net.engio.common.xpress.ast.nodes.Node;
import net.engio.common.xpress.ast.nodes.UnaryNode;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public interface IsNull<OUT> {

    public OUT IsNull();

    public static class IsNullNode extends UnaryNode {


        public IsNullNode(Node child) {
            super(child);
        }

        public IsNullNode(Object child) {
            super(child);
        }

    }

}
