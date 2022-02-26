package ir.mjimani.demo;

import ir.mjimani.demo.domain.Medicines;
import ir.mjimani.demo.domain.Prescription;
import ir.mjimani.demo.repository.MedicinesRepository;
import ir.mjimani.demo.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private MedicinesRepository medicinesRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            Prescription prescription = Prescription.builder()
                    .doctorId("621900fbaedad32aa7bec85b")
                    .patientName("devas")
                    .patientEmailId("devashishdeshpande@gmail.com")
                    .duration(7)
                    .build();

            List<Medicines> medicinesList = new ArrayList<>();
            Medicines medicines = Medicines.builder()
                    .medicineName("colpol")
                    .dosage(500)
                    .timings(new int[]{1, 0, 1})
                    .build();
            medicinesList.add(medicines);
            medicines = Medicines.builder()
                    .medicineName("Others")
                    .dosage(500)
                    .timings(new int[]{1, 0, 1})
                    .build();
            medicinesList.add(medicines);
            // Save
            medicinesList = medicinesRepository.saveAll(medicinesList);

            prescription.setMedicines(medicinesList);
            // Save
            prescription = prescriptionRepository.save(prescription);

            List<Prescription> prescriptions = prescriptionRepository.findAll();
            System.out.println("prescriptions = " + prescriptions);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
