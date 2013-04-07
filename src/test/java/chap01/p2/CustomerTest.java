/*
 * Copyright 2013 OSABE Satoshi (andropenguin@gmail.com)                                  
 *                                                                              
 * Licensed under the Apache License, Version 2.0 (the "License");              
 * you may not use this file except in compliance with the License.             
 * You may obtain a copy of the License at                                      
 *                                                                              
 *      http://www.apache.org/licenses/LICENSE-2.0                              
 *                                                                              
 * Unless required by applicable law or agreed to in writing, software          
 * distributed under the License is distributed on an "AS IS" BASIS,            
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.     
 * See the License for the specific language governing permissions and          
 * limitations under the License.                                               
 *
 * This test file is for testing the statment method of Customer class
 * in p.2 of Refactoring Japanese Edition. It is a test for
 * statment method supporting ascii format.
 */

package chap01.p2;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	Customer foo;
	
	@Before
	public void setUp() throws Exception {
		foo = new Customer("foo");
	}
	
	@Test
	public void statement_regular_days_rented_is_1() {
		Movie movie = new Movie("movie1", Movie.REGULAR);
		int daysRented = 1;
		Rental rental1 = new Rental(movie, daysRented);
		foo.addRental(rental1);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
		"\t" + "movie1" + "\t" + "2.0" + "\n" +
		"Amount owed is 2.0\n" +
		"You earned 1 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_regular_days_rented_is_3() {
		Movie movie = new Movie("movie1", Movie.REGULAR);
		int daysRented = 3;
		Rental rental1 = new Rental(movie, daysRented);
		foo.addRental(rental1);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "3.5" + "\n" +
				"Amount owed is 3.5\n" +
				"You earned 1 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_new_release_days_rented_is_1() {
		Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
		int daysRented = 1;
		Rental rental1 = new Rental(movie, daysRented);
		foo.addRental(rental1);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "3.0" + "\n" +
				"Amount owed is 3.0\n" +
				"You earned 1 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_new_release_days_rented_is_2() {
		Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
		int daysRented = 2;
		Rental rental1 = new Rental(movie, daysRented);
		foo.addRental(rental1);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "6.0" + "\n" +
				"Amount owed is 6.0\n" +
				"You earned 2 frequent renter points";
		assertThat(result, is(expected_result));		
	}
	
	@Test
	public void statement_childrens_days_rented_is_2() {
		Movie movie = new Movie("movie1", Movie.CHILDRENS);
		int daysRented = 1;
		Rental rental1 = new Rental(movie, daysRented);
		foo.addRental(rental1);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "1.5" + "\n" +
				"Amount owed is 1.5\n" +
				"You earned 1 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_childrens_days_rented_is_4() {
		Movie movie = new Movie("movie1", Movie.CHILDRENS);
		int daysRented = 4;
		Rental rental1 = new Rental(movie, daysRented);
		foo.addRental(rental1);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "3.0" + "\n" +
				"Amount owed is 3.0\n" +
				"You earned 1 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_regular_days_rented_is_1_and_regular_days_rented_is_3() {
		Movie movie1 = new Movie("movie1", Movie.REGULAR);
		int daysRented1 = 1;
		Rental rental1 = new Rental(movie1, daysRented1);
		foo.addRental(rental1);
		Movie movie2 = new Movie("movie2", Movie.REGULAR);
		int daysRented2 = 3;
		Rental rental2 = new Rental(movie2, daysRented2);
		foo.addRental(rental2);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "2.0" + "\n" +
				"\t" + "movie2" + "\t" + "3.5" + "\n" +
				"Amount owed is 5.5\n" +
				"You earned 2 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_regular_days_rented_is_1_and_new_release_days_rented_is_1() {
		Movie movie1 = new Movie("movie1", Movie.REGULAR);
		int daysRented1 = 1;
		Rental rental1 = new Rental(movie1, daysRented1);
		foo.addRental(rental1);
		Movie movie2 = new Movie("movie2", Movie.NEW_RELEASE);
		int daysRented2 = 1;
		Rental rental2 = new Rental(movie2, daysRented2);
		foo.addRental(rental2);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "2.0" + "\n" +
				"\t" + "movie2" + "\t" + "3.0" + "\n" +
				"Amount owed is 5.0\n" +
				"You earned 2 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_regular_days_rented_is_1_and_childrens_days_rented_is_2() {
		Movie movie1 = new Movie("movie1", Movie.REGULAR);
		int daysRented1 = 1;
		Rental rental1 = new Rental(movie1, daysRented1);
		foo.addRental(rental1);
		Movie movie2 = new Movie("movie2", Movie.CHILDRENS);
		int daysRented2 = 1;
		Rental rental2 = new Rental(movie2, daysRented2);
		foo.addRental(rental2);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "2.0" + "\n" +
				"\t" + "movie2" + "\t" + "1.5" + "\n" +
				"Amount owed is 3.5\n" +
				"You earned 2 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_new_release_days_rented_is_1_and_new_release_days_rented_is_2() {
		Movie movie1 = new Movie("movie1", Movie.NEW_RELEASE);
		int daysRented1 = 1;
		Rental rental1 = new Rental(movie1, daysRented1);
		foo.addRental(rental1);
		Movie movie2 = new Movie("movie2", Movie.NEW_RELEASE);
		int daysRented2 = 1;
		Rental rental2 = new Rental(movie2, daysRented2);
		foo.addRental(rental2);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "3.0" + "\n" +
				"\t" + "movie2" + "\t" + "3.0" + "\n" +
				"Amount owed is 6.0\n" +
				"You earned 2 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_new_release_days_rented_is_1_and_childrens_days_rented_is_2() {
		Movie movie1 = new Movie("movie1", Movie.NEW_RELEASE);
		int daysRented1 = 1;
		Rental rental1 = new Rental(movie1, daysRented1);
		foo.addRental(rental1);
		Movie movie2 = new Movie("movie2", Movie.CHILDRENS);
		int daysRented2 = 2;
		Rental rental2 = new Rental(movie2, daysRented2);
		foo.addRental(rental2);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "3.0" + "\n" +
				"\t" + "movie2" + "\t" + "1.5" + "\n" +
				"Amount owed is 4.5\n" +
				"You earned 2 frequent renter points";
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void statement_childrens_days_rented_is_2_and_childrens_days_rented_is_4() {
		Movie movie1 = new Movie("movie1", Movie.CHILDRENS);
		int daysRented1 = 2;
		Rental rental1 = new Rental(movie1, daysRented1);
		foo.addRental(rental1);
		Movie movie2 = new Movie("movie2", Movie.CHILDRENS);
		int daysRented2 = 4;
		Rental rental2 = new Rental(movie2, daysRented2);
		foo.addRental(rental2);
		String result = foo.statement();
		String expected_result = "Rental Record for foo\n" +
				"\t" + "movie1" + "\t" + "1.5" + "\n" +
				"\t" + "movie2" + "\t" + "3.0" + "\n" +
				"Amount owed is 4.5\n" +
				"You earned 2 frequent renter points";
		assertThat(result, is(expected_result));
	}
}
