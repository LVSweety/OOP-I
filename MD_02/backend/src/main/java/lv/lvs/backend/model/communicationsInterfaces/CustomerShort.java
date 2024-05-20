package lv.lvs.backend.model.communicationsInterfaces;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerShort {
    @NonNull
    @Size(max = 150)
    private String customerCode;

    public CustomerShort(String customerCode) {
        setCustomerCode(customerCode);
    }
    
}
