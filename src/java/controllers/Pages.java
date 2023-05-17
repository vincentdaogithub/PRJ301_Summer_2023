package controllers;


public enum Pages {
    INDEX("login", "/index.jsp"),
    SIGN_UP("sign-up", "/sign_up.jsp"),
    ADMIN("admin", "/admin.jsp"),
    USER("user", "/user.jsp");

    private final String page;
    private final String url;

    private Pages(String action, String url) {
        this.page = action;
        this.url = url;
    }

    public String getPage() {
        return this.page;
    }

    public String getURL() {
        return this.url;
    }

    public static Pages convertPage(String page) {
        for (Pages p : Pages.values()) {
            if (p.getPage().equals(page)) {
                return p;
            }
        }

        return null;
    }
}
