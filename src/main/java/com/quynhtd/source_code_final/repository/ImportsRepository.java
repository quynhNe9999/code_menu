package com.quynhtd.source_code_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtd.source_code_final.entity.Imports;

@Repository
public interface ImportsRepository extends JpaRepository<Imports, Long>  {
   
}
