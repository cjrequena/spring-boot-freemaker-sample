package com.cjrequena.sample.db.repository;

import com.cjrequena.sample.db.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author cjrequena
 * @version 1.0
 * @since JDK1.8
 * @see
 *
 */
@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer>, JpaSpecificationExecutor<AlbumEntity> {
}
