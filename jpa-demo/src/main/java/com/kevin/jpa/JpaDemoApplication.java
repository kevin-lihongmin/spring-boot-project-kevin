package com.kevin.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	public void get() {
		/*JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		JPAQuery<Tuple> jpaQuery = queryFactory
				.select(QTCity.tCity.id,QTHotel.tHotel)
				.from(QTCity.tCity)
				.leftJoin(QTHotel.tHotel)
				.on(QTHotel.tHotel.city.longValue().eq(QTCity.tCity.id.longValue()))
				.where(predicate)
				.offset(pageable.getOffset())
			.limit(pageable.getPageSize());*/
	}
}
