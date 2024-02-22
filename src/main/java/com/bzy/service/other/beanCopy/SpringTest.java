package com.bzy.service.other.beanCopy;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by bsj on 2022/7/15.
 */
public class SpringTest {


    public class Customer {
        private Long id;
        private String name;
    }


    public class CustomerDto {
        private Long id;
        private String customerName;
    }

    // 这里主要是这个componentModel 属性，它的值就是当前要使用的依赖注入的环境  
    @Mapper(componentModel = "spring")
    public interface CustomerMapper {

        @Mapping(source = "name", target = "customerName")
        CustomerDto toCustomerDto(Customer customer);
    }
}
