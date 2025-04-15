<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.2">

    <!-- 엔티티 매니저 팩토리를 식별하기 위한 이름 설정 -->
    <persistence-unit name="jpa_mission">
        <class>jpa.m250406.basic.mission01.User</class>

        <class>jpa.m250406.basic.mission02.Team</class>
        <class>jpa.m250406.basic.mission02.Member</class>

        <class>jpa.m250406.basic.mission03.Team</class>
        <class>jpa.m250406.basic.mission03.Member</class>

        <class>jpa.m250406.basic.mission04.Team</class>
        <class>jpa.m250406.basic.mission04.Member</class>

        <class>jpa.m250406.basic.mission05.model.Comment</class>
        <class>jpa.m250406.basic.mission05.model.Post</class>
        <class>jpa.m250406.basic.mission05.model.Tag</class>
        <class>jpa.m250406.basic.mission05.model.Users</class>

        <properties>
            <!-- 데이터 베이스 연결 정보 -->
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="root"/>
            <property name="javax.persistence.jdbc.url" value=""/>
            <!-- hibernate 설정 (실행 되는 sql의 생성) -->
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <!-- hibernate 설정 (실행 되는 sql 구문을 format 형태로 보여준다) -->
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>