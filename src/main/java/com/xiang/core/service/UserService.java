package com.xiang.core.service;

import com.xiang.core.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    /**
     * 根据id获取商铺信息
     *
     * @param id
     * @return User
     */
    User getOne(String id);

    /**
     * 获取商铺列表
     *
     * @return Page<User>
     */
    Page<User> getAll(Integer page, Integer size);

    /**
     * 保存商铺信息
     *
     * @param user
     * @return int 新增商铺id
     */
    User save(User user);

    /**
     * 修改商铺信息
     *
     * @param user
     * @return Boolean
     */
    User Update(User user);


    /**
     * 删除商铺信息
     *
     * @return Boolean
     */
    Boolean delete(String id);

}
