package com.xiang.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 会员实体
 *
 * <p>
 * Created by xiangjiangcheng on 2018/7/14 11:03.
 */
@Entity
@Table(name = "t_member")
@Data
public class Member {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "member_id", length = 36)
    public String id;

    /**
     * 注册日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    @Column(name = "`date`")
    public Date date;

    /**
     * 姓名
     */
    @Column(name = "`name`", length = 50)
    public String name;

    /**
     * 性别
     */
    @Column(name = "sex")
    public Integer sex;

}
