package ru.mrsu.finalqualifyingwork.entity.computers.impl;

import lombok.Getter;
import lombok.Setter;
import ru.mrsu.finalqualifyingwork.entity.computers.Computer;
import ru.mrsu.finalqualifyingwork.entity.computers.Specifications;
import ru.mrsu.finalqualifyingwork.enums.ComputerTypes;

@Getter
@Setter
public class Laptop extends Computer {
    private Double screenDiagonal;
    private Double weight;

    Laptop() {
        super(ComputerTypes.LAPTOP);
    }

    public Laptop(Specifications specifications, Double screenDiagonal, Double weight) {
        super(ComputerTypes.LAPTOP, specifications);
        this.screenDiagonal = screenDiagonal;
        this.weight = weight;
    }
}
