package com.cw.dto;

import java.io.Serializable;

public record UserBean(String firstName, String lastName, String phone, 
						String mailId, String address, String username, String password ) implements Serializable {

}
