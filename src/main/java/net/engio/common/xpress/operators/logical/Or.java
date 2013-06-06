package net.engio.common.xpress.operators.logical;

import net.engio.common.xpress.BooleanExpression;
import net.engio.common.xpress.ast.nodes.NnaryNode;
import net.engio.common.xpress.ast.nodes.Node;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public interface Or<T extends Node> extends Node {


    public T Or(T... expressions);

    public static class OrNode extends NnaryNode{

        public OrNode(Node first,
                    Node ...rest) {
            super(first, rest);
        }
    }

}
