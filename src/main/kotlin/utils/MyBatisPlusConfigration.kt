package utils

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@MapperScan("com.mapper")
class MyBatisPlusConfigration {
    @Bean
    fun mybatisPlusInterceptor():MybatisPlusInterceptor
    {
        val interceptor = MybatisPlusInterceptor()
        interceptor.addInnerInterceptor(PaginationInnerInterceptor (DbType.MYSQL));
        return interceptor;
    }
}