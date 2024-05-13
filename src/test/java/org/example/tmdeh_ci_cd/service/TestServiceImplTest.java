package org.example.tmdeh_ci_cd.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class TestServiceImplTest  {


  @Autowired private TestService testService;

  @Value("${server.port}")
  private String port;

  @Value("${spring.application.name}")
  private String applicationName;

  @Test
  void checkPortSuccess(){
    assertEquals(port, "3444");
  }


  @Test
  void checkPortFail(){
    assertNotEquals(port, "8080");
  }

  @Test
  void getTestStringSuccess(){
    assertEquals(testService.getString(),"okay develop server 3444");
  }

  @Test
  void getTestStringFail(){
    assertNotEquals(testService.getString(),"okay develop server 8080");
  }
}