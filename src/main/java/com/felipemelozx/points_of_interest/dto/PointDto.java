package com.felipemelozx.points_of_interest.dto;

import com.felipemelozx.points_of_interest.entity.Point;

public record PointDto(String name, Long coordinateX, Long coordinateY) {


  public PointDto(Point point){
    this(point.getName(), point.getCoordinateX(), point.getCoordinateY());
  }
}
