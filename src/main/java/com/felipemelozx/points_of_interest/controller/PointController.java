package com.felipemelozx.points_of_interest.controller;

import com.felipemelozx.points_of_interest.dto.GetPointDto;
import com.felipemelozx.points_of_interest.dto.PointDto;
import com.felipemelozx.points_of_interest.service.PointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/point-interest")
public class PointController {

  private final PointService pointService;

  public PointController(PointService pointService) {
    this.pointService = pointService;
  }

  @PostMapping(path = "/save-many-points")
  public void createManyPoint(@RequestBody Map<String, List<PointDto>> body){
    List<PointDto> pointDto = body.get("listPointDto");
    pointService.createManyPoint(pointDto);
  }
  @GetMapping
  public List<PointDto> getPoints(@RequestBody GetPointDto requestDto){
    return pointService.getPoints(requestDto);
  }

  @GetMapping(path = "/get-all")
  public List<PointDto> getAllPoints(){
    return pointService.findAll();
  }

  @PostMapping(path = "/save-point")
  public PointDto createPoint(@RequestBody PointDto pointDto){
     var res =pointService.createPoint(pointDto);
      if(res == null){
        throw new RuntimeException("Point not save!");
      }
      return res;
  }

}
