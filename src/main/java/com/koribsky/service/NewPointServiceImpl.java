package com.koribsky.service;

import com.koribsky.domain.NewPoint;
import com.koribsky.repository.NewPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NewPointServiceImpl implements NewPointService{
    private final NewPointRepository pointRepository;



    @Override
    @Transactional
    public NewPoint insert(NewPoint p) {
        return pointRepository.save(p);
    }

    @Override
    @Transactional
    public NewPoint update(int id, NewPoint p) {
        NewPoint point = NewPoint.builder()
                .id(id)
                .description(p.getDescription())
                .photo(p.getPhoto())
                .x(p.getX())
                .y(p.getY())
                .petName(p.getPetName())
                .petColor(p.getPetColor())
                .petContact(p.getPetContact())
                .status(p.getStatus())
                .build();

        return pointRepository.save(point);
    }

    @Override
    public List<NewPoint> getAll() {
        return pointRepository.findAll();
    }

   @Override
    public NewPoint getById(int id) {
        return pointRepository.findById(id);
    }





    @Override
    @Transactional
    public void deleteById(int id) {
        pointRepository.deleteById(id);
    }
}
