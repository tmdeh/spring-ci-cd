package org.example.tmdeh_ci_cd.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class TestServiceImplTest {

  @Autowired private TestServiceImpl testService;

  @Value("${server.port}")
  private String port;

  @Value("${spring.application.name}")
  private String applicationName;

  @Test
  void checkPortSuccess(){
    assertEquals("8080", port);
  }

  @Test
  void checkPortFail(){
    assertNotEquals("3334", port);
  }

  @Test
  void getTestStringSuccess() {
    assertEquals("okay " + applicationName + " " + port, testService.getString());
  }

  @Test
  void getTestStringFail() {
    assertNotEquals("okay Test FAIL", testService.getString());
  }
}