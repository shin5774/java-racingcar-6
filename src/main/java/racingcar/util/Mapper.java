package racingcar.util;

public interface Mapper<E, T> {
    E toDto(String request);

    T toDomain(E dto);
}
