package com.springboot.jpa.data.repository;
import com.springboot.jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//리포지토리 인터페이스 생성
public interface ProductRepository extends JpaRepository<Product, Long> { // ProductRepository가 JpaRepository를 상속받을 때는 대상 엔티티와 기본값 타입을 지정해야 함.
    
}
