package com.pingxixi.service.impl;

import com.pingxixi.dao.CategoryDao;
import com.pingxixi.dao.impl.CategoryDaoImpl;
import com.pingxixi.entity.Category;

import com.pingxixi.proxy.DaoProxy;
import com.pingxixi.service.CategoryService;

import java.sql.SQLException;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    public CategoryServiceImpl() {
        DaoProxy daoProxy = new DaoProxy();
        categoryDao = (CategoryDao) daoProxy.newProxyInstance(new CategoryDaoImpl());
    }


    @Override
    public int saveCategory(Category category) throws SQLException {
        int count = categoryDao.insert(category);
        return count;
    }
}
