package manage;

public class QueryManage {

    private String query01 = "select user_id from u168183796_qaloantec.deposits where amount between 100 and 500;";
    private String query02= "SELECT name FROM u168183796_qaloantec.cron_schedules Limit 2";
    private String query03= "select firstname, lastname from users where country_code NOT like 'TR' and id=11";
    private String query04 = "select user_id, group_concat(browser, ' - ', os ) as browser_os from user_logins group by user_id;";
    private String updateQuery05= "update users set mobile= 987654321 where username like '%e_'";
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
}
