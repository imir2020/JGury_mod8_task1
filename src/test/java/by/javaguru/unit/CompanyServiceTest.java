package by.javaguru.unit;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
//    private static final Integer COMPANY_ID = 1;
//
//    @Mock
//    private CompanyRepository companyRepository;
//    @Mock
//    private ApplicationEventPublisher eventPublisher;
//    @InjectMocks
//    private CompanyService companyService;
//
//    @Test
//    void findById() {
//        Mockito.doReturn(Optional.of(new Company(COMPANY_ID, null, Collections.emptyMap())))
//                .when(companyRepository).findById(COMPANY_ID);
//
//        var actualResult = companyService.findById(COMPANY_ID);
//
//        assertTrue(actualResult.isPresent());
//
//        var expectedResult = new CompanyReadDto(COMPANY_ID);
//
//        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
//
//        verify(eventPublisher).publishEvent(any(EntityEvent.class));
//    }
}