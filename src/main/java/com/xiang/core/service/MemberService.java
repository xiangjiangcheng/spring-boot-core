package com.xiang.core.service;

import com.xiang.core.entity.Member;

import java.util.List;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/7/14 11:09.
 */
public interface MemberService {
    List<Member> findAllMemberList();
}
