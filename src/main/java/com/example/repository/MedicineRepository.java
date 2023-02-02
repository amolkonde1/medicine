package com.example.repository;

import java.util.HashMap;

import com.example.entity.Medicine;
import org.springframework.stereotype.Repository;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

public interface MedicineRepository {
    HashMap<Integer, Medicine> getMedicines();
}
