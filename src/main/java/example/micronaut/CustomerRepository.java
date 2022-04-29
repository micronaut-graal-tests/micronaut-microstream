package example.micronaut;

import io.micronaut.core.annotation.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;

public interface CustomerRepository {

    @NonNull
    Collection<Customer> list();

    @NonNull
    Customer save(@NonNull @NotNull @Valid CustomerSave customerSave);

    void update(@NonNull @NotBlank String id,
                @NonNull @NotNull @Valid CustomerSave customerSave);

    @NonNull
    Optional<Customer> findById(@NonNull @NotBlank String id);

    void deleteById(@NonNull @NotBlank String id);
}
