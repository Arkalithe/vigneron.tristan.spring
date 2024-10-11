package fr.humanbooster.vignerontristan.service.interfaces;

import java.util.Optional;

public interface ServiceDeleteInterface<T, L, U> {

    T update(U object, L id);


}