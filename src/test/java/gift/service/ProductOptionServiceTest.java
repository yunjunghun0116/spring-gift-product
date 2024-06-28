package gift.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductOptionServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductOptionService optionService;

    @BeforeEach
    @DisplayName("옵션에 대한 작업을 수행하기 위한 상품 추가 작업")
    void setUp() {
    }

    @AfterEach
    @DisplayName("다른 테스트에서 생성된 상품 옵션을 삭제하기 위한 작업")
    void tearDown() {
    }
}