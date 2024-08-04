package com.example.demo.repository;

import com.example.demo.entity.PageMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageModeRepository  extends JpaRepository<PageMode, Long> {

}
