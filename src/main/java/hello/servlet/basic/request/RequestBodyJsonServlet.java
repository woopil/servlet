package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
* JSON 형식 전송
* Content-Type: application/json
* {"username": "hello", "age": "20"}
* */
@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ServletInputStream inputStream = request.getInputStream();
        final String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        final HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        System.out.println("helloData.UserName = " + helloData.getUsername());
        System.out.println("helloData.Age = " + helloData.getAge());

        response.getWriter().write("JSON OK!");


    }
}
