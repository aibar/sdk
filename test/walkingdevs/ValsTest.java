package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.exceptions.$Exceptions;
import walkingdevs.exceptions.Exceptions;
import walkingdevs.exceptions.IllegalArgument;
import walkingdevs.fun.Predicate;
import walkingdevs.vals.$Vals;
import walkingdevs.vals.Vals;

public class ValsTest extends Assert {
    @Test
    public void shouldNotBeInvalid() {
        assertEquals(
            false,
            $Vals.string("myName", "Aibar Nurlanov")
                .cannotBeNULL()
                .cannotBeEmpty()
                .add("Only Aibar, No dogs", new Predicate<String>(){

                    @Override
                    public boolean test(String s) {
                        return !s.startsWith("Aibar");
                    }
                })
                .test()
        );
    }

    @Test
    public void shouldCrash() {
        try {
            $Vals.string("myName", "Reks")
                .cannotBeNULL()
                .cannotBeEmpty()
                .add("Only Aibar, No dogs", new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return !s.startsWith("Aibar");
                    }
                })
                .crash();
        } catch (Exception e) {
            assertEquals(
                IllegalArgument.class,
                e.getClass()
            );
            assertEquals(
                $Exceptions.IllegalArgument(
                    "myName",
                    "Reks",
                    "Only Aibar, No dogs"
                ).getMessage(),
                e.getMessage()
            );
        }
    }
}