package coding.monad;

public interface TrySupplier<T>{
    T get() throws Throwable;
}
