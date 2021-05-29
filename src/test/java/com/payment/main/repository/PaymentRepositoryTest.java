package com.payment.main.repository;

//import org.apache.http.util.Asserts;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentRepositoryTest {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	void testPaymentRepositoryWorking() {
		assertThat(paymentRepository).isNotNull();

	}

}
