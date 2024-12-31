package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//POJO plain java object class (bean)

@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
//@ToString
@Data
public class Book {
	
	private int bid;
	private String bname;
	private int price;
	private String publisher;

}
