package ru.mrsu.finalqualifyingwork.enums;

import lombok.experimental.FieldNameConstants;

@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum ComputerTypes {
    @FieldNameConstants.Include DESKTOP,
    @FieldNameConstants.Include LAPTOP
}
