package com.manudev.dto;

import com.manudev.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long userId;
    private String name;
    private String email;
    private String rol;
    private boolean active;
    private List<Order> orderList = new ArrayList<>();
}
