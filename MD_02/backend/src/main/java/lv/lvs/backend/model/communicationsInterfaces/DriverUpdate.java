package lv.lvs.backend.model.communicationsInterfaces;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DriverUpdate {
	
	private int idD;

    @Min(0)
    private float experienceInYears;
    
    @NotNull
    @Pattern(regexp = "[A-Z]{2}[0-9]{6}")
    private String licenseNo;

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
}
