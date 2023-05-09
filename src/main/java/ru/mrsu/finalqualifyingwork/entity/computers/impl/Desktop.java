package ru.mrsu.finalqualifyingwork.entity.computers.impl;

import lombok.Getter;
import lombok.Setter;
import ru.mrsu.finalqualifyingwork.entity.computers.Computer;
import ru.mrsu.finalqualifyingwork.entity.computers.DesktopCase;
import ru.mrsu.finalqualifyingwork.enums.ComputerTypes;

@Getter
@Setter
public class Desktop extends Computer {
    private DesktopCase desktopCase;
    Desktop() {
        super(ComputerTypes.DESKTOP);
    }
}
