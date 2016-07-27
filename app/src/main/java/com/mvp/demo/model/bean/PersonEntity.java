package com.mvp.demo.model.bean;

import java.io.Serializable;

/**
 * 创建人：
 * 创建时间： 2016/7/26 11
 * 功能概述:
 * 修改人：
 * 修改时间：
 */
public class PersonEntity implements Serializable{

    public Info info;

    public String code;

    public String token;

    public PersonEntity(boolean isManager, Info info) {
        this.isManager = isManager;
        this.info = info;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isManager;

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    private boolean hasBind_phone;

    public boolean isHasBind_phone() {
        return hasBind_phone;
    }

    public void setHasBind_phone(boolean hasBind_phone) {
        this.hasBind_phone = hasBind_phone;
    }

    public static class Info implements Serializable {


        /**
         * invete_code : n201607250438
         * main_business : null
         * region : null
         * invite_num : 0
         * phone_number : 13534151574
         * member_type : 0
         * qq_open_id : null
         * open_id : o0ESOwQ1CS5p_MISQnNqFkoKYkFo
         * job : null
         * qq_img_url : null
         * u_id : 438
         * qq_token : null
         * nick_name : user438
         * wx_token : hHfYbEfbivIfWur708ItlshEUWBmIm
         * wechat_img_url : null
         * company : null
         * head_img : http://120.76.156.9:22354/static/default.png
         * gender : 1
         * realname : null
         * industry : null
         * linked : false
         * customer_id : n201607250438
         */

        private String invete_code;
        private String main_business;
        private String region;
        private int invite_num;
        private String phone_number;
        private int member_type;
        private String qq_open_id;
        private String open_id;
        private String job;
        private String qq_img_url;
        private int u_id;
        private String qq_token;
        private String nick_name;
        private String wx_token;
        private String wechat_img_url;
        private String company;
        private String head_img;
        private int gender;
        private String realname;
        private String industry;
        private boolean linked;
        private String customer_id;

        public Info(String phone_number) {
            this.phone_number = phone_number;
        }

        public Info(String invete_code, String main_business, String region, int invite_num,
                    String phone_number, int member_type, String qq_open_id, String open_id,
                    String job, String qq_img_url, int u_id, String qq_token, String nick_name,
                    String wx_token, String wechat_img_url, String company, String head_img,
                    int gender, String realname, String industry, boolean linked, String customer_id) {
            this.invete_code = invete_code;
            this.main_business = main_business;
            this.region = region;
            this.invite_num = invite_num;
            this.phone_number = phone_number;
            this.member_type = member_type;
            this.qq_open_id = qq_open_id;
            this.open_id = open_id;
            this.job = job;
            this.qq_img_url = qq_img_url;
            this.u_id = u_id;
            this.qq_token = qq_token;
            this.nick_name = nick_name;
            this.wx_token = wx_token;
            this.wechat_img_url = wechat_img_url;
            this.company = company;
            this.head_img = head_img;
            this.gender = gender;
            this.realname = realname;
            this.industry = industry;
            this.linked = linked;
            this.customer_id = customer_id;
        }

        public String getInvete_code() {
            return invete_code;
        }

        public void setInvete_code(String invete_code) {
            this.invete_code = invete_code;
        }

        public String getMain_business() {
            return main_business;
        }

        public void setMain_business(String main_business) {
            this.main_business = main_business;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public int getInvite_num() {
            return invite_num;
        }

        public void setInvite_num(int invite_num) {
            this.invite_num = invite_num;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public int getMember_type() {
            return member_type;
        }

        public void setMember_type(int member_type) {
            this.member_type = member_type;
        }

        public String getQq_open_id() {
            return qq_open_id;
        }

        public void setQq_open_id(String qq_open_id) {
            this.qq_open_id = qq_open_id;
        }

        public String getOpen_id() {
            return open_id;
        }

        public void setOpen_id(String open_id) {
            this.open_id = open_id;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getQq_img_url() {
            return qq_img_url;
        }

        public void setQq_img_url(String qq_img_url) {
            this.qq_img_url = qq_img_url;
        }

        public int getU_id() {
            return u_id;
        }

        public void setU_id(int u_id) {
            this.u_id = u_id;
        }

        public String getQq_token() {
            return qq_token;
        }

        public void setQq_token(String qq_token) {
            this.qq_token = qq_token;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getWx_token() {
            return wx_token;
        }

        public void setWx_token(String wx_token) {
            this.wx_token = wx_token;
        }

        public String getWechat_img_url() {
            return wechat_img_url;
        }

        public void setWechat_img_url(String wechat_img_url) {
            this.wechat_img_url = wechat_img_url;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getHead_img() {
            return head_img;
        }

        public void setHead_img(String head_img) {
            this.head_img = head_img;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public boolean isLinked() {
            return linked;
        }

        public void setLinked(boolean linked) {
            this.linked = linked;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "invete_code='" + invete_code + '\'' +
                    ", main_business='" + main_business + '\'' +
                    ", region='" + region + '\'' +
                    ", invite_num=" + invite_num +
                    ", phone_number='" + phone_number + '\'' +
                    ", member_type=" + member_type +
                    ", qq_open_id='" + qq_open_id + '\'' +
                    ", open_id='" + open_id + '\'' +
                    ", job='" + job + '\'' +
                    ", qq_img_url='" + qq_img_url + '\'' +
                    ", u_id=" + u_id +
                    ", qq_token='" + qq_token + '\'' +
                    ", nick_name='" + nick_name + '\'' +
                    ", wx_token='" + wx_token + '\'' +
                    ", wechat_img_url='" + wechat_img_url + '\'' +
                    ", company='" + company + '\'' +
                    ", head_img='" + head_img + '\'' +
                    ", gender=" + gender +
                    ", realname='" + realname + '\'' +
                    ", industry='" + industry + '\'' +
                    ", linked=" + linked +
                    ", customer_id='" + customer_id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RegisterEntity{" +
                "info=" + info +
                ", code='" + code + '\'' +
                ", token='" + token + '\'' +
                ", isManager=" + isManager +
                ", hasBind_phone=" + hasBind_phone +
                '}';
    }

}
