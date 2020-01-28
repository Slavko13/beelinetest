package com.beelinetest.service;

import com.beelinetest.entity.SalesPoints;
import org.json.JSONObject;

import java.util.List;

public interface SalesPointsService {
    JSONObject getAllSalesPointsByCoordinate(double latCoordinate, double longCoordinate, String header);
}
