package com.kito.orm;

import lombok.Data;

@Data
public class Country {
    private Long id;
    private String countryName;
    private String countryCode;
}
