package com.ghy.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//@Configuration
public class MyDataSourceConfig {
    // 默认的自动配置是判断容器中没有才会配@ConditionalOnMissingBean({DataSource.class, XADataSource.class})
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();

        /*druidDataSource.setUrl();
        druidDataSource.setName();
        druidDataSource.setPassword();*/
        //加入监控功能 stat
        //加入防火墙功能 wall
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }
    //配置druid的监控页功能
    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        //配置监控页的账号和密码
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");
        return registrationBean;
    }

    //WebStatFilter用于采集web-jdbc关联监控的数据
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*")); //拦截的路径
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.css");  //排除一些路径
        return filterRegistrationBean;
    }
}















