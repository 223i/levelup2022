package lesson13;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import ru.levelup.lesson9_10.controller.CityController;
import ru.levelup.lesson9_10.dto.CityDto;

@Slf4j
@SpringBootTest
public class CityControllerTest {

    private CityController cityController;

    @Test
    public void checkCityIsCreated() {
        CityDto city = new CityDto();
        city.setNameRu("Город Н");
        city.setNameEn("City N");
        city.setAmountOfCitizens(1000);
        cityController.create(city);

    }

    @Test
    public void checkCityIsUpdated() {
        CityDto city = new CityDto();
        city.setNameRu("Город Н");
        city.setNameEn("City N");
        city.setAmountOfCitizens(1000);
        cityController.update(city);
    }

    @Test
    public void checkCityIsDeleted() {

    }
}
