package com.felipemelozx.points_of_interest.entity;

import com.felipemelozx.points_of_interest.dto.PointDto;
import jakarta.persistence.*;

@Entity
@Table(name = "point-of-interest")
public class Point {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Long coordinateX;

  private Long coordinateY;

  public Point(Long id, Long coordinateX, Long coordinateY, String name) {
    this.id = id;
    this.name = name;
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }
  public Point(PointDto pointDto){
    this.name = pointDto.name();
    this.coordinateX = pointDto.coordinateX();
    this.coordinateY = pointDto.coordinateY();
  }

  public Point() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getCoordinateX() {
    return coordinateX;
  }

  public void setCoordinateX(Long coordinateX) {
    this.coordinateX = coordinateX;
  }

  public Long getCoordinateY() {
    return coordinateY;
  }

  public void setCoordinateY(Long coordinateY) {
    this.coordinateY = coordinateY;
  }
}
