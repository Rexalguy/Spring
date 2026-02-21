package com.example.login;

import com.example.login.Controllers.LoginProcessor;
import com.example.login.Controllers.MainController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.awaitility.Awaitility.given;
import static org.mockito.Mockito.verify;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LoginApplicationTests {

	//Mocks for the login controller
	@Mock
	private Model model;

	@Mock
	private LoginProcessor loginProcessor;

	@InjectMocks
	private MainController mainController;


	@Test
	void postLoginSucceedsTest() {
		given(loginProcessor.login())
				.willReturn(Boolean.TRUE);

		String result = mainController.postLogin("username", "password", model);

		assertEquals("redirect:/main",result);


	}

	@Test
	public void loginPostLoginFailsTest() {
		given(loginProcessor.login())
				.willReturn(false);
		String result =
				mainController.postLogin("username", "password", model);
		assertEquals("login.html", result);
		verify(model)
				.addAttribute("message", "Login failed");
	}

}
