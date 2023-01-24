import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsaCalculatorTest {

    @Mock
    public MarketApi marketApi;


    @BeforeEach
    public void init(){

        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }



    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest(){
        MarketApi marketApi = new MarketApi();
        UsaCalculator usaCalculator = new UsaCalculator(marketApi);
        usaCalculator.init();

        Calculator calculator = new Calculator(usaCalculator);
        Assertions.assertEquals(22000, calculator.sum(10,10));
        Assertions.assertEquals(0, calculator.minus(10,10));
    }


    @Test
    public void mockTest(){

        //mocking처리한 marketApi
        UsaCalculator usaCalculator = new UsaCalculator(marketApi);
        usaCalculator.init();

        Calculator calculator = new Calculator(usaCalculator);
        System.out.println(calculator.sum(10,10));
        Assertions.assertEquals(60000, calculator.sum(10,10));
        Assertions.assertEquals(0, calculator.minus(10,10));
    }
}
