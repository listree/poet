Prerequisite: install PostgreSQL 10 or higher

#### Command line: psql postgres

- postgres=# create database testdb;

- postgres=# create user test with password 'test';

- postgres=# grant all privileges on database testdb to test;

#### list all databases

- postgres=# \l

#### switch to database

- postgres=# \c testdb

#### list all tables

- testdb=# \dt

#### describe a table

- testdb=# \d testtable

#### Common functions:

- Time: now()

- UUID: gen_random_uuid()
