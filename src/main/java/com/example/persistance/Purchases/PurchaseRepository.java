package com.example.persistance.Purchases;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PurchaseRepository {
    //We have to inject the jdbc template
    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase){
        String sql = "INSERT INTO purchase (product,price) VALUES (?,?)";

        jdbc.update(sql,purchase.getProduct(),purchase.getPrice());
    }

    //A method for getting all purchases
    public List<Purchase> findAllPurchases(){
        String sql = "SELECT * FROM purchase";
        //We will need a RowMapper so we'll implement it with an anonymous inner class
        RowMapper<Purchase> purchaseRowMapper = new RowMapper<Purchase>() {
            @Override
            public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Purchase rowObject = new Purchase();
                rowObject.setId(rs.getInt("id"));
                rowObject.setProduct(rs.getString("product"));
                rowObject.setPrice(rs.getBigDecimal("price"));
                return rowObject;
            }
        };

        return jdbc.query(sql,purchaseRowMapper);
    }
}
