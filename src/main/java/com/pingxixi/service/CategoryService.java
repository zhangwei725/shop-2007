package com.pingxixi.service;

import com.pingxixi.dao.CategoryDao;
import com.pingxixi.dao.impl.CategoryDaoImpl;
import com.pingxixi.entity.Category;
import com.pingxixi.proxy.DaoProxy;

import java.lang.reflect.InvocationHandler;
import java.sql.SQLException;

public interface CategoryService {
    int saveCategory(Category category) throws SQLException;
}