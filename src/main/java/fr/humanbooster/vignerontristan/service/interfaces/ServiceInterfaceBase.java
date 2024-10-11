package fr.humanbooster.vignerontristan.service.interfaces;

import java.util.Optional;

public interface ServiceInterfaceBase<T, C> {

    T create(C object);

}