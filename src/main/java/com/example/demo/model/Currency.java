package com.example.demo.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("currencies")
public class Currency {
    public enum Types {
        PHYSICAL,
        DIGITAL
    }

    @Id
    Long id;

    public Enum<Types> type;

    @NotNull
    @Min(1)
    @Max(10)
    public String symbol;
}
