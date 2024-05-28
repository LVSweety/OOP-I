package lv.lvs.backend.model.communicationsInterfaces;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerShort {

    @Min(1)
    private int id;

    private char type;

    @NonNull
    @Size(max = 150)
    private String customerCode;

    public CustomerShort(int id, char type, String customerCode) {
        setId(id);
        setType(type);
        setCustomerCode(customerCode);
    }
    
}
