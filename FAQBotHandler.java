class FAQBotHandler extends SupportHandler {
    @Override
    public void handle(String issue) {
        if (issue.equals("password_reset")) {
            System.out.println("[FAQBot] Handled password_reset");
        } else if (next != null) {
            next.handle(issue);
        } else {
            System.out.println("[FAQBot] Cannot handle " + issue + " - escalate manually");
        }
    }
}
