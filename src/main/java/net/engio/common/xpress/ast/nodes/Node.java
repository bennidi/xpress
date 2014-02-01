package net.engio.common.xpress.ast.nodes;

import java.util.List;

/**
 * Todo: Add javadoc
 *
 * @author bennidi
 *         Date: 3/23/13
 */
public interface Node {

    public List<Node> getChildren();

    /**
    * Todo: Add javadoc
    *
    * @author bennidi
    *         Date: 6/5/13
    */
    class Utils {

        public static boolean isNode(Object o){
            return Node.class.isAssignableFrom(o.getClass());
        }

    }
}
