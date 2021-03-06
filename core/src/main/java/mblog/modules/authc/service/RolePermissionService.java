package mblog.modules.authc.service;

import mblog.modules.authc.entity.Permission;
import mblog.modules.authc.entity.RolePermission;

import java.util.List;
import java.util.Set;


/**
 * @author  an
 */
public interface RolePermissionService {
    List<Permission> findPermissions(long roleId);
    void deleteByRoleId(long roleId);
    void add(Set<RolePermission> rolePermissions);

}
