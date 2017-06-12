package com.huaao.ejwplatform.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysLogsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SysLogsExample() {
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

        public Criteria andTClassnameIsNull() {
            addCriterion("t_className is null");
            return (Criteria) this;
        }

        public Criteria andTClassnameIsNotNull() {
            addCriterion("t_className is not null");
            return (Criteria) this;
        }

        public Criteria andTClassnameEqualTo(String value) {
            addCriterion("t_className =", value, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameNotEqualTo(String value) {
            addCriterion("t_className <>", value, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameGreaterThan(String value) {
            addCriterion("t_className >", value, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("t_className >=", value, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameLessThan(String value) {
            addCriterion("t_className <", value, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameLessThanOrEqualTo(String value) {
            addCriterion("t_className <=", value, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameLike(String value) {
            addCriterion("t_className like", value, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameNotLike(String value) {
            addCriterion("t_className not like", value, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameIn(List<String> values) {
            addCriterion("t_className in", values, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameNotIn(List<String> values) {
            addCriterion("t_className not in", values, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameBetween(String value1, String value2) {
            addCriterion("t_className between", value1, value2, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTClassnameNotBetween(String value1, String value2) {
            addCriterion("t_className not between", value1, value2, "tClassname");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeIsNull() {
            addCriterion("t_createTime is null");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeIsNotNull() {
            addCriterion("t_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeEqualTo(Date value) {
            addCriterion("t_createTime =", value, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeNotEqualTo(Date value) {
            addCriterion("t_createTime <>", value, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeGreaterThan(Date value) {
            addCriterion("t_createTime >", value, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("t_createTime >=", value, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeLessThan(Date value) {
            addCriterion("t_createTime <", value, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("t_createTime <=", value, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeIn(List<Date> values) {
            addCriterion("t_createTime in", values, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeNotIn(List<Date> values) {
            addCriterion("t_createTime not in", values, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeBetween(Date value1, Date value2) {
            addCriterion("t_createTime between", value1, value2, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("t_createTime not between", value1, value2, "tCreatetime");
            return (Criteria) this;
        }

        public Criteria andTLevelIsNull() {
            addCriterion("t_level is null");
            return (Criteria) this;
        }

        public Criteria andTLevelIsNotNull() {
            addCriterion("t_level is not null");
            return (Criteria) this;
        }

        public Criteria andTLevelEqualTo(String value) {
            addCriterion("t_level =", value, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelNotEqualTo(String value) {
            addCriterion("t_level <>", value, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelGreaterThan(String value) {
            addCriterion("t_level >", value, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelGreaterThanOrEqualTo(String value) {
            addCriterion("t_level >=", value, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelLessThan(String value) {
            addCriterion("t_level <", value, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelLessThanOrEqualTo(String value) {
            addCriterion("t_level <=", value, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelLike(String value) {
            addCriterion("t_level like", value, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelNotLike(String value) {
            addCriterion("t_level not like", value, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelIn(List<String> values) {
            addCriterion("t_level in", values, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelNotIn(List<String> values) {
            addCriterion("t_level not in", values, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelBetween(String value1, String value2) {
            addCriterion("t_level between", value1, value2, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTLevelNotBetween(String value1, String value2) {
            addCriterion("t_level not between", value1, value2, "tLevel");
            return (Criteria) this;
        }

        public Criteria andTMethodnameIsNull() {
            addCriterion("t_methodName is null");
            return (Criteria) this;
        }

        public Criteria andTMethodnameIsNotNull() {
            addCriterion("t_methodName is not null");
            return (Criteria) this;
        }

        public Criteria andTMethodnameEqualTo(String value) {
            addCriterion("t_methodName =", value, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameNotEqualTo(String value) {
            addCriterion("t_methodName <>", value, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameGreaterThan(String value) {
            addCriterion("t_methodName >", value, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameGreaterThanOrEqualTo(String value) {
            addCriterion("t_methodName >=", value, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameLessThan(String value) {
            addCriterion("t_methodName <", value, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameLessThanOrEqualTo(String value) {
            addCriterion("t_methodName <=", value, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameLike(String value) {
            addCriterion("t_methodName like", value, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameNotLike(String value) {
            addCriterion("t_methodName not like", value, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameIn(List<String> values) {
            addCriterion("t_methodName in", values, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameNotIn(List<String> values) {
            addCriterion("t_methodName not in", values, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameBetween(String value1, String value2) {
            addCriterion("t_methodName between", value1, value2, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMethodnameNotBetween(String value1, String value2) {
            addCriterion("t_methodName not between", value1, value2, "tMethodname");
            return (Criteria) this;
        }

        public Criteria andTMsgIsNull() {
            addCriterion("t_msg is null");
            return (Criteria) this;
        }

        public Criteria andTMsgIsNotNull() {
            addCriterion("t_msg is not null");
            return (Criteria) this;
        }

        public Criteria andTMsgEqualTo(String value) {
            addCriterion("t_msg =", value, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgNotEqualTo(String value) {
            addCriterion("t_msg <>", value, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgGreaterThan(String value) {
            addCriterion("t_msg >", value, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgGreaterThanOrEqualTo(String value) {
            addCriterion("t_msg >=", value, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgLessThan(String value) {
            addCriterion("t_msg <", value, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgLessThanOrEqualTo(String value) {
            addCriterion("t_msg <=", value, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgLike(String value) {
            addCriterion("t_msg like", value, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgNotLike(String value) {
            addCriterion("t_msg not like", value, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgIn(List<String> values) {
            addCriterion("t_msg in", values, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgNotIn(List<String> values) {
            addCriterion("t_msg not in", values, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgBetween(String value1, String value2) {
            addCriterion("t_msg between", value1, value2, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTMsgNotBetween(String value1, String value2) {
            addCriterion("t_msg not between", value1, value2, "tMsg");
            return (Criteria) this;
        }

        public Criteria andTUsernameIsNull() {
            addCriterion("t_userName is null");
            return (Criteria) this;
        }

        public Criteria andTUsernameIsNotNull() {
            addCriterion("t_userName is not null");
            return (Criteria) this;
        }

        public Criteria andTUsernameEqualTo(String value) {
            addCriterion("t_userName =", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameNotEqualTo(String value) {
            addCriterion("t_userName <>", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameGreaterThan(String value) {
            addCriterion("t_userName >", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("t_userName >=", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameLessThan(String value) {
            addCriterion("t_userName <", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameLessThanOrEqualTo(String value) {
            addCriterion("t_userName <=", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameLike(String value) {
            addCriterion("t_userName like", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameNotLike(String value) {
            addCriterion("t_userName not like", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameIn(List<String> values) {
            addCriterion("t_userName in", values, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameNotIn(List<String> values) {
            addCriterion("t_userName not in", values, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameBetween(String value1, String value2) {
            addCriterion("t_userName between", value1, value2, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameNotBetween(String value1, String value2) {
            addCriterion("t_userName not between", value1, value2, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrIsNull() {
            addCriterion("t_remoteAddr is null");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrIsNotNull() {
            addCriterion("t_remoteAddr is not null");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrEqualTo(String value) {
            addCriterion("t_remoteAddr =", value, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrNotEqualTo(String value) {
            addCriterion("t_remoteAddr <>", value, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrGreaterThan(String value) {
            addCriterion("t_remoteAddr >", value, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrGreaterThanOrEqualTo(String value) {
            addCriterion("t_remoteAddr >=", value, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrLessThan(String value) {
            addCriterion("t_remoteAddr <", value, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrLessThanOrEqualTo(String value) {
            addCriterion("t_remoteAddr <=", value, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrLike(String value) {
            addCriterion("t_remoteAddr like", value, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrNotLike(String value) {
            addCriterion("t_remoteAddr not like", value, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrIn(List<String> values) {
            addCriterion("t_remoteAddr in", values, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrNotIn(List<String> values) {
            addCriterion("t_remoteAddr not in", values, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrBetween(String value1, String value2) {
            addCriterion("t_remoteAddr between", value1, value2, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTRemoteaddrNotBetween(String value1, String value2) {
            addCriterion("t_remoteAddr not between", value1, value2, "tRemoteaddr");
            return (Criteria) this;
        }

        public Criteria andTUriIsNull() {
            addCriterion("t_uri is null");
            return (Criteria) this;
        }

        public Criteria andTUriIsNotNull() {
            addCriterion("t_uri is not null");
            return (Criteria) this;
        }

        public Criteria andTUriEqualTo(String value) {
            addCriterion("t_uri =", value, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriNotEqualTo(String value) {
            addCriterion("t_uri <>", value, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriGreaterThan(String value) {
            addCriterion("t_uri >", value, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriGreaterThanOrEqualTo(String value) {
            addCriterion("t_uri >=", value, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriLessThan(String value) {
            addCriterion("t_uri <", value, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriLessThanOrEqualTo(String value) {
            addCriterion("t_uri <=", value, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriLike(String value) {
            addCriterion("t_uri like", value, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriNotLike(String value) {
            addCriterion("t_uri not like", value, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriIn(List<String> values) {
            addCriterion("t_uri in", values, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriNotIn(List<String> values) {
            addCriterion("t_uri not in", values, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriBetween(String value1, String value2) {
            addCriterion("t_uri between", value1, value2, "tUri");
            return (Criteria) this;
        }

        public Criteria andTUriNotBetween(String value1, String value2) {
            addCriterion("t_uri not between", value1, value2, "tUri");
            return (Criteria) this;
        }

        public Criteria andTParamsIsNull() {
            addCriterion("t_params is null");
            return (Criteria) this;
        }

        public Criteria andTParamsIsNotNull() {
            addCriterion("t_params is not null");
            return (Criteria) this;
        }

        public Criteria andTParamsEqualTo(String value) {
            addCriterion("t_params =", value, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsNotEqualTo(String value) {
            addCriterion("t_params <>", value, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsGreaterThan(String value) {
            addCriterion("t_params >", value, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsGreaterThanOrEqualTo(String value) {
            addCriterion("t_params >=", value, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsLessThan(String value) {
            addCriterion("t_params <", value, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsLessThanOrEqualTo(String value) {
            addCriterion("t_params <=", value, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsLike(String value) {
            addCriterion("t_params like", value, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsNotLike(String value) {
            addCriterion("t_params not like", value, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsIn(List<String> values) {
            addCriterion("t_params in", values, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsNotIn(List<String> values) {
            addCriterion("t_params not in", values, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsBetween(String value1, String value2) {
            addCriterion("t_params between", value1, value2, "tParams");
            return (Criteria) this;
        }

        public Criteria andTParamsNotBetween(String value1, String value2) {
            addCriterion("t_params not between", value1, value2, "tParams");
            return (Criteria) this;
        }

        public Criteria andTUseridIsNull() {
            addCriterion("t_userId is null");
            return (Criteria) this;
        }

        public Criteria andTUseridIsNotNull() {
            addCriterion("t_userId is not null");
            return (Criteria) this;
        }

        public Criteria andTUseridEqualTo(String value) {
            addCriterion("t_userId =", value, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridNotEqualTo(String value) {
            addCriterion("t_userId <>", value, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridGreaterThan(String value) {
            addCriterion("t_userId >", value, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridGreaterThanOrEqualTo(String value) {
            addCriterion("t_userId >=", value, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridLessThan(String value) {
            addCriterion("t_userId <", value, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridLessThanOrEqualTo(String value) {
            addCriterion("t_userId <=", value, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridLike(String value) {
            addCriterion("t_userId like", value, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridNotLike(String value) {
            addCriterion("t_userId not like", value, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridIn(List<String> values) {
            addCriterion("t_userId in", values, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridNotIn(List<String> values) {
            addCriterion("t_userId not in", values, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridBetween(String value1, String value2) {
            addCriterion("t_userId between", value1, value2, "tUserid");
            return (Criteria) this;
        }

        public Criteria andTUseridNotBetween(String value1, String value2) {
            addCriterion("t_userId not between", value1, value2, "tUserid");
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