package com.felipemelozx.points_of_interest.service;

import com.felipemelozx.points_of_interest.dto.GetPointDto;
import com.felipemelozx.points_of_interest.dto.PointDto;
import com.felipemelozx.points_of_interest.entity.Point;
import com.felipemelozx.points_of_interest.repository.PointRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointService {
  private final PointRepository pointRepository;

  public PointService(PointRepository pointRepository) {
    this.pointRepository = pointRepository;
  }

  public List<PointDto> getPoints(GetPointDto requestDto) {
      List<Point> pointList = pointRepository.findAll();
      List<PointDto> responseDtoList = new ArrayList<>();

      for(Point point : pointList){

        long partX = point.getCoordinateX() - requestDto.coordinateX();
        long partY = point.getCoordinateY() - requestDto.coordinateY();

        long resultPowX = (long) Math.pow(partX, 2);
        long resultPowY = (long) Math.pow(partY, 2);

        long sum = resultPowX + resultPowY;

        double resultSqrt = Math.sqrt(sum);
        if(resultSqrt <= requestDto.maxD()){
          responseDtoList.add(new PointDto(point));
        }
      }
      return responseDtoList;
  }

  public void createPoint(PointDto pointDto){
    if(pointDto.coordinateX() < 0 && pointDto.coordinateY() < 0 ){
      return;
    }

    pointRepository.save(new Point(pointDto));
  }

  public void createManyPoint(List<PointDto> listPointDto) {
    for(PointDto pointDto : listPointDto){
      if(!(pointDto.coordinateX() < 0 && pointDto.coordinateY() < 0) ){
        pointRepository.save(new Point(pointDto));
      }
    }
  }
}
