package mblog.modules.blog.dao;

import mblog.modules.blog.entity.Favor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author  an
 */
public interface FavorDao extends JpaRepository<Favor, Long>, JpaSpecificationExecutor<Favor> {
    /**
     * 指定查询
     * @param ownId
     * @param postId
     * @return
     */
    Favor findByOwnIdAndPostId(long ownId, long postId);

    Page<Favor> findAllByOwnIdOrderByCreatedDesc(Pageable pageable, long ownId);
}
