package cn.oriki.commons.response;

import cn.oriki.commons.response.entity.ResponseEntity;
import cn.oriki.commons.util.Jsons;

/**
 * 响应返回
 *
 * @author oriki.wang
 */
public class Responses {

    /**
     * 响应返回成功调用的方法
     *
     * @param object 需要添加到 message 中的内容
     * @return 响应实体的 json 格式
     */
    public static String responseSuccess(Object object) {
        return response("200", "success", object);
    }

    /**
     * 响应返回失败时调用的方法
     *
     * @param object 需要添加到 message 中的内容
     * @return 响应实体的 json 格式
     */
    public static String responseFail(Object object) {
        return response("500", "fail", object);
    }

    /**
     * 响应返回异常信息时调用的方法
     *
     * @param e Exception 对象
     * @return 响应实体的 json 格式
     */
    public static String responseException(Exception e) {
        return response("500", "exception", e.getMessage());
    }

    private static String response(String code, String type, Object obj) {
        ResponseEntity responseEntity = new ResponseEntity();
        {
            responseEntity.setCode(code);
            responseEntity.setType(type);
            responseEntity.setMessage(obj);
        }
        return Jsons.toJson(responseEntity);
    }

}
