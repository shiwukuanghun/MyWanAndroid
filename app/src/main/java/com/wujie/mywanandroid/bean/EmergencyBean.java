package com.wujie.mywanandroid.bean;

import java.util.List;

/**
 * Created by HuangBin on 2018/11/28 21:04.
 * Description：
 */
public class EmergencyBean {


    /**
     * answers : [{"questionKey":"entryTime","questionValue":"2017-06-11 19:34"},{"questionKey":"createTime","questionValue":"2018-11-25 11:00"},{"questionKey":"createUserPid","questionValue":1062328623492870100},{"questionKey":"updateUserPid","questionValue":1062328623492870100},{"questionKey":"delStatus","questionValue":0},{"questionKey":"pid","questionValue":1066527132001534000},{"questionKey":"remark","questionValue":""},{"questionKey":"updateTime","questionValue":"2018-11-26 10:46"},{"questionKey":"version","questionValue":0},{"questionKey":"pictures"},{"questionKey":"question1","questionValue":3}]
     * createTime : 2018-11-15 14:04
     * pid : 20
     * questions : [{"createTime":"2018-11-15 14:48","layoutPid":20,"normalRange":"","options":[],"pid":148,"questionKey":"pictures","questionOrder":0,"questionType":3,"title":"图片记录","unit":"","version":1,"visibility":0},{"createTime":"2018-11-15 14:48","layoutPid":20,"normalRange":"","options":[],"pid":147,"questionKey":"remark","questionOrder":1,"questionType":1,"title":"备注","unit":"","version":1,"visibility":0},{"createTime":"2018-11-15 14:45","layoutPid":20,"normalRange":"","options":[{"createTime":"2018-11-15 14:55","lable":"鼻衄","layoutQuestionPid":146,"optionAssociatedKeys":"","optionOrder":0,"optionType":0,"pid":152,"value":"1","version":0},{"createTime":"2018-11-15 14:56","lable":"血尿","layoutQuestionPid":146,"optionAssociatedKeys":"","optionOrder":1,"optionType":0,"pid":153,"value":"2","version":0},{"createTime":"2018-11-15 14:56","lable":"脑出血","layoutQuestionPid":146,"optionAssociatedKeys":"","optionOrder":2,"optionType":0,"pid":154,"value":"3","version":0},{"createTime":"2018-11-15 14:57","lable":"牙龈出血","layoutQuestionPid":146,"optionAssociatedKeys":"","optionOrder":3,"optionType":0,"pid":155,"value":"4","version":0},{"createTime":"2018-11-15 14:57","lable":"大便带血","layoutQuestionPid":146,"optionAssociatedKeys":"","optionOrder":4,"optionType":0,"pid":156,"value":"5","version":0},{"createTime":"2018-11-15 14:57","lable":"关节瘀肿","layoutQuestionPid":146,"optionAssociatedKeys":"","optionOrder":5,"optionType":0,"pid":157,"value":"6","version":0},{"createTime":"2018-11-15 14:58","lable":"咯血或血痰","layoutQuestionPid":146,"optionAssociatedKeys":"","optionOrder":6,"optionType":0,"pid":158,"value":"7","version":0},{"createTime":"2018-11-15 14:58","lable":"皮肤瘀斑、瘀点、皮下血肿","layoutQuestionPid":146,"optionAssociatedKeys":"","optionOrder":7,"optionType":0,"pid":159,"value":"8","version":0}],"pid":146,"questionKey":"question1","questionOrder":2,"questionType":0,"title":"出血","unit":"","version":1,"visibility":0},{"createTime":"2018-11-15 14:49","layoutPid":20,"normalRange":"","options":[],"pid":149,"questionKey":"entryTime","questionOrder":3,"questionType":2,"title":"录入时间","unit":"","version":1,"visibility":0}]
     * subType : 17
     * type : 1
     * version : 0
     */

    private String createTime;
    private int pid;
    private int subType;
    private int type;
    private int version;
    /**
     * questionKey : entryTime
     * questionValue : 2017-06-11 19:34
     */

    private List<AnswersBean> answers;
    /**
     * createTime : 2018-11-15 14:48
     * layoutPid : 20
     * normalRange :
     * options : []
     * pid : 148
     * questionKey : pictures
     * questionOrder : 0
     * questionType : 3
     * title : 图片记录
     * unit :
     * version : 1
     * visibility : 0
     */

    private List<QuestionsBean> questions;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<AnswersBean> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersBean> answers) {
        this.answers = answers;
    }

    public List<QuestionsBean> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsBean> questions) {
        this.questions = questions;
    }

    public static class AnswersBean {
        private String questionKey;
        private String questionValue;

        public String getQuestionKey() {
            return questionKey;
        }

        public void setQuestionKey(String questionKey) {
            this.questionKey = questionKey;
        }

        public String getQuestionValue() {
            return questionValue;
        }

        public void setQuestionValue(String questionValue) {
            this.questionValue = questionValue;
        }
    }

    public static class QuestionsBean {
        private String createTime;
        private int layoutPid;
        private String normalRange;
        private int pid;
        private String questionKey;
        private int questionOrder;
        private int questionType;
        private String title;
        private String unit;
        private int version;
        private int visibility;
        private List<?> options;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getLayoutPid() {
            return layoutPid;
        }

        public void setLayoutPid(int layoutPid) {
            this.layoutPid = layoutPid;
        }

        public String getNormalRange() {
            return normalRange;
        }

        public void setNormalRange(String normalRange) {
            this.normalRange = normalRange;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getQuestionKey() {
            return questionKey;
        }

        public void setQuestionKey(String questionKey) {
            this.questionKey = questionKey;
        }

        public int getQuestionOrder() {
            return questionOrder;
        }

        public void setQuestionOrder(int questionOrder) {
            this.questionOrder = questionOrder;
        }

        public int getQuestionType() {
            return questionType;
        }

        public void setQuestionType(int questionType) {
            this.questionType = questionType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getVisibility() {
            return visibility;
        }

        public void setVisibility(int visibility) {
            this.visibility = visibility;
        }

        public List<?> getOptions() {
            return options;
        }

        public void setOptions(List<?> options) {
            this.options = options;
        }
    }
}
