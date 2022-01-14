package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 1.파라미터 전송 기능
* http://localhost:8080/request-param?username=kim&age=33&username=choi
* */
@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - Start");

        request.getParameterNames().asIterator()
                        .forEachRemaining(parameterName -> System.out.println("parameterName = " + parameterName));

        System.out.println("[전체 파라미터 조회] - End");
        System.out.println("");

        System.out.println("[단일 파라미터 조회] - Start");

        final String username = request.getParameter("username");

        System.out.println("username = " + username);
        System.out.println("[단일 파라미터 조회] - End");

        System.out.println("[이름이 같은 복수 파라미터 조회] - Start");
        final String[] usernames = request.getParameterValues("username");

        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        response.getWriter().write("OK");
    }
}
