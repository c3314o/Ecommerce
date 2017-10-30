# Ecommerce

Ecommerce application built with Spring Boot and Maven.

## Using CrudController

CrudController tries to implement common CRUD functionality with minimum effort.

In order to use CrudController you will need to:

* create entity extending BaseEntity class,
* create entity repository extending CrudRepository class,
* create service extending CrudService class,
* create form extending BaseForm class,
* create templates for managing entities, creating and updating entities,
* add entity entry to Mapping class,
* create directories in accordance to information added to Mapping class,
* create controller extending CrudController class.

