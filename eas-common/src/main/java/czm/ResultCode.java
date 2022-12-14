package czm;

/**
 * 枚举了一些常用API操作码
 * Created by commerce on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    /***
     * 8000-9000 业务异常
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    UNKNOW(4004,"未知错误");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
