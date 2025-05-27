package com.data.repository;

import com.data.connection.ConnectionDB;
import com.data.model.Category;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryRepositoryImp implements CategoryRepository{
    @Override
    public boolean addCategory(Category category) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_category(?,?,?)}");
            callSt.setString(1, category.getCategory_name());
            callSt.setString(2, category.getDescription());
            callSt.setBoolean(3, category.isStatus());
            boolean result = callSt.execute();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public List<Category> findAllCategory() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Category> categoryList = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_category()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategory_id(rs.getInt("category_id"));
                category.setCategory_name(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                categoryList.add(category);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return categoryList;
    }

    @Override
    public boolean updateCategory(Category category) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_category(?,?,?,?)}");
            callSt.setInt(1, category.getCategory_id());
            callSt.setString(2, category.getCategory_name());
            callSt.setString(3, category.getDescription());
            callSt.setBoolean(4, category.isStatus());
            boolean result = callSt.execute();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public Category findCategoryById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Category category = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_category_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setCategory_id(rs.getInt("category_id"));
                category.setCategory_name(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return category;
    }

    @Override
    public List<Category> findCategoryByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Category> categoryList = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_category_name(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategory_id(rs.getInt("category_id"));
                category.setCategory_name(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                categoryList.add(category);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return categoryList;
    }
}
