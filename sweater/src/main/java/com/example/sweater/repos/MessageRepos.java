package com.example.sweater.repos;

import com.example.sweater.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepos extends CrudRepository<Message, Long> {
}
