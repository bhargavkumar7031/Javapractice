package org.example.repository;

import org.example.classes.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Integer>{
    @Query("SELECT t FROM Task t WHERE t.status = :status")
    public List<Task> findByStatus(@Param("status") String status);
}
