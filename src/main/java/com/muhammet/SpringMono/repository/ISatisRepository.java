package com.muhammet.SpringMono.repository;

import com.muhammet.SpringMono.repository.entity.Satis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISatisRepository extends JpaRepository<Satis,Long> {
}
