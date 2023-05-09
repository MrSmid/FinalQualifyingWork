package ru.mrsu.finalqualifyingwork.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetweenRequest {
    private Double lte;
    private Double gte;
}
