package com.felipemelozx.points_of_interest.repository;

import com.felipemelozx.points_of_interest.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {
}
