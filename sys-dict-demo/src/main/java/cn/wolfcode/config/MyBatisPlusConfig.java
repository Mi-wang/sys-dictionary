package cn.wolfcode.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan("cn.wolfcode.mapper")
@Configuration
public class MyBatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor pageInterceptor() {
        // mybatis 拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // mybatis plus 内部拦截器
        PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 加入到 mybatis plus
        interceptor.addInnerInterceptor(innerInterceptor);
        // 合理化参数, 如果当前页小于0或大于最大页, 进行自动跳转
        innerInterceptor.setOverflow(true);
        return interceptor;
    }
}
