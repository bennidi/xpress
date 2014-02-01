package net.engio.common.xpress.ast.transformation;

import net.engio.common.xpress.ast.nodes.Node;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/24/13
 */
public interface AstTransformation<IN extends Node, OUT extends Node> {

    public OUT transform(IN input);

    public boolean accepts(Node node);
}
