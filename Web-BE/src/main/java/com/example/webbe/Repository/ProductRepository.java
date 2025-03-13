package com.example.webbe.Repository;

import com.example.webbe.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("""
SELECT p FROM product p LEFT JOIN FETCH p.category WHERE p.id = :id""")
    Optional<Product> findProductById(@Param("id") String id);

    @Query("""
                SELECT p FROM product p LEFT JOIN FETCH p.category
    """)
    List<Product> findAllProducts();
}
