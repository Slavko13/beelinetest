package com.beelinetest.service;


import com.beelinetest.entity.SalesPoints;
import com.beelinetest.repository.SalesPointsRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SalesPointsServiceImpl implements SalesPointsService {

    @Autowired
    private SalesPointsRepository salesPointsRepository;


    @Override
    public JSONObject getAllSalesPointsByCoordinate(double latCoordinate, double longCoordinate, String header) {
        List<SalesPoints> salesPoints = salesPointsRepository.findAllByCity(getCityNameByCoordinate(latCoordinate, longCoordinate));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("spList", "");
        for (int i = 0; i < salesPoints.size(); i++) {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("name", salesPoints.get(i).getName());
            jsonObject1.put("address", salesPoints.get(i).getAddress());
            jsonObject1.put("city", salesPoints.get(i).getCity());
            jsonObject.accumulate("spList", jsonObject1);
        }

        return jsonObject;
    }

    private String getCityNameByCoordinate(double latCoordinate, double longCoordinate) {
        //Здесь должно быть нахождения города по координатам, но кончился пробный период гугл карт.
        //Поэтому здесь пока что такой метод, который заменяет нахождение города

        Random random = new Random();
        int i = random.nextInt(2);

        List<String> cities = new ArrayList<>();
        cities.add("Москва");
        cities.add("Сочи");
        cities.add("Тверь");

        return cities.get(i);
    }
}
