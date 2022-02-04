package com.mybooktracker.userbooks;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserBooksRepository extends CassandraRepository<UserBooks, UserBooksPrimaryKey>{

    
}
