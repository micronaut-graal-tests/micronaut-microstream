package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.ReflectiveAccess;

import java.util.HashMap;
import java.util.Map;

@Introspected // <1>
@ReflectiveAccess
public class Data {
    private Map<String, Customer> customers = new HashMap<>();

    @NonNull
    public Map<String, Customer> getCustomers() {
        return this.customers;
    }
}
