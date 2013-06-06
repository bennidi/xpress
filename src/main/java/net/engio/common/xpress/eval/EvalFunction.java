package net.engio.common.xpress.eval;

import net.engio.common.xpress.ast.nodes.Node;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/23/13
 */
public interface EvalFunction<N extends Node, R> {

    public R evaluate(N node, EvaluationContext context);
}
