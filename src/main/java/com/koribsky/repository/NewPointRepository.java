package com.koribsky.repository;

import com.koribsky.domain.NewPoint;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewPointRepository extends JpaRepository<NewPoint, Integer> {
    @Override
    //@EntityGraph(attributePaths = {"description", "photo", "X", "Y"})
    List<NewPoint> findAll();

    NewPoint findByDescription(String description);

    NewPoint findById(long id);

    NewPoint findByX(double x);


}
