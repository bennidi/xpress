package net.engio.common.xpress.ast.transformation;

import net.engio.common.xpress.ast.nodes.Node;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/24/13
 */
public interface AstTransformation<I extends Node, R extends Node> {

    public R transform(I input);

    public boolean accepts(Node node);
}
