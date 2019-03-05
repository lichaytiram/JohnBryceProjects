package Practice3;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class f1
 */
@WebFilter("/Servlet3")
public class f2 implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("inside filter 2");
		int y = Integer.parseInt(request.getParameter("n2"));
		if (y >= 0)
			chain.doFilter(request, response);
		else
			System.out.println("err");
	}

}
