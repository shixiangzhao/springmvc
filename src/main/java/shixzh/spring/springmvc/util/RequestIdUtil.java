package shixzh.spring.springmvc.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestIdUtil {

    public static final String REQUEST_ID_KEY = "requestId";
    public static ThreadLocal<String> requestIdThreadLocal = new ThreadLocal<String>();

    private static final Logger logger = LoggerFactory.getLogger(RequestIdUtil.class);

    /**
     * 获取requestId
     * 
     * @Title getRequestId
     * @Description TODO
     * @return
     * @author sunhaojie 3113751575@qq.com
     * @date 2016年8月31日 上午7:58:28
     */
    public static String getRequestId(HttpServletRequest request) {
        String requestId = null;
        String parameterRequestId = request.getParameter(REQUEST_ID_KEY);
        String headerRequestId = request.getHeader(REQUEST_ID_KEY);

        if (parameterRequestId == null || headerRequestId == null) {
            logger.info("request parameter 和header 都没有requestId入参");
            requestId = UUID.randomUUID().toString();
        } else {
            requestId = parameterRequestId != null ? parameterRequestId : headerRequestId;
        }

        requestIdThreadLocal.set(requestId);

        return requestId;
    }
}
