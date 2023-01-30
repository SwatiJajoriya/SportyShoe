package com.ecommerce.demo.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BankData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int bid;
		private String bname;
		private long amount;
}
