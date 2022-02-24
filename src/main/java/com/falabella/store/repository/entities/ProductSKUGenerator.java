package com.falabella.store.repository.entities;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSKUGenerator extends SequenceStyleGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {


        String prefix = "FAL";
        Connection connection = session.connection();
        try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT MAX(sku) from product");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String sku = rs.getString("sku");
                sku = sku.replace("FAL","");

                String code = prefix + Integer.valueOf(sku);
                System.out.println("Generated Stock Code: " + code);
                return code;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
