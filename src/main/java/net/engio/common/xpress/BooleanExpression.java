package net.engio.common.xpress;

import net.engio.common.xpress.ast.NodeDecorator;
import net.engio.common.xpress.ast.nodes.Node;
import net.engio.common.xpress.operators.logical.And;
import net.engio.common.xpress.operators.logical.Or;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/22/13
 */
public interface BooleanExpression extends NodeDecorator, And<BooleanExpression>, Or<BooleanExpression> {

      public static class BoolExprNode extends NodeDecorator.Impl implements BooleanExpression{

          public BoolExprNode(Node node) {
              super(node);
          }

          @Override
          public BooleanExpression And(BooleanExpression... expressions) {
              return new BoolExprNode(new AndNode(this, expressions));
          }

          @Override
          public BooleanExpression Or(BooleanExpression... expressions) {
              return new BoolExprNode(new Or.OrNode(this, expressions));
          }
      }
}
