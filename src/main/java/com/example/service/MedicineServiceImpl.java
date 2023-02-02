package com.example.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.entity.Medicine;
import com.example.exception.MedicineNotFoundException;
import com.example.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineRepository medicineRepository;
    
    @Override
    public Medicine getMedicine(int id) throws MedicineNotFoundException {
		Medicine medicine = medicineRepository.getMedicines().get(id);

		if(medicine!=null)
			return medicine;

		throw new MedicineNotFoundException();
    }

    @Override
	public Boolean isAvailable(int id) throws MedicineNotFoundException {
		Medicine medicine = medicineRepository.getMedicines().get(id);
		if(medicine!=null)
			return medicine.isAvailability();

		throw new MedicineNotFoundException();
	}

	@Override
	public List<String> manufacturers(String name) throws MedicineNotFoundException {
		List<String> manufacturers = medicineRepository.getMedicines().entrySet()
				.stream()
				.map(medicineEntry->medicineEntry.getValue())
				.filter(medicine->medicine.getName()!=null && medicine.getName().equals(name))
				.map(medicine -> medicine.getManufacturer())
				.collect(Collectors.toList());

		if(manufacturers.size()==0)
			throw new MedicineNotFoundException();

		return manufacturers;
	}

	@Override
	public String getLowestPriceByManufacturer(String medicineName) throws MedicineNotFoundException {
		return medicineRepository.getMedicines().entrySet()
				.stream()
				.map(medicineEntry -> medicineEntry.getValue())
				.filter(medicine -> medicineName != null && medicineName.equalsIgnoreCase(medicine.getName()))
				.min(Comparator.comparing(Medicine::getPrice))
				.orElseThrow(MedicineNotFoundException::new).getManufacturer();
	}

}
