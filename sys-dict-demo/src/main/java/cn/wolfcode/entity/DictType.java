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
 * @author xiaoliu
 * @since 2022-11-07
 */
@Getter
@Setter
@TableName("sys_dict_type")
public class DictType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典类型名称
     */
    private String name;

    /**
     * 字典类型
     */
    private String type;

    /**
     * 备注
     */
    private String remark;


}
