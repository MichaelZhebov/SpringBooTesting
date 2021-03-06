package com.johnbryce.demo.service;

import com.johnbryce.demo.beans.Forum;
import com.johnbryce.demo.beans.Person;
import com.johnbryce.demo.repo.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumStatistics {

    @Autowired
        private ForumRepository dao;

        public double avgAge(){
            double result=0;
            int counter=0;
            for(Forum f:dao.findAll()){
                for(Person p:f.getMembers()){
                    counter++;
                    result+=p.getAge();
                }
            }
            if(counter==0)
                return 0;
            return result/counter;
        }

        public double avgAge(long forumId){
            if(forumId<0)return -999;
            double result=0;
            int counter=0;
            for(Person p:dao.findById(forumId).get().getMembers()){
                counter++;
                result+=p.getAge();
            }
            if(counter==0)
                return 0;
            return result/counter;
        }
}
