package py.edu.ucom.Api;


public class ApiResponse<T> {
    private String message;
    private int code;
    private T data;

    public ApiResponse(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ApiResponse{");
        stringBuilder.append("message='");
        stringBuilder.append(message);
        stringBuilder.append('\'');
        stringBuilder.append(", code=");
        stringBuilder.append(code);
        stringBuilder.append(", data=");
        stringBuilder.append(data);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
