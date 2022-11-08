package cn.wolfcode.vo;

import cn.wolfcode.qo.QueryObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wby
 * @version 1.0
 * @date 2022/11/7 16:28
 */
@Getter
@Setter
public class DictItemQuery extends QueryObject {
    private String dictType;
}
