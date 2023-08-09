package api.services;

public enum HttpStatusCode {

	 OK(200, "OK"),
	    CREATED(201, "Created"),
	    ACCEPTED(202, "Accepted"),
	    NOCONTENT(204, "No Content"),

	    MULTIPLE_CHOICES(300, "Multiple Choices"),
	    MOVED_PERMANENTLY(301, "Moved Permanently"),
	    FOUND(302, "Found"),

	    BAD_REQUEST(400, "Bad Request"),
	    UNAUTHORIZED(401, "Unauthorized"),
	    PAYMENT_REQUIRED(402, "Payment Required"),
	    FORBIDDEN(403, "Forbidden"),
	    NOT_FOUND(404, "Not Found"),
	    UNPROCESSABLE_ENTITY(422,"Unprocessable Entity"),
	    UNSUPPORTED_MEDIA_TYPE(415,"Unsupported Media Type"),
	   
	  


	    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
	    NOT_IMPLEMENTED(501, "Not Implemented"),
	    BAD_GATEWAY(502, "Bad Gateway"),
	    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
	    GATEWAY_TIMEOUT(504, "Gateway Timeout");

	    private int code;
	    private String desc;
	    private String text;

	    HttpStatusCode(int code, String desc) {
	        this.code = code;
	        this.desc = desc;
	        this.text = Integer.toString(code);
	    }

	    /**
	     * Gets the HTTP status code
	     *
	     * @return the status code number
	     */
	    public int getCode() {
	        return code;
	    }

	    /**
	     * Gets the HTTP status code as a text string
	     *
	     * @return the status code as a text string
	     */
	    public String asText() {
	        return text;
	    }

	    /**
	     * Get the description
	     *
	     * @return the description of the status code
	     */
	    public String getDesc() {
	        return desc;
	    }

	}

