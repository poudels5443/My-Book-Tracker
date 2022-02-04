package com.mybooktracker.user;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface BooksByUserRepository extends CassandraRepository<BooksByUser, String> {

    //returns the slice of books by user
    Slice<BooksByUser> findAllById(String id, Pageable pageable);
    
}
