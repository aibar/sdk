package walkingdevs.http11;

public interface Headers extends Iterable<Header> {
    boolean has(String header);

    Headers add(String name, String value);

    Headers del(String name);
}