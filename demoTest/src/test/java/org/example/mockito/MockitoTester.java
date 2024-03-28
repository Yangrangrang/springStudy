package org.example.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestResource.class)
class MockitoTester {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestResource testResource;

    @Test
    public void testMockTest() throws Exception {
        String id = "1";
        String expectedResult = "actualResult";

        // 모의 데이터 설정
        when(testResource.mockTest(id)).thenReturn(expectedResult);

        // 요청 및 응답 확인
        mockMvc.perform(MockMvcRequestBuilders.get("/tests/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResult));
    }
}