package ru.mrsu.finalqualifyingwork.entity.computers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import ru.mrsu.finalqualifyingwork.entity.computers.impl.Desktop;
import ru.mrsu.finalqualifyingwork.entity.computers.impl.Laptop;
import ru.mrsu.finalqualifyingwork.enums.ComputerTypes;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type") @JsonSubTypes({
        @JsonSubTypes.Type(value = Laptop.class, name = ComputerTypes.Fields.LAPTOP),
        @JsonSubTypes.Type(value = Desktop.class, name = ComputerTypes.Fields.DESKTOP)
})
@Document("computer")
@JsonIgnoreProperties(value = {"type"}, allowSetters = true)
@Validated
public class Computer {
    @Id
    private String id;
    @NotNull
    private ComputerTypes type;
    private String brand;
    private String name;
    private Double price;
    private Specifications specifications;

    public Computer(ComputerTypes type, Specifications specifications) {
        this.type = type;
        this.specifications = specifications;
    }

    public Computer(ComputerTypes type) {
        this.type = type;
    }
}
