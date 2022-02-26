package ir.mjimani.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Prescription {
    @Id
    private String id;
    private String doctorId;
    private String patientName;

    private String patientEmailId;

    private int duration;

    @DBRef
    private List<Medicines> medicines;
}
