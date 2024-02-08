package manage;

public class QueryManage {

    private String query01 = "select user_id from u168183796_qaloantec.deposits where amount between 100 and 500;";
    private String query02= "SELECT name FROM u168183796_qaloantec.cron_schedules Limit 2";
    private String query03= "select firstname, lastname from users where country_code NOT like 'TR' and id=11";
    private String query04 = "select user_id, group_concat(browser, ' - ', os ) as browser_os from user_logins group by user_id;";
    private String updateQuery05= "update users set mobile= 33333333 where username like '%e_'";

    private String preparedQuery05= "update users set mobile= ? where username like ?";
    private String preparedQuery06 = "INSERT INTO admin_password_resets (id,email,token,status) VALUES (?,?,?,?);";

    private String preparedQuery08 = "UPDATE admin_notifications SET is_read = ? where id = ?";

    private String preparedQuery09Insert = "insert into update_logs (id,version,update_log,created_at) values(?,?,?,?)";
    private String preparedQuery09Update = "UPDATE update_logs set update_log = ? Where version = ? and id = ?";
    private String preparedQuery10Delete= "DELETE FROM u168183796_qaloantec.update_logs WHERE id=?";
    private String preparedQuery11Insert= "INSERT INTO support_attachments (id, support_message_id, attachment, created_at) VALUES(?, ?, ?, ?)";
    private String preparedQuery11Delete= "delete from u168183796_qaloantec.support_attachments where support_message_id = ?";
    //------------ GETTER------------------




    public String getQuery01() {
        return query01;
    }

    public String getQuery02() {
        return query02;
    }
    public String getQuery03() {
        return query03;
    }
    public String getQuery04() {
        return query04;
    }

    public String getUpdateQuery05() {
        return updateQuery05;
    }

    public String getPreparedQuery05() {
        return preparedQuery05;
    }

    public String getPreparedQuery06() {
        return preparedQuery06;
    }

    public String getPreparedQuery08() {
        return preparedQuery08;
    }

    public String getPreparedQuery09Insert() {
        return preparedQuery09Insert;
    }

    public String getPreparedQuery09Update() {
        return preparedQuery09Update;
    }

    public String getPreparedQuery10Delete() {
        return preparedQuery10Delete;
    }

    public String getPreparedQuery11Insert() {
        return preparedQuery11Insert;
    }

    public String getPreparedQuery11Delete() {
        return preparedQuery11Delete;
    }
}
