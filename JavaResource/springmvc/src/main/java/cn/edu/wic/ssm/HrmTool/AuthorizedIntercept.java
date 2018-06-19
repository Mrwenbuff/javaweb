package cn.edu.wic.ssm.HrmTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.wic.ssm.bean.User;

/**
 * @author  snow
 * @E-mail:  1551071933@qq.com
 * @Description: 
 * @date 创建时间：2018年6月19日 下午9:17:59
 * @version 1.0
 */
public class AuthorizedIntercept implements HandlerInterceptor{
	
	/**定义不需要拦截的请求*/
	private static final String[] SAFE_URI = {"/loginForm","login","register"};


	/** Title: preHandle
	 *   进行处理器拦截，在Controller处理之前调用
	 *   当preHandle的返回值为false的时候整个请求就结束了
	 *   如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**默认用户没有登录*/
		boolean flag = false;
		/**获得请求的ServletPath*/
		String  ServletPath = request.getServletPath();
		/**判断请求是否需要拦截*/
		for(String s : SAFE_URI) {
			if(ServletPath.contains(s)) {
				flag = true;
				break;
			}
		}
		/**拦截请求*/
		if(!flag) {
			/**获取session中的用户*/
			User user = (User) request.getSession().getAttribute(HrmContants.USER_SESSOIN);
			/**判断用户是否登录*/
			if(user == null) {
				/**如果用户没有登录，跳转到登录页面*/
				request.setAttribute("message", "请先登录再访问网站");
				request.getRequestDispatcher(HrmContants.LOGIN).forward(request, response);
				return flag;
			}else {
				flag = true;
			}
		}
		return flag;
	}

	/** Title: postHandle
	 * 这个方法在preHandle返回true之后才会执行
	 * 执行时间是在处理器处理之后，也就是在Controller调用之后执行
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	/** Title: afterCompletion
	 * 这个方法在preHandle返回true之后才会执行
	 * 该方法将在整个请求完成之后执行，主要是用于清理资源
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
