package com.manchesterdigital.feature;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Feature {
    private String name;
    private Boolean isEnabled;

}
