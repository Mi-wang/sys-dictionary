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
@TableName("sys_dict_data")
public class DictData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典明细标签
     */
    private String label;

    /**
     * 字典明细的值(用于存储)
     */
    private String value;

    /**
     * 字典序列
     */
    private Integer seq;

    private String remark;


}
