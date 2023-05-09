package ru.mrsu.finalqualifyingwork.entity.computers;

import lombok.Getter;
import lombok.Setter;
import ru.mrsu.finalqualifyingwork.enums.ComputerOS;

@Getter
@Setter
public class Specifications {
    private String CPU;
    private String GPU;
    private Integer RAM;
    private Integer hardDrive;
    private ComputerOS os;
}
