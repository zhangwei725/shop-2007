package com.pingxixi.dao;

import com.pingxixi.entity.Category;

import java.sql.SQLException;

/**
 * 完整度
 * 使用反射技术
 * 实例化Class对象
 * 1.创建对象
 * 2.获取所有的属性 给属性赋值  Field   set()
 * 3.获取所有的方法 执行方法    Method  invoke()
 */
public interface CategoryDao {
    int insert(Category category) throws SQLException;

    int update(Category category);
}
