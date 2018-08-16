/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.modules.user.dao;

import mblog.modules.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author an
 */
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     *  根据名称查找用户
     * @param username 用户名
     * @return 用户
     */
    User findByUsername(String username);

    /**
     *  根据邮箱查找用户
     * @param email 邮箱
     * @return 结果
     */
    User findByEmail(String email);

    /**
     *
     * @return
     */
    List<User> findTop12ByOrderByFansDesc();

    Page<User> findAllByOrderByIdDesc(Pageable pageable);

    List<User> findAllByIdIn(Set<Long> ids);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update User set posts = posts + :increment where id = :id")
    int updatePosts(@Param("id") long id, @Param("increment") int increment);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update User set comments = comments + :increment where id = :id")
    int updateComments(@Param("id") long id, @Param("increment") int increment);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update User set follows = follows + :increment where id = :id")
    int updateFollows(@Param("id") long id, @Param("increment") int increment);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update User set fans = fans + :increment where id = :id")
    int updateFans(@Param("id") long id, @Param("increment") int increment);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update User set favors = favors + :increment where id = :id")
    int updateFavors(@Param("id") long id, @Param("increment") int increment);

}
