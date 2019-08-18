package MultiThreadProject.concurrent;

import java.util.Optional;

public interface BoundBuffer<ValueType> {
    void add(ValueType value) throws InterruptedException;
    ValueType remove() throws InterruptedException;
    Optional<ValueType> tryRemove();
}
