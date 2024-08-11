package com.capstone.tealeaf.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CreateProductFormBean {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;

}
