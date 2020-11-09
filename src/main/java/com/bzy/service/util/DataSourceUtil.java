package com.bzy.service.util;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.provider.YmlDynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class DataSourceUtil {
    
    @Bean
    public DynamicDataSourceProvider getDynamicDataSourceProperties(){
        DynamicDataSourceProperties dynamicDataSourceProperties = new DynamicDataSourceProperties();
        Map<String, DataSourceProperty> datasource = new LinkedHashMap<>();
        datasource.put("order-ds",getOrderDataSource());
        datasource.put("account-ds",getAccountDataSource());
        datasource.put("product-ds",getProductDataSource());
        dynamicDataSourceProperties.setDatasource(datasource);
        YmlDynamicDataSourceProvider ymlDynamicDataSourceProvider = new YmlDynamicDataSourceProvider(dynamicDataSourceProperties);
        return ymlDynamicDataSourceProvider;
    }
    
    @Bean(name = "order-ds")
    public DataSourceProperty getOrderDataSource(){
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setUrl("jdbc:mysql://192.168.56.100:33306/seata_order?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSourceProperty.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceProperty.setUsername("root");
        dataSourceProperty.setPassword("123456");
        return  dataSourceProperty;
    } 
    
    @Bean(name = "account-ds")
    public DataSourceProperty getAccountDataSource(){
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setUrl("jdbc:mysql://192.168.56.100:33306/seata_account?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSourceProperty.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceProperty.setUsername("root");
        dataSourceProperty.setPassword("123456");
        return  dataSourceProperty;
    }
    
    @Bean(name = "product-ds")
    public DataSourceProperty getProductDataSource(){
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setUrl("jdbc:mysql://192.168.56.100:33306/seata_product?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSourceProperty.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceProperty.setUsername("root");
        dataSourceProperty.setPassword("123456");
        return  dataSourceProperty;
    }

    @Bean
    public DataSource dataSource() {
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setProvider(getDynamicDataSourceProperties());
        dataSource.setPrimary("order-ds");
//        dataSource.setStrategy(getDynamicDataSourceProperties().getStrategy());
//        
//        dataSource.setP6spy(getDynamicDataSourceProperties().getP6spy());
//        dataSource.setStrict(getDynamicDataSourceProperties().getStrict());
       // dataSource.setSeata(true);
        return dataSource;
    }
}
