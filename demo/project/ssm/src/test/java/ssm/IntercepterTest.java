package ssm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class IntercepterTest implements HandlerInterceptor {

	//在handler方法执行之前，运行里面的代码，，可以用于用户的登陆验证
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	//在handler方法执行中，返回modelAndView之前运行里面的代码，可以想页面提供公用的数据
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//在handler方法执行之后,运行里面的代码,可以进行异常处理，计算执行时间，记录日志
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//当PreHandler返回false时，其余的两个方法都不执行，而且handler也不会执行
	//拦截器里面的preHandler，postHandler和afterHandler方法时按顺序依次执行的
	//当有多个拦截器存在时，如果有任意一个拦截器的preHandler方法返回false则剩下的都不执行
	//如果多个拦截器同时运行preHandler,PreHander方法返回true，那么preHandler方法是按顺序执行的，而其余两个方法post和afterHandler是按倒序执行
	//拦截器的执行顺序是按照springMVC配置晚间中的文职来顺序执行的
	
	
	
	
	

}
