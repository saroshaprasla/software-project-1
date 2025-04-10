public enum MovieType {
    REGULAR(0),
    NEW_RELEASE(1),
    CHILDRENS(2);
    
    private final int code;
    
    MovieType(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
    
    public static MovieType fromCode(int code) {
        for (MovieType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid movie type code: " + code);
    }
}
