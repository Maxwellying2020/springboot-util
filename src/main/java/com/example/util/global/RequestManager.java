package com.example.util.global;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * <b>Class name</b>: RequestManager
 * </p>
 * <p>
 * <b>Class description</b>: Class description goes here.
 * </p>
 * <p>
 * <b>Author</b>: zhang ying
 * </p>
 * <b>Change History</b>:<br/>
 * <p>
 *
 * <pre>
 * Date          Author       Revision     Comments
 * ----------    ----------   --------     ------------------
 * 2019-06-12    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-06-12
 * </p>
 */
public class RequestManager {
    private static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<>();

    /**
     * 当前线程加入request
     *
     * @param request
     */
    public static void setHttpServletRequest(HttpServletRequest request) {
        if (request != null) {
            threadLocal.set(request);
        }
    }

    /**
     * 当前线程获取request,在API接口中可以直接调用这个方法获取当前线程的request对象
     */
    public static HttpServletRequest getHttpServletRequest(){
        return threadLocal.get();
    }

    /**
     * 清理request，释放空间
     */
    public static void removeHttpServletRequest(){
        threadLocal.remove();
    }
}
