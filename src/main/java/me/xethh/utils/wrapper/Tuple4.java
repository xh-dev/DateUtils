package me.xethh.utils.wrapper;

import java.util.Objects;

public class Tuple4<V1, V2, V3, V4> {
    private V1 v1;
    private V2 v2;
    private V3 v3;
    private V4 v4;

    private Tuple4(V1 v1, V2 v2, V3 v3, V4 v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    public static <V1, V2, V3, V4> Tuple4<V1, V2, V3, V4> of(V1 v1, V2 v2, V3 v3, V4 v4) {
        return new Tuple4(v1, v2, v3, v4);
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

    public V4 getV4() {
        return v4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple4<?, ?, ?, ?> tuple4 = (Tuple4<?, ?, ?, ?>) o;
        return Objects.equals(v1, tuple4.v1) &&
                Objects.equals(v2, tuple4.v2) &&
                Objects.equals(v3, tuple4.v3) &&
                Objects.equals(v4, tuple4.v4);
    }

    @Override
    public int hashCode() {

        return Objects.hash(v1, v2, v3, v4);
    }

    @Override
    public String toString() {
        return "Tuple4{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                ", v4=" + v4 +
                '}';
    }
}
