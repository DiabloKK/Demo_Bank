package com.demo_bank_v1.helpers;

public class HTML {

    public static String htmlEmailTemplate(String token, String code) {

        //Verify Account URL:
        String url = "http://localhost:8070/verify?token=" + token + "&code=" + code;

        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\" />\n" +
                "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "        <link rel=\"stylesheet\" href=\"css/email.css\" />\n" +
                "        <title>Document</title>\n" +
                "        <style></style>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <div class=\"wrapper\">\n" +
                "            <h2 class=\"email-msg-header\">\n" +
                "                Welcome and Thank You for Choosing <br />\n" +
                "            </h2>\n" +
                "            <div class=\"company-name\">Easy Way Bank</div>\n" +
                "            <hr />\n" +
                "\n" +
                "            <p class=\"welcome-text\">\n" +
                "                Your Account has been successfully registed, please click below to verify your account\n" +
                "            </p>\n" +
                "            <br><br>\n" +
                "            \n" +
                "            <center><a href='" + url + "' class=\"verify-account-btn\">Verify Account</a></center>\n" +
                "            \n" +
                "            <div class=\"copy-right\">\n" +
                "                &copy; Copy Right 2023. All Right Reserved. \n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>\n";

        return emailTemplate;
    }

}
