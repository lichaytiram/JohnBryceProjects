package coupons.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import coupons.beans.UserData;
import coupons.logic.ICacheManager;

@Component
@WebFilter("/*")
public class LoginFilter implements Filter {

	@Autowired
	private ICacheManager cacheManager;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String path = ((HttpServletRequest) request).getRequestURI();
		if (path.startsWith("/users/login") || path.startsWith("/customers/register")) {

			chain.doFilter(request, response); // Just continue chain.

		} else {

//		    int token = Integer.parseInt(req.getParameter("token"));
//			HttpServletRequest req = (HttpServletRequest) request;
//			String token = req.getParameter("token");
//			UserData userData = (UserData) cacheManager.get(token);
			UserData userData = (UserData) cacheManager.getFirst();

			if (userData != null) {

				request.setAttribute("userData", userData);
				chain.doFilter(request, response);
				return;

			}

			HttpServletResponse res = (HttpServletResponse) response;
//	        401 = Unauthorized http error code
			res.setStatus(401);

		}

	}

}
