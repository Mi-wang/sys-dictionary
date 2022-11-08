package cn.wolfcode.vo;

import cn.wolfcode.entity.Customer;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wby
 * @version 1.0
 * @date 2022/11/7 21:25
 */
@Getter
@Setter
public class CustomerVo extends Customer {

    private String sourceLabel;
    private String schoolLabel;
}
