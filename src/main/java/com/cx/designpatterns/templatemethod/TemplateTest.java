package com.cx.designpatterns.templatemethod;

/**
 * @author wuming
 * @date 2019/3/2 21:53
 */
public class TemplateTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao();
        memberDao.query();
    }
}
