class User {
    private String userId;
    private String name;
    private String secretKey;

    public User(String userId, String name, String secretKey) {
        this.userId = userId;
        this.name = name;
        this.secretKey = secretKey;
    }

    public String getUserId() {
        return userId;
    }

    public String getSecretKey() {
        return secretKey;
    }
}

