package me.xethh.utils.wrapper;

import java.util.Objects;

public class Optional<X> {
    private X something;
    public static Optional EMPTY = new Optional(null);
    private Optional(X something){
        this.something = something;
    }

    public static <X> Optional<X> of(X something){
        return new Optional<>(something);
    }

    public boolean isPresent(){
        return something!=null;
    }

    public boolean isEmpty(){
        return !isPresent();
    }

    public X get(){
        return something;
    }

    public X orElse(X other){
        return isPresent()?something:other;
    }

    @Override
    public String toString() {
        return "Optional{" +
                "something=" + something +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Optional<?> optional = (Optional<?>) o;
        return Objects.equals(something, optional.something);
    }

    @Override
    public int hashCode() {

        return Objects.hash(something);
    }
}
