Code provides an example about how to do Contract Test which uses Junit in Consumer side and Gradle task in Provider side,
it will cover:

*Microservices examples created with Spring Boot.
*Example of one Provider to one Consumer.
*Contract Testing using PACT JVM
*Consumer tests using Junit Rule.
*Provider tests using Gradle Pact commands


Run the Tests at Consumer side using Junit Run tab on IDE or by using ./gradlew :consumerService:clean test

If the tests pass you can see the copy of Json files added to our pact folder

Run Contract Test at Provider side suing Gradle
1.start Provider application by using the below command
./gradlew :providerService:bootRun
2.once the server is up you can check the post request response using postman
3.Now to verify the contract of consumer with provider use gradle command
./gradlew :providerService:pactVerify

