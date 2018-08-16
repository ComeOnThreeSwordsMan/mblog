package mblog.modules.user.dao;

import mblog.modules.user.entity.Notify;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author an
 */
public interface NotifyDao extends JpaRepository<Notify, Long>, JpaSpecificationExecutor<Notify> {
    Page<Notify> findAllByOwnIdOrderByIdDesc(Pageable pageable, long ownId);
    /**
     * 查询我的未读消息
     * @param ownId
     * @return
     */
    int countByOwnIdAndStatus(long ownId, int status);

    /**
     * 标记我的消息为已读
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update Notify n set n.status = 1 where n.status = 0 and n.ownId = :id")
    int updateReadedByOwnId(@Param("id") Long id);
}
