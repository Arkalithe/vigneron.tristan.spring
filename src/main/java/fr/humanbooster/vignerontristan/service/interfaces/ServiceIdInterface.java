package fr.humanbooster.vignerontristan.service.interfaces;

import java.util.List;

public interface ServiceIdInterface<T, L> {

    T findById(L id);

}