package net.engio.common.xpress.ast.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Todo: Add javadoc
*
* @author bennidi
*         Date: 6/5/13
*/
public abstract class Leaf implements Node{

    private static final List<Node> Empty = Collections.unmodifiableList(new ArrayList<Node>());

    @Override
    public List<Node> getChildren() {
        return Empty;
    }
}
