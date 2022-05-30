package com.koribsky.service;

import com.koribsky.domain.NewPoint;

import java.util.List;

public interface NewPointService {
    NewPoint insert(NewPoint p);

    NewPoint update(int id, NewPoint p);

    List<NewPoint> getAll();

    NewPoint getById(int id);



    void deleteById(int id);

}
