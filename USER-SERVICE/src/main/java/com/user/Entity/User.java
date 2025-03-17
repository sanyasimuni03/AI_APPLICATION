package com.user.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	    private Integer id;
	    private String email;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private String phoneNumber;
	    @CreatedDate
	    private LocalDateTime time;
	    

}
