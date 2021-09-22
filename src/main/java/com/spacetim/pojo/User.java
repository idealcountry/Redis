package com.spacetim.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author spacetim
 * @date 2021/8/27
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private String name;
    private int age;
}
