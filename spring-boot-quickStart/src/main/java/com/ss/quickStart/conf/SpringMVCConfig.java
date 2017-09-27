package com.ss.quickStart.conf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.ss.quickStart.core.BizException;
import com.ss.quickStart.core.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter{
    private static final Logger LOG = LoggerFactory.getLogger(SpringMVCConfig.class);
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter4 fastJsonConverter = new FastJsonHttpMessageConverter4();
        fastJsonConverter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(fastJsonConverter);
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
                Result result  = new Result();
                if (ex instanceof BizException){
                    BizException bizException = (BizException)ex;
                    result.setCode(bizException.getErrorCode());
                    result.setMessaage(bizException.getMessage());
                }else{
                    result.setCode(-1);
                    result.setMessaage("系统异常，请联系管理员");
                }

                response.setCharacterEncoding("UTF-8");
                response.setHeader("Content-type", "application/json;charset=UTF-8");
                try {
                    response.getWriter().write(JSON.toJSONString(result));
                } catch (IOException e) {
                    LOG.info("异常处理获取输出流异常",e);
                    e.printStackTrace();
                }
                return new ModelAndView();
            }
        });
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    //    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters(){
//        FastJsonHttpMessageConverter4 converter4 = new FastJsonHttpMessageConverter4();
//        return new HttpMessageConverters(converter4);
//    }

}
