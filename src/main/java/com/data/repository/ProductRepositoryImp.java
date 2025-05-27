package com.data.repository;

import com.data.connection.ConnectionDB;
import com.data.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @Override
    public boolean addProduct(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_product(?,?,?,?,?,?,?)}");
            callSt.setString(1, product.getProduct_name());
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return false;
    }
}
