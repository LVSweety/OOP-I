package lv.lvs.backend.model.communicationsInterfaces;

import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.parcel.City;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PCustomerCreate {

    @NotNull
    @Pattern(regexp = "[0-9]{8}")
    private String phoneNo;

	@NotNull
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String name;
	
	@NotNull
	@Size(min = 2, max = 40)
	@Pattern(regexp = "[A-Z]{1}[a-z]+") 
	private String surname;

	@NotNull
	@Size(min = 2, max = 40)
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}") 
	private String personCode;

    @NotNull
    private City city;

    @NotNull
    @Size(min = 2, max = 100)
    @Pattern(regexp = "[A-Z]{1}[a-z ]+")
    private String streetHouseTitle;

    @Min(0)
    private int houseNo;

}
