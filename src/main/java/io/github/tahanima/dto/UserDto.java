package io.github.tahanima.dto;

import com.univocity.parsers.annotations.Parsed;

import lombok.Getter;
import lombok.ToString;

/**
 * @author tahanima
 */
@Getter
@ToString(callSuper = true)
public class UserDto extends BaseDto {

    @Parsed(field = "ID", defaultNullRead = "")
    private String id;

    @Parsed(field = "User Name", defaultNullRead = "")
    private String userName;

    @Parsed(field = "Password", defaultNullRead = "")
    private String password;
}
