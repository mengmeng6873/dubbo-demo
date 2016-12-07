package com.mm.dubbo.provider;

import com.mm.dubbo.DemoService;

/**
 * @author meng.meng.
 * @since 2016/12/6.
 */
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello ".concat(name).concat("!");
    }

    public static void main(String[] args) {
        String[] arr = {
                "信息审核",
                "社保账单",
                "薪酬账单",
                "组织机构",
                "企业邮箱",
                "权限管理",
                "企业信息",
                "绑定手机",
                "修改密码",
                "退出登录"};

        createButtonSql(arr);
    }

    /**
     * 生成按钮插入语句
     * @param arr
     */
    public static void createButtonSql(String[] arr) {
        String sql = "INSERT INTO `ehr_button` (`page_id`, `button_name`, `button_code`, `button_url`, `memo`, `create_user_id`, `create_user_name`, `create_date`, `last_modify_user_id`, `last_modify_user_name`, `last_modify_date`) VALUES ((SELECT page_id FROM ehr_page WHERE page_name='首页'), 'せ1せ', 'index_h_せ2せ', NULL, '首页:せ1せ', NULL, NULL, NULL, NULL, NULL, NULL);";
        String sqlR = "";
        for (int i = 0; i < arr.length; i++) {
            sqlR = (sql.replaceAll("せ1せ", arr[i])).replace("せ2せ", String.valueOf(i + 1));
            System.out.println(sqlR);
        }
    }
}
