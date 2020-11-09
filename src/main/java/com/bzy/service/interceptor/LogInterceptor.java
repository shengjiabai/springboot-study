package com.bzy.service.interceptor;

import com.bzy.service.advice.ApplicationContextUtil;
import com.bzy.service.other.springEvent.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 如果实现HandlerInterceptor接口的话，三个方法必须实现，不管你需不需要，
 * 此时spring提供了一个HandlerInterceptorAdapter适配器（种适配器设计模式的实现），允许我们只实现需要的回调方法。
 * 这样在我们业务中比如要记录系统日志，日志肯定是在afterCompletion之后记录的，否则中途失败了，也记录了，那就扯淡了。
 * 一定是程序正常跑完后，我们记录下那些对数据库做个增删改的操作日志进数据库。所以我们只需要继承HandlerInterceptorAdapter，
 * 并重写afterCompletion一个方法即可，因为preHandle默认是true。
 * 
 * 运行流程总结如下：
 *
 * 1.拦截器执行顺序是按照Spring配置文件中定义的顺序而定的。
 * 2.会先按照顺序执行所有拦截器的preHandle方法，一直遇到return false为止，比如第二个preHandle方法是return false，则第三个以及以后所有拦截器都不会执行。若都是return true，则按顺序加载完preHandle方法。
 * 3.然后执行主方法（自己的controller接口），若中间抛出异常，则跟return false效果一致，不会继续执行postHandle，只会倒序执行afterCompletion方法。
 * 4.在主方法执行完业务逻辑（页面还未渲染数据）时，按倒序执行postHandle方法。若第三个拦截器的preHandle方法return false，则会执行第二个和第一个的postHandle方法和afterCompletion（postHandle都执行完才会执行这个，也就是页面渲染完数据后，执行after进行清理工作）方法。（postHandle和afterCompletion都是倒序执行）
 */
public class LogInterceptor extends HandlerInterceptorAdapter {
    
  

    //preHandle是在请求执行前执行的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        System.err.println("================================== preHandle1 ===========================================");
        
        //拦截器方法里可以直接获取bean
       /* OrderService orderService = ApplicationContextUtil.getBean(OrderService.class);
        orderService.order();*/
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        System.out.println(handlerMethod.getBean());
        System.out.println(handlerMethod.getMethod().getName());

        return true;
        //返回true,postHandler和afterCompletion方法才能执行
        // 否则false为拒绝执行，起到拦截器控制作用
    }

    //postHandler是在请求结束之后,视图渲染之前执行的,但只有preHandle方法返回true的时候才会执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("================================== postHandle1 ===========================================");
    }

    //afterCompletion是视图渲染完成之后才执行,同样需要preHandle返回true，
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("================================== afterCompletion1 ===========================================");
        //该方法通常用于清理资源等工作
    }

}
