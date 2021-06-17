create database if not exists spring_security;

-- 계정 추가
drop user if exists 'user_spring_security'@'localhost';

grant all privileges 
   on spring_security.* 
   to 'user_spring_security'@'localhost' identified by 'rootroot';
   
