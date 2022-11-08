package cn.wolfcode.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author wang
 * @since 2022-11-07
 */
@Getter
@Setter
@TableName("t_customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户电话
     */
    private String phone;

    /**
     * 来源渠道(存储字典明细的value)
     */
    private String source;

    /**
     * 意向校区(字典明细的value)
     */
    private String school;


}
