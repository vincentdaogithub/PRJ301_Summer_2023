package controllers;


public enum Actions {
    LOGIN("login", "/LoginServlet"),
    SIGN_UP("sign-up", "/SignUpServlet");

    private final String action;
    private final String url;

    private Actions(String action, String url) {
        this.action = action;
        this.url = url;
    }

    public String getAction() {
        return this.action;
    }

    public String getURL() {
        return this.url;
    }

    public static Actions convertAction(String action) {
        for (Actions a : Actions.values()) {
            if (a.getAction().equals(action)) {
                return a;
            }
        }

        return null;
    }
}
