package walkingdevs.http11;

public interface HttpHeaders extends Iterable<HttpHeader> {
    boolean has(String header);

    HttpHeaders add(String name, String value);

    HttpHeaders del(String name);
}