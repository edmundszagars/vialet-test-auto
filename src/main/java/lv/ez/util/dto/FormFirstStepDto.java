package lv.ez.util.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FormFirstStepDto implements Serializable {
    private String tag;
    private String firstName;
    private String lastName;
    private String peselCode;
    private String email;
    private String phoneNr;
}
