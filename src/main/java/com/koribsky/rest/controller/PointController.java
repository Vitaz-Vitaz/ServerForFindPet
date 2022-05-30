package com.koribsky.rest.controller;

import com.koribsky.domain.NewPoint;
import com.koribsky.rest.dto.PointDto;
import com.koribsky.service.NewPointService;
import lombok.RequiredArgsConstructor;
import org.h2.expression.Variable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PointController {
    private final NewPointService pointService;

    @GetMapping("/point")
    public List<PointDto> getAllPoints() {

        return pointService
                .getAll()
                .stream()
                .map(PointDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/point")
    public PointDto insertPoint(@RequestBody PointDto pointDto)
    {
        return PointDto.toDto(pointService.insert(PointDto.toDomainObject(pointDto)));
    }

    @PutMapping("point{id}")
    public PointDto updatePoint(@PathVariable int id, @RequestParam NewPoint point)
    {
        NewPoint point1 = pointService.update(id, point);
        return PointDto.toDto(point1);
    }

    @DeleteMapping("/point/{id}")
    public void deletePointById(@PathVariable int id) {

        pointService.deleteById(id);
    }
    @GetMapping("/point/{id}")
    public PointDto getPointById(@PathVariable int id) {

        return PointDto.toDto(pointService.getById(id));
    }

//    @GetMapping("/author/name")
//    public PointDto getPointByX(@RequestParam double X) {
//
//        return PointDto.toDto(pointService.getByX(X));
//    }

}
