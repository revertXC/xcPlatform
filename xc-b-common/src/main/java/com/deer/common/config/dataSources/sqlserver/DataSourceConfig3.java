package com.deer.common.config.dataSources.sqlserver;

import com.deer.common.annotation.MybatisDao3;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
// 扫描 Mapper 接口并容器管理
//@MapperScan(basePackages = DataSourceConfig3.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory3",annotationClass = MybatisDao3.class)
public class DataSourceConfig3 {
    static final String PACKAGE = "com.deer.mapper.sqlserver.dao";

    private String datasourceType = "sqlserver"; /* pagehelper 分页数据库类型*/

    @Bean(name="dataSource3")
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource3() {
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }

    @Bean(name = "sqlSessionFactory3")
    public SqlSessionFactory sqlSessionFactoryBean3() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource3());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/deer/mapper/"+datasourceType+"/dao/impI/**/*Mapper.xml"));
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


}
