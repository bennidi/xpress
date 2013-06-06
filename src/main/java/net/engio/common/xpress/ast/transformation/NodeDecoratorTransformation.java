package net.engio.common.xpress.ast.transformation;

import net.engio.common.xpress.ast.nodes.Node;
import net.engio.common.xpress.ast.NodeDecorator;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/24/13
 */
public class NodeDecoratorTransformation implements AstTransformation<NodeDecorator, Node>{


    @Override
    public Node transform(NodeDecorator input) {
        return input.getNode();
    }

    @Override
    public boolean accepts(Node node) {
        return node instanceof NodeDecorator;
    }
}
