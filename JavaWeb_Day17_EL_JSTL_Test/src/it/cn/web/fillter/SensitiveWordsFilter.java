package it.cn.web.fillter;

import javax.servlet.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author majj
 * @create 2021-12-21 23:05
 */
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<String>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(realPath));
            String line = null;
            while ((line=reader.readLine())!=null){
                list.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ServletRequest proxy_req = (ServletRequest)Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")){
                    //增强返回值
                    //获取返回值
                    String value = (String)method.invoke(servletRequest, args);
                    if(value != null){
                        for (String str : list) {
                            if(value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return  value;
                }

                //判断方法名是否是 getParameterMap

                //判断方法名是否是 getParameterValue

                return method.invoke(servletRequest,args);
            }
        });

        //2.放行
        filterChain.doFilter(proxy_req, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
