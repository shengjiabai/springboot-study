package com.bzy.service.other.beanCopy.model;


public class UserRoleDto {  
    /**  
     * 用户id  
     */  
    private Long userId;  
    /**  
     * 用户名  
     */  
    private String name;  
    /**  
     * 角色名  
     */  
    private String roleName;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}  