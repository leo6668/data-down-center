package com.hd.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageSourceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public ImageSourceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdIsNull() {
            addCriterion("local_image_id is null");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdIsNotNull() {
            addCriterion("local_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdEqualTo(String value) {
            addCriterion("local_image_id =", value, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdNotEqualTo(String value) {
            addCriterion("local_image_id <>", value, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdGreaterThan(String value) {
            addCriterion("local_image_id >", value, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("local_image_id >=", value, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdLessThan(String value) {
            addCriterion("local_image_id <", value, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdLessThanOrEqualTo(String value) {
            addCriterion("local_image_id <=", value, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdLike(String value) {
            addCriterion("local_image_id like", value, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdNotLike(String value) {
            addCriterion("local_image_id not like", value, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdIn(List<String> values) {
            addCriterion("local_image_id in", values, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdNotIn(List<String> values) {
            addCriterion("local_image_id not in", values, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdBetween(String value1, String value2) {
            addCriterion("local_image_id between", value1, value2, "localImageId");
            return (Criteria) this;
        }

        public Criteria andLocalImageIdNotBetween(String value1, String value2) {
            addCriterion("local_image_id not between", value1, value2, "localImageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(String value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(String value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(String value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(String value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(String value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLike(String value) {
            addCriterion("image_id like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotLike(String value) {
            addCriterion("image_id not like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<String> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<String> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(String value1, String value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(String value1, String value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageLinkIsNull() {
            addCriterion("image_link is null");
            return (Criteria) this;
        }

        public Criteria andImageLinkIsNotNull() {
            addCriterion("image_link is not null");
            return (Criteria) this;
        }

        public Criteria andImageLinkEqualTo(String value) {
            addCriterion("image_link =", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkNotEqualTo(String value) {
            addCriterion("image_link <>", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkGreaterThan(String value) {
            addCriterion("image_link >", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkGreaterThanOrEqualTo(String value) {
            addCriterion("image_link >=", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkLessThan(String value) {
            addCriterion("image_link <", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkLessThanOrEqualTo(String value) {
            addCriterion("image_link <=", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkLike(String value) {
            addCriterion("image_link like", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkNotLike(String value) {
            addCriterion("image_link not like", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkIn(List<String> values) {
            addCriterion("image_link in", values, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkNotIn(List<String> values) {
            addCriterion("image_link not in", values, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkBetween(String value1, String value2) {
            addCriterion("image_link between", value1, value2, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkNotBetween(String value1, String value2) {
            addCriterion("image_link not between", value1, value2, "imageLink");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathIsNull() {
            addCriterion("local_image_path is null");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathIsNotNull() {
            addCriterion("local_image_path is not null");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathEqualTo(String value) {
            addCriterion("local_image_path =", value, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathNotEqualTo(String value) {
            addCriterion("local_image_path <>", value, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathGreaterThan(String value) {
            addCriterion("local_image_path >", value, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("local_image_path >=", value, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathLessThan(String value) {
            addCriterion("local_image_path <", value, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathLessThanOrEqualTo(String value) {
            addCriterion("local_image_path <=", value, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathLike(String value) {
            addCriterion("local_image_path like", value, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathNotLike(String value) {
            addCriterion("local_image_path not like", value, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathIn(List<String> values) {
            addCriterion("local_image_path in", values, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathNotIn(List<String> values) {
            addCriterion("local_image_path not in", values, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathBetween(String value1, String value2) {
            addCriterion("local_image_path between", value1, value2, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andLocalImagePathNotBetween(String value1, String value2) {
            addCriterion("local_image_path not between", value1, value2, "localImagePath");
            return (Criteria) this;
        }

        public Criteria andImageStatusIsNull() {
            addCriterion("image_status is null");
            return (Criteria) this;
        }

        public Criteria andImageStatusIsNotNull() {
            addCriterion("image_status is not null");
            return (Criteria) this;
        }

        public Criteria andImageStatusEqualTo(Integer value) {
            addCriterion("image_status =", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotEqualTo(Integer value) {
            addCriterion("image_status <>", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusGreaterThan(Integer value) {
            addCriterion("image_status >", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_status >=", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLessThan(Integer value) {
            addCriterion("image_status <", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLessThanOrEqualTo(Integer value) {
            addCriterion("image_status <=", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusIn(List<Integer> values) {
            addCriterion("image_status in", values, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotIn(List<Integer> values) {
            addCriterion("image_status not in", values, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusBetween(Integer value1, Integer value2) {
            addCriterion("image_status between", value1, value2, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("image_status not between", value1, value2, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table image_source
     *
     * @mbg.generated do_not_delete_during_merge Mon Aug 20 21:52:15 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table image_source
     *
     * @mbg.generated Mon Aug 20 21:52:15 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}