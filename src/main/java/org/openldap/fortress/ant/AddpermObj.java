/*
 * This work is part of OpenLDAP Software <http://www.openldap.org/>.
 *
 * Copyright 1998-2014 The OpenLDAP Foundation.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only as authorized by the OpenLDAP
 * Public License.
 *
 * A copy of this license is available in the file LICENSE in the
 * top-level directory of the distribution or, alternatively, at
 * <http://www.OpenLDAP.org/license.html>.
 */

package org.openldap.fortress.ant;

import java.util.ArrayList;
import java.util.List;

import org.openldap.fortress.rbac.PermObj;

/**
 * The class is used by {@link FortressAntTask} to load {@link PermObj}s used to drive {@link org.openldap.fortress.AdminMgr#addPermObj(org.openldap.fortress.rbac.PermObj)}.
 * It is not intended to be callable by programs outside of the Ant load utility.  The class name itself maps to the xml tag used by load utility.
 * <p>This class name, 'AddpermObj', is used for the xml tag in the load script.</p>
 * <pre>
 * {@code
 * <target name="all">
 *     <FortressAdmin>
 *         <addpermobj>
 *           ...
 *         </addpermobj>
 *     </FortressAdmin>
 * </target>
 * }
 * </pre>
 *
 * @author Shawn McKinney
 */
public class AddpermObj
{

    final private List<PermObj> permObjs = new ArrayList<>();


    /**
     * All Ant data entities must have a default constructor.
     */
    public AddpermObj()
    {
    }


    /**
     * <p>This method name, 'addPermObj', is used for derived xml tag 'permobj' in the load script.</p>
     * <pre>
     * {@code
     * <addpermobj>
     *     <permobj objName="/jsp/cal/cal1.jsp" description="Fortress Web Demo App Object 1" ou="demoapps1" type="Ant"/>
     *     <permobj objName="/jsp/cal/cal2.jsp" description="Fortress Web Demo App Object 2" ou="demoapps1" type="Ant"/>
     * </addpermobj>
     * }
     * </pre>
     *
     * @param permObj contains reference to data element targeted for insertion..
     */
    public void addPermObj(PermObj permObj)
    {
        this.permObjs.add(permObj);
    }


    /**
     * Used by {@link FortressAntTask#addPermObjs()} to retrieve list of PermObjs as defined in input xml file.
     *
     * @return collection containing {@link org.openldap.fortress.rbac.PermObj}s targeted for insertion.
     */
    public List<PermObj> getPermObjs()
    {
        return this.permObjs;
    }
}
