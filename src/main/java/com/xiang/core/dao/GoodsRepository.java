package com.xiang.core.dao;

import com.xiang.core.entity.Goods;
import com.xiang.core.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 17:02.
 */
@Repository
public interface GoodsRepository extends JpaSpecificationExecutor<User>, PagingAndSortingRepository<Goods, String> {

}
