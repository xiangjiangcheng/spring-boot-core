package com.xiang.core.service.impl;

import com.xiang.core.dao.MemberRepository;
import com.xiang.core.entity.Member;
import com.xiang.core.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/7/14 11:09.
 */
@Repository
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public List<Member> findAllMemberList() {

        return null;
    }
}
