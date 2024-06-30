package ge.credo.data;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import static ge.credo.data.Constants.*;

public class DataProviders {
    @DataProvider(name = "InvalidData")
    public  Object[][] getInvalidData() {
        return new Object[][] {
                { LANGUAGE_GEO, RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(8), INVALID_DATA_GEO_MESSAGE, USER_NAME_HOLDER_GEO, USER_PASSWORD_HOLDER_GEO },
                { LANGUAGE_MEGRULI, RandomStringUtils.randomAlphabetic(4), RandomStringUtils.randomAlphabetic(5), INVALID_DATA_MEGRULI_MESSAGE, USER_NAME_HOLDER_MEGRULI, USER_PASSWORD_HOLDER_MEGRULI },
                { LANGUAGE_SVANURI, RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), INVALID_DATA_SVANURI_MESSAGE, USER_NAME_HOLDER_SVANURI, USER_PASSWORD_HOLDER_SVANURI },
        };
    }

    @DataProvider(name = "MissingData")
    public  Object[][] getMissingData() {
        return new Object[][] {
                { LANGUAGE_GEO, "", "", USER_NAME_HOLDER_GEO, USER_PASSWORD_HOLDER_GEO},
                { LANGUAGE_MEGRULI, "", "", USER_NAME_HOLDER_MEGRULI, USER_PASSWORD_HOLDER_MEGRULI},
                { LANGUAGE_SVANURI, "", "", USER_NAME_HOLDER_SVANURI, USER_PASSWORD_HOLDER_SVANURI}
        };
    }

    @DataProvider(name = "MissingUsername")
    public  Object[][] getMissingUsername() {
        return new Object[][] {
                { LANGUAGE_GEO, "", RandomStringUtils.randomAlphabetic(6), USER_NAME_HOLDER_GEO, USER_PASSWORD_HOLDER_GEO},
                { LANGUAGE_MEGRULI, "", RandomStringUtils.randomAlphabetic(7), USER_NAME_HOLDER_MEGRULI, USER_PASSWORD_HOLDER_MEGRULI },
                { LANGUAGE_SVANURI, "", RandomStringUtils.randomAlphabetic(8), USER_NAME_HOLDER_SVANURI, USER_PASSWORD_HOLDER_SVANURI },
        };
    }

    @DataProvider(name = "MissingPassword")
    public  Object[][] getMissingPassword() {
        return new Object[][] {
                { LANGUAGE_GEO, RandomStringUtils.randomAlphabetic(2), "", USER_NAME_HOLDER_GEO, USER_PASSWORD_HOLDER_GEO},
                { LANGUAGE_MEGRULI, RandomStringUtils.randomAlphabetic(3), "", USER_NAME_HOLDER_MEGRULI, USER_PASSWORD_HOLDER_MEGRULI},
                { LANGUAGE_SVANURI, RandomStringUtils.randomAlphabetic(4), "", USER_NAME_HOLDER_SVANURI, USER_PASSWORD_HOLDER_SVANURI},
        };
    }
}
