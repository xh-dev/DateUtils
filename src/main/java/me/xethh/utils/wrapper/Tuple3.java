package me.xethh.utils.wrapper;

import java.util.Objects;

public class Tuple3<V1, V2, V3> {
    private V1 v1;
    private V2 v2;
    private V3 v3;

    private Tuple3(V1 v1, V2 v2, V3 v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public static <V1, V2, V3> Tuple3<V1, V2, V3> of(V1 v1, V2 v2, V3 v3) {
        return new Tuple3(v1, v2, v3);
    }

    public V1 getV1() {
        return v1;
    }

    public V2 getV2() {
        return v2;
    }

    public V3 getV3() {
        return v3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(v1, tuple3.v1) &&
                Objects.equals(v2, tuple3.v2) &&
                Objects.equals(v3, tuple3.v3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(v1, v2, v3);
    }

    @Override
    public String toString() {
        return "Tuple3{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }
}
