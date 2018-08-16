package mblog.modules.authc.service.impl;

import mblog.modules.authc.dao.PermissionDao;
import mblog.modules.authc.dao.RolePermissionDao;
import mblog.modules.authc.entity.Permission;
import mblog.modules.authc.entity.RolePermission;
import mblog.modules.authc.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author  an
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    @Transactional(rollbackFor = Exception.class,readOnly = true)
    public List<Permission> findPermissions(long roleId) {
        List<RolePermission> rps = rolePermissionDao.findAllByRoleId(roleId);

        List<Permission> rets = null;
        if (rps != null && rps.size() > 0) {
            Set<Long> pids = new HashSet<>();
            rps.forEach(rp -> pids.add(rp.getPermissionId()));
            rets = permissionDao.findAllByIdIsIn(pids);
        }
        return rets;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByRoleId(long roleId) {
        rolePermissionDao.deleteByRoleId(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(Set<RolePermission> rolePermissions) {
        rolePermissionDao.save(rolePermissions);
    }
}
