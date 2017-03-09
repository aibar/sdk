package walkingdevs.http11;

import walkingdevs.fun.Predicate;
import walkingdevs.str.$Str;
import walkingdevs.val.$Val;

import java.util.*;

class HeadersImpl implements Headers {
    public boolean has(String header) {
        return map.containsKey(header);
    }

    public Header get(final String name) {
        $Val.mk(
            "name", name,
            new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return !has(name);
                }
            },
            "There is no header with given name"
        ).crash();
        return $Header.mk(name, map.get(name));
    }

    public Headers add(String name, String value) {
        if (!$Str.mk(value).isBlank()) {
            map.put(name, value);
        }
        return this;
    }

    public Headers del(String name) {
        map.remove(name);
        return this;
    }

    public Iterator<Header> iterator() {
        List<Header> list = new ArrayList<Header>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add($Header.mk(entry.getKey(), entry.getValue()));
        }
        return list.iterator();
    }

    private final Map<String, String> map = new HashMap<String, String>();
}