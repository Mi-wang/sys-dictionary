package cn.wolfcode.qo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
public class QueryObject {

    private Integer current = 1;
    private Integer size = 5;
    private String keyword;

    public void setKeyword(String keyword) {
        if (StringUtils.hasText(keyword)) {
            this.keyword = keyword;
        }
    }
}
