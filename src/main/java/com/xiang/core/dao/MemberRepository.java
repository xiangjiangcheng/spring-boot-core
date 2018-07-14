package com.xiang.core.dao;

import com.xiang.core.entity.Member;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/7/14 11:06.
 */
public interface MemberRepository extends JpaSpecificationExecutor<Member>, PagingAndSortingRepository<Member, String> {

}
