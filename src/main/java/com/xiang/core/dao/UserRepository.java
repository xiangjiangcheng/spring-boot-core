package com.xiang.core.dao;

import com.xiang.core.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiao7
 */
@Repository
public interface UserRepository extends JpaSpecificationExecutor<User>, PagingAndSortingRepository<User, String> {

}