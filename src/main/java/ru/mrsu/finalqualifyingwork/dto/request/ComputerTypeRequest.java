package ru.mrsu.finalqualifyingwork.dto.request;

import lombok.Getter;
import lombok.Setter;
import ru.mrsu.finalqualifyingwork.enums.ComputerTypes;

@Getter
@Setter
public class ComputerTypeRequest {
    private ComputerTypes computerType;
}
