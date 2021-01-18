package com.pingxixi.dao.impl;

import com.pingxixi.dao.CategoryDao;
import com.pingxixi.entity.Category;
import com.pingxixi.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public int insert(Category category) throws SQLException {
        Connection connection = DbManager.getConnection();
        String sql = "INSERT  INTO  product_category(name,parent,keyword,img,status,recommend,cate_order) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, category.getName());
        ps.setObject(2, category.getParent());
        ps.setObject(3, category.getKeyword());
        ps.setObject(4, category.getImg());
        ps.setObject(5, category.getStatus());
        ps.setObject(6, category.getRecommend());
        ps.setObject(7, 1);
        int i = ps.executeUpdate();
        DbManager.close(connection, ps);
        return i;
    }

    @Override
    public int update(Category category) {
        return 0;
    }
}
