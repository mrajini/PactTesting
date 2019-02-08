package consumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static groovy.util.GroovyTestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PactJunitRuleTest {

    @Autowired
    ProviderService providerService;

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("Consumerfile", this);

    @Pact(consumer = "JunitRuleConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        return builder.given("").uponReceiving("Pact Testing interaction").path("/information").query("name=Mike").method("GET").willRespondWith().headers(headers).status(200).body("{\n" + "   \"salary\":45000,\n" + "    \"name\": \"Micheal Mike\",\n" + "     \"nationality\": \"Japan\",\n" + "      \"contact\": {\n" + "       \"Email\": \"michael.mike@ariman.com\",\n" + "       \"Phone Number\": \"9090950\"\n" + "  }\n" + "}").toPact();


    }


    @Test
    @PactVerification
    public void runTest() {
        providerService.setBackendURL(mockProvider.getUrl());
        Information information = providerService.getInformation();
        assertEquals(information.getName(), "Micheal Mike");
    }

}