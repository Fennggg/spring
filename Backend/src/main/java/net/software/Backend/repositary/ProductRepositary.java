package net.software.Backend.repositary;

import net.software.Backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositary extends JpaRepository<ProductEntity, String>{
    
}
