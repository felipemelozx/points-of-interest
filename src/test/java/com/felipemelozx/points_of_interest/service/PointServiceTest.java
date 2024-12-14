package com.felipemelozx.points_of_interest.service;

import com.felipemelozx.points_of_interest.dto.GetPointDto;
import com.felipemelozx.points_of_interest.dto.PointDto;
import com.felipemelozx.points_of_interest.entity.Point;
import com.felipemelozx.points_of_interest.repository.PointRepository;
import jakarta.servlet.http.PushBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PointServiceTest {

  @Mock
  private PointRepository pointRepository;

  private PointService pointService;

  private List<Point> points;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    pointService = new PointService(pointRepository);
    points = List.of(
        new Point(1L,27L, 12L,"Lanchonete"),
        new Point(2L,31L, 18L, "Posto"),
        new Point(3L,15L, 12L,"Joalheria"),
        new Point(4L,19L, 21L,"Floricultura"),
        new Point(5L, 12L, 8L, "Pub"),
        new Point(6L, 23L, 6L, "Supermercado"),
        new Point(7L, 28L, 2L, "Churrascaria")
    );
  }

  @Test
  void getPointsCaseSuccess() {

    GetPointDto requestDto = new GetPointDto(20L, 10L, 10.0);
    when(pointRepository.findAll()).thenReturn(List.of(points.get(0), points.get(2),points.get(4),points.get(5)));

    List<PointDto> result = pointService.getPoints(requestDto);

    assertEquals(4, result.size(), "Must return 4 points within range.");

    PointDto returnedPoint = result.get(0);
    assertEquals(points.get(0).getCoordinateX(), returnedPoint.coordinateX(), "The returned point must have the correct X coordinate.");
    assertEquals(points.get(0).getCoordinateY(), returnedPoint.coordinateY(), "The returned point must have the correct Y coordinate.");
    assertEquals(points.get(0).getName(), returnedPoint.name(), "The returned point must have a name correct.");

  }

  @Test
  void createPointCaseSuccess() {
    PointDto requestDto = new PointDto("Buteco", 20L, 10L);
    Point savedPoint = new Point(requestDto);
    PointDto expectedPointDto = new PointDto(savedPoint);


    when(pointRepository.save(any(Point.class))).thenReturn(savedPoint);

    PointDto response = pointService.createPoint(requestDto);

    assertEquals(response.name(), requestDto.name(), "The returned point must have a name correct.");
    assertEquals(response.coordinateX(), requestDto.coordinateX(), "The returned point must have the correct X coordinate.");
    assertEquals(response.coordinateY(), requestDto.coordinateY(), "The returned point must have the correct Y coordinate.");
  }

  @Test
  void createManyPoint() {

  }

  @Test
  void findAll() {
  }
}