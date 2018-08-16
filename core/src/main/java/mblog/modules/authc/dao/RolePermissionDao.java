package mblog.modules.authc.dao;

import mblog.modules.authc.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author  an
 */
public interface RolePermissionDao extends JpaRepository<RolePermission, Long>, JpaSpecificationExecutor<RolePermission> {
    @Transactional(rollbackFor = Exception.class)
    int deleteByRoleId(long roleId);

    int deleteByPermissionId(long permissionId);

    List<RolePermission> findAllByRoleId(long roleId);
}
