package com.poecat.housepaintingadmin;

import com.poecat.housepaintingadmin.controller.ClientController;
import com.poecat.housepaintingadmin.controller.CommissionController;
import com.poecat.housepaintingadmin.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HousePaintingAdminApplicationTests {

	@Autowired
	private MainController mainController;
	@Autowired
	private CommissionController commissionController;
	@Autowired
	private ClientController clientController;

	@Test
	void contextLoads() throws Exception {

		assertThat(mainController).isNotNull();
		assertThat(commissionController).isNotNull();
		assertThat(clientController).isNotNull();
	}
}
