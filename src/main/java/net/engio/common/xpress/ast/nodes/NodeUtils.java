package net.engio.common.xpress.ast.nodes;

/**
* Todo: Add javadoc
*
* @author bennidi
*         Date: 6/5/13
*/
public class NodeUtils {

    public static boolean isNode(Object o){
        return Node.class.isAssignableFrom(o.getClass());
    }

}
