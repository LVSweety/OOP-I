package lv.lvs.backend.model.communicationsInterfaces;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerInsert {
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z]{1}[a-z]+")
    private String name;
        
    @NotNull
    @Size(min = 2, max = 40)
    @Pattern(regexp = "[A-Z]{1}[a-z]+") 
    private String surname;

}

