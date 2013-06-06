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
public interface And<T extends Node> extends Node {


    public T And(T ...expressions);

    public static class AndNode extends NnaryNode{

        public AndNode(Node first,
                       Node... rest) {
            super(first, rest);
        }
    }

}
