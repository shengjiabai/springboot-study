package com.bzy.service.other.beanCopy;

import com.bzy.service.other.beanCopy.mapper.UserRoleMapper;
import com.bzy.service.other.beanCopy.model.Role;
import com.bzy.service.other.beanCopy.model.User;
import com.bzy.service.other.beanCopy.model.UserRoleDto;

/**
 * @Mapper(componentModel = “spring”)，表示把当前Mapper类纳入spring容器。可以在其它类中直接注入了：
 */
public class MainTest {  
    User user = null;  
  
    /**  
     * 模拟从数据库中查出user对象  
     */  
     
    public void before() {  
       Role role  = new Role(2L, "administrator", "超级管理员");  
       user  = new User(1L, "zhangsan", "12345", "17677778888", "123@qq.com", role);  
    }  
  
    /**  
     * 模拟把user对象转换成UserRoleDto对象  
     */  
    public void test1() {
        before();
        UserRoleDto userRoleDto = new UserRoleDto();  
        userRoleDto.setUserId(user.getId());  
        userRoleDto.setName(user.getUsername());  
        userRoleDto.setRoleName(user.getRole().getRoleName());  
        System.out.println(userRoleDto);  
    }


    /**
     * .使用MapStruct解决
     */
    public void test3() {
        UserRoleMapper userRoleMapperInstances = UserRoleMapper.INSTANCES;
      //  UserRoleDto userRoleDto = userRoleMapperInstances.defaultConvert();
      //  System.out.println(userRoleDto);
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        mainTest.test1();
    }
}  