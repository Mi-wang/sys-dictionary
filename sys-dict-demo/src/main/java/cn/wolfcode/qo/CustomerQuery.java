package cn.wolfcode.qo;

import cn.wolfcode.entity.Customer;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wby
 * @version 1.0
 * @date 2022/11/7 21:29
 */
@Setter
@Getter
public class CustomerQuery extends Page<Customer>{
    private String keyword;
}
