package net.engio.common.xpress.ast;

import net.engio.common.xpress.ast.nodes.Node;
import net.engio.common.xpress.ast.nodes.UnaryNode;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/23/13
 */
public interface NodeDecorator extends Node {

    public <N extends Node> N getNode();

    public static class Impl extends UnaryNode implements NodeDecorator{

        public Impl(Node decorated) {
            super(decorated);
        }

        public <N extends Node> N getNode(){
            return (N)getDescendent();
        }

    }


}
