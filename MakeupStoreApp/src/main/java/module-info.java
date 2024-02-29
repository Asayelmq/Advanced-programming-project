module com.mycompany.makeupstoreapp {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    requires org.hibernate.orm.core; 
    requires java.naming;
    requires java.persistence;
    requires java.sql;
    opens com.mycompany.makeupstoreapp to org.hibernate.orm.core;


    exports com.mycompany.makeupstoreapp;
}
