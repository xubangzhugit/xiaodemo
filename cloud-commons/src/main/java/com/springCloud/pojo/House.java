package com.springCloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class House implements Serializable {
    private Integer uid;
    private String username;
    private String password;

}
