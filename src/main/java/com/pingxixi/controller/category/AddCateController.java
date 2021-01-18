package com.pingxixi.controller.category;

import com.alibaba.fastjson.JSONObject;

import com.pingxixi.entity.Category;
import com.pingxixi.service.CategoryService;
import com.pingxixi.service.impl.CategoryServiceImpl;
import com.pingxixi.utils.ResponseEntity;
import com.pingxixi.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 1> 作业周总结
 * 2> 项目选项
 */

@WebServlet("/category/add")
public class AddCateController extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryJson = req.getParameter("category");
        Category category = JSONObject.parseObject(categoryJson, Category.class);
        ResponseEntity<Object> entity = null;
        try {
            int i = categoryService.saveCategory(category);
            if (i > 0) {
                entity = ResponseEntity.success(null);
            } else {
                entity = ResponseEntity.error(400005, "添加失败");
            }
        } catch (SQLException e) {
            entity = ResponseEntity.error(400007, "网络异常!请稍后再试!!!");
        }
        ResponseUtils.resp(resp, entity);
    }
}
