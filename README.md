# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)
* [Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
* [OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/openai-chat.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Run the code
In pom.xml, choose between Azure OpenAI or OpenAI, not both
```xml
        <!--comment to use OpenAI instead of Azure OpenAI Services-->
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-azure-openai-spring-boot-starter</artifactId>
        </dependency>
        <!--Uncomment to use OpenAI instead of Azure OpenAI Services-->
<!--        <dependency>-->
<!--            <groupId>org.springframework.ai</groupId>-->
<!--            <artifactId>spring-ai-openai-spring-boot-starter</artifactId>-->
<!--        </dependency>-->
```
In application.yaml, provide the API key for Azure OpenAI or OpenAI.

### Sample usage

```http request
POST http://localhost:8080/ai/code
Content-Type: application/json

{
  "originalCode": "def two_sum(nums, target):\r\n    num_map = {}\r\n    for i, num in enumerate(nums):\r\n        complement = target - num\r\n        if complement in num_map:\r\n            return [num_map[complement], i]\r\n        num_map[num] = i\r\n    return []",
  "from": "Python",
  "to": "Java"
}
```