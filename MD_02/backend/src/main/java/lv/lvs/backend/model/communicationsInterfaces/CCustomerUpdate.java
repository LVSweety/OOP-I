package lv.lvs.backend.model.communicationsInterfaces;

import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.parcel.City;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CCustomerUpdate {
    
    @Min(1)
    private int id;

    @Size(min = 5, max = 150)
    private String customerCode;

    @NotNull
    @Pattern(regexp = "[0-9]{8}")
    private String phoneNo;

    @NonNull
    @Pattern(regexp = "LV[0-9]{11}")
    private String regNo;

    @NonNull
    @Size(min = 5, max = 100)
    private String title;

    @NotNull
    private City city;

    @NotNull
    @Size(min = 2, max = 100)
    @Pattern(regexp = "[A-Z]{1}[a-z ]+")
    private String streetHouseTitle;

    @Min(0)
    private int houseNo;

}
