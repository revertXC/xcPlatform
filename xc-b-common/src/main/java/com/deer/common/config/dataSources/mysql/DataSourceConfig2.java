package com.deer.common.config.dataSources.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.deer.common.annotation.MybatisDao2;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
// 扫描 Mapper 接口并容器管理
//@MapperScan(basePackages = DataSourceConfig2.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory2",annotationClass = MybatisDao2.class)
public class DataSourceConfig2 {
    static final String PACKAGE = "com.deer.mapper.mysql.dao2";

    @Value("${platform.druid.stat.loginUsername}")
    private String loginUsername; /*durid 连接池管理 账号*/

    @Value("${platform.druid.stat.loginPassword}")
    private String loginPassword; /*durid 连接池管理 密码*/

    @Value("${platform.dataSource.type}")
    private String datasourceType; /* pagehelper 分页数据库类型*/

    @Bean(name="dataSource2",initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid2")
    public DataSource dataSource2() {
        return new DruidDataSource();
    }

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactoryBean2() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource2());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/deer/mapper/"+datasourceType+"/dao2/impI/**/*Mapper.xml"));
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pagePlugin()});

        return sqlSessionFactoryBean.getObject();
    }

    public PageHelper pagePlugin(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", datasourceType);
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    @Bean
    public ServletRegistrationBean statViewServlet2() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid2/*");
        reg.addInitParameter("loginUsername", loginUsername);
        reg.addInitParameter("loginPassword", loginPassword);
        reg.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return reg;
    }

}
