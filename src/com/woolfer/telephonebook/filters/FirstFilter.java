package com.woolfer.telephonebook.filters;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import javax.servlet.*;

public class FirstFilter implements javax.servlet.Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Map<String, String[]> param = request.getParameterMap();

		if (param != null) {
			Path logfile = FileSystems.getDefault().getPath("G:\\workspace\\TelephoneBook-v2\\file.log");
			byte buf[] = param.toString().getBytes();
			try {
				Files.write(logfile, buf, StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
