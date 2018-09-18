
package org.javaserverfaces.chapter03;

/**
 * This is a dummy container to represent a visitor object.
 * @author Juneau
 */
public class Visitor {
    private boolean admin = false;

    /**
     * @return the isAdmin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setAdmin(boolean isAdmin) {
        this.admin = admin;
    }
}
