package testcases.api.cypressApp;
import actions.api.NotificationAPI;
import actions.commons.API.BaseAPITest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import static actions.commons.GlobalConstants.cookie;

public class NotificationTest extends BaseAPITest {
    NotificationAPI notification;
    String accept, Cookie, endpoint, listName;
    @BeforeClass(alwaysRun = true)
    public void initAPI() {
        // Khởi tạo API sau khi cookie đã có từ BaseAPITest
        notification = new NotificationAPI(cookie);
        accept= "application/json";
        Cookie = cookie;
        System.out.println(Cookie);
        endpoint = "/notifications";
    }
    @Test(groups = "runnow")
    public void getAllNotificationSuccess(){
        listName = "results";
        //Call function
        Response response = notification.getAllNotification(accept, Cookie, endpoint);
        System.out.println(response);
        //Validate status code
        verifyEquals(notification.getResponseStatusCode(response), 200);
        //Validate response is not empty
        String responseBody = notification.getResponseBody(response);
        verifyTrue(responseBody.contains(listName));
    }
    @Test(groups = "runnow")
    public void testNotificationResponseTimeUnder2Seconds(){
        //Call function
        Response response = notification.getAllNotification(accept, Cookie, endpoint);
        verifyEquals(notification.getResponseStatusCode(response), 200);
        //Validate
        verifyTrue(notification.getResponseTime(response)<2000);
    }
    @Test(groups = "runnow")
    public void testNotificationResponseStructure(){
        listName = "results";
        //Call function
        Response response = notification.getAllNotification(accept, Cookie, endpoint);
        verifyEquals(notification.getResponseStatusCode(response), 200);

        //Verify response contains required keys
        List<String> requiredKeys = Arrays.asList("userFullName", "id", "isRead", "createdAt", "modifiedAt");
        verifyTrue(notification.validatedReqiredKeysExist(response, listName, requiredKeys));
    }
    @Test(groups = "runnow")
    public void testNotificationResponseDataType(){
        listName = "results";
        List<String> fixedValues = Arrays.asList("requested", "received");

        //Call function
        Response response = notification.getAllNotification(accept, Cookie, endpoint);
        verifyEquals(notification.getResponseStatusCode(response), 200);
        //Verify data type of all keys
        verifyTrue(notification.isKeyOfExpectedType(response, listName, "userFullName", String.class));
        verifyTrue(notification.isKeyOfExpectedType(response, listName, "id", String.class));
        verifyTrue(notification.isKeyOfExpectedType(response, listName, "isRead", Boolean.class));
        //Check Status is fixed
        verifyTrue(notification.isKeyOfExpectedType(response, listName, "status", String.class));
        verifyTrue(notification.isKeyOfFixedList(response, listName, "status", fixedValues));
        //Check datetime field is right format...
        verifyTrue(notification.isKeyOfExpectedType(response, listName, "createdAt", String.class));
        verifyTrue(notification.isKeyOfExpectedType(response, listName, "modifiedAt", String.class));
    }
    @Test(groups = "runnow")
    public void testNotificationWithoutAuthShouldFail(){
        String nonCookie = "";
        Response response = notification.getAllNotification(accept, nonCookie, endpoint);

        //Verify
        verifyEquals(notification.getResponseStatusCode(response), 401);

    }
}
