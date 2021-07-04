package com.example.thirdtryspringbootapplication.repository;

import com.example.thirdtryspringbootapplication.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {

//     @Modifying
    @Query("SELECT e FROM EmployeeEntity e WHERE e.name LIKE %:name%")
    Optional<EmployeeEntity> findByNameLike(@Param("name") String name);

}
