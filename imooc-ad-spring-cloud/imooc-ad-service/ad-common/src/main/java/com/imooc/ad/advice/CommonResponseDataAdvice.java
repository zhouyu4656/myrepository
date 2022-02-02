package com.imooc.ad.advice;


import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    @Override
    /*是否启用全局异常*/
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        /*
        拿到这个类的声明，如果是被IgnoreResponseAdvice标识，返回false
        * */
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
         /*
        拿到这个方法的声明，如果是被IgnoreResponseAdvice标识，返回false
        * */
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }

        return false;
    }

    @Override
    //这个方法中的Object o是响应体，在返回给浏览器之前可以对他进行一些操作
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //创建一个同一返回的数据类型RESPONSE
        CommonResponse<Object> commonResponse = new CommonResponse<>();
        if (null == o) {
            return commonResponse;
        }else if (o instanceof CommonResponse){
            commonResponse = (CommonResponse<Object>) o;
        }else{
            commonResponse.setData(o);
        }
        return commonResponse;
    }
}
