package com.example.service;
import java.util.List;

import com.example.entity.Medicine;
import com.example.exception.MedicineNotFoundException;
import org.springframework.stereotype.Service;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

public interface MedicineService {
    Medicine getMedicine(int  id) throws MedicineNotFoundException;
    Boolean isAvailable(int id) throws MedicineNotFoundException;
    List<String> manufacturers(String name) throws MedicineNotFoundException;
    String getLowestPriceByManufacturer(String medicineName) throws MedicineNotFoundException;
}
