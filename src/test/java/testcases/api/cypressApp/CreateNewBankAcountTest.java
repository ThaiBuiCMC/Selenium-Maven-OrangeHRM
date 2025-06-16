package testcases.api.cypressApp;

import actions.api.CreateNewBankAccountAPI;
import actions.commons.API.BaseAPITest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.*;

import static actions.commons.GlobalConstants.*;

public class CreateNewBankAcountTest extends BaseAPITest {
    CreateNewBankAccountAPI createNewBankAccount;
    String bankName,accountNumber,routingNumber;
    @BeforeClass(alwaysRun = true)
    public void initAPI() {
        // Khởi tạo API sau khi cookie đã có từ BaseAPITest
        createNewBankAccount = new CreateNewBankAccountAPI(cookie);
    }
    @Test
    public void createBankAccountSuccessfully(){
        //Init data
        bankName = "CHECK" + randomNumber();
        accountNumber = "0122334" + randomNumber();
        routingNumber = "11122mmvm";
        //Call function
        Response response = createNewBankAccount.createNewBankAcc(bankName,accountNumber,routingNumber);

        //Validate status code
        verifyEquals(response.getStatusCode(),200);

        //Validate response is not empty
        String responseBody = response.getBody().asString();
        verifyTrue(responseBody.contains("data"));

        //Validate data inside
        JsonPath jsonPath = response.jsonPath();
        String actualAccountNumber = jsonPath.getString("data.createBankAccount.accountNumber");
        String actualBankName = jsonPath.getString("data.createBankAccount.bankName");
        String actualRountingNumber = jsonPath.getString("data.createBankAccount.routingNumber");

        verifyEquals(actualAccountNumber, accountNumber);
        verifyEquals(actualBankName, bankName);
        verifyEquals(actualRountingNumber, routingNumber);
    }
}
