package com.huaao.ejwplatform.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserAuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SysUserAuditExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("dept_id like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("dept_id not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andJobsIdIsNull() {
            addCriterion("jobs_id is null");
            return (Criteria) this;
        }

        public Criteria andJobsIdIsNotNull() {
            addCriterion("jobs_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobsIdEqualTo(String value) {
            addCriterion("jobs_id =", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdNotEqualTo(String value) {
            addCriterion("jobs_id <>", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdGreaterThan(String value) {
            addCriterion("jobs_id >", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdGreaterThanOrEqualTo(String value) {
            addCriterion("jobs_id >=", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdLessThan(String value) {
            addCriterion("jobs_id <", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdLessThanOrEqualTo(String value) {
            addCriterion("jobs_id <=", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdLike(String value) {
            addCriterion("jobs_id like", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdNotLike(String value) {
            addCriterion("jobs_id not like", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdIn(List<String> values) {
            addCriterion("jobs_id in", values, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdNotIn(List<String> values) {
            addCriterion("jobs_id not in", values, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdBetween(String value1, String value2) {
            addCriterion("jobs_id between", value1, value2, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdNotBetween(String value1, String value2) {
            addCriterion("jobs_id not between", value1, value2, "jobsId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andCurrAddressIsNull() {
            addCriterion("curr_address is null");
            return (Criteria) this;
        }

        public Criteria andCurrAddressIsNotNull() {
            addCriterion("curr_address is not null");
            return (Criteria) this;
        }

        public Criteria andCurrAddressEqualTo(String value) {
            addCriterion("curr_address =", value, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressNotEqualTo(String value) {
            addCriterion("curr_address <>", value, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressGreaterThan(String value) {
            addCriterion("curr_address >", value, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressGreaterThanOrEqualTo(String value) {
            addCriterion("curr_address >=", value, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressLessThan(String value) {
            addCriterion("curr_address <", value, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressLessThanOrEqualTo(String value) {
            addCriterion("curr_address <=", value, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressLike(String value) {
            addCriterion("curr_address like", value, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressNotLike(String value) {
            addCriterion("curr_address not like", value, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressIn(List<String> values) {
            addCriterion("curr_address in", values, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressNotIn(List<String> values) {
            addCriterion("curr_address not in", values, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressBetween(String value1, String value2) {
            addCriterion("curr_address between", value1, value2, "currAddress");
            return (Criteria) this;
        }

        public Criteria andCurrAddressNotBetween(String value1, String value2) {
            addCriterion("curr_address not between", value1, value2, "currAddress");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andLiveNowIsNull() {
            addCriterion("live_now is null");
            return (Criteria) this;
        }

        public Criteria andLiveNowIsNotNull() {
            addCriterion("live_now is not null");
            return (Criteria) this;
        }

        public Criteria andLiveNowEqualTo(String value) {
            addCriterion("live_now =", value, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowNotEqualTo(String value) {
            addCriterion("live_now <>", value, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowGreaterThan(String value) {
            addCriterion("live_now >", value, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowGreaterThanOrEqualTo(String value) {
            addCriterion("live_now >=", value, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowLessThan(String value) {
            addCriterion("live_now <", value, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowLessThanOrEqualTo(String value) {
            addCriterion("live_now <=", value, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowLike(String value) {
            addCriterion("live_now like", value, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowNotLike(String value) {
            addCriterion("live_now not like", value, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowIn(List<String> values) {
            addCriterion("live_now in", values, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowNotIn(List<String> values) {
            addCriterion("live_now not in", values, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowBetween(String value1, String value2) {
            addCriterion("live_now between", value1, value2, "liveNow");
            return (Criteria) this;
        }

        public Criteria andLiveNowNotBetween(String value1, String value2) {
            addCriterion("live_now not between", value1, value2, "liveNow");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeIsNull() {
            addCriterion("policeman_code is null");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeIsNotNull() {
            addCriterion("policeman_code is not null");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeEqualTo(String value) {
            addCriterion("policeman_code =", value, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeNotEqualTo(String value) {
            addCriterion("policeman_code <>", value, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeGreaterThan(String value) {
            addCriterion("policeman_code >", value, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeGreaterThanOrEqualTo(String value) {
            addCriterion("policeman_code >=", value, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeLessThan(String value) {
            addCriterion("policeman_code <", value, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeLessThanOrEqualTo(String value) {
            addCriterion("policeman_code <=", value, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeLike(String value) {
            addCriterion("policeman_code like", value, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeNotLike(String value) {
            addCriterion("policeman_code not like", value, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeIn(List<String> values) {
            addCriterion("policeman_code in", values, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeNotIn(List<String> values) {
            addCriterion("policeman_code not in", values, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeBetween(String value1, String value2) {
            addCriterion("policeman_code between", value1, value2, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andPolicemanCodeNotBetween(String value1, String value2) {
            addCriterion("policeman_code not between", value1, value2, "policemanCode");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1IsNull() {
            addCriterion("idcard_img1 is null");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1IsNotNull() {
            addCriterion("idcard_img1 is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1EqualTo(String value) {
            addCriterion("idcard_img1 =", value, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1NotEqualTo(String value) {
            addCriterion("idcard_img1 <>", value, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1GreaterThan(String value) {
            addCriterion("idcard_img1 >", value, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1GreaterThanOrEqualTo(String value) {
            addCriterion("idcard_img1 >=", value, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1LessThan(String value) {
            addCriterion("idcard_img1 <", value, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1LessThanOrEqualTo(String value) {
            addCriterion("idcard_img1 <=", value, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1Like(String value) {
            addCriterion("idcard_img1 like", value, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1NotLike(String value) {
            addCriterion("idcard_img1 not like", value, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1In(List<String> values) {
            addCriterion("idcard_img1 in", values, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1NotIn(List<String> values) {
            addCriterion("idcard_img1 not in", values, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1Between(String value1, String value2) {
            addCriterion("idcard_img1 between", value1, value2, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg1NotBetween(String value1, String value2) {
            addCriterion("idcard_img1 not between", value1, value2, "idcardImg1");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2IsNull() {
            addCriterion("idcard_img2 is null");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2IsNotNull() {
            addCriterion("idcard_img2 is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2EqualTo(String value) {
            addCriterion("idcard_img2 =", value, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2NotEqualTo(String value) {
            addCriterion("idcard_img2 <>", value, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2GreaterThan(String value) {
            addCriterion("idcard_img2 >", value, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2GreaterThanOrEqualTo(String value) {
            addCriterion("idcard_img2 >=", value, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2LessThan(String value) {
            addCriterion("idcard_img2 <", value, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2LessThanOrEqualTo(String value) {
            addCriterion("idcard_img2 <=", value, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2Like(String value) {
            addCriterion("idcard_img2 like", value, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2NotLike(String value) {
            addCriterion("idcard_img2 not like", value, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2In(List<String> values) {
            addCriterion("idcard_img2 in", values, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2NotIn(List<String> values) {
            addCriterion("idcard_img2 not in", values, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2Between(String value1, String value2) {
            addCriterion("idcard_img2 between", value1, value2, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andIdcardImg2NotBetween(String value1, String value2) {
            addCriterion("idcard_img2 not between", value1, value2, "idcardImg2");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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