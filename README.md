# Spring-boot 게시판 만들기 
  - 개발환경
  - IDE : Intellij IDEA 2018.1.6
  - Spring boot
  - MAVEN
  - MariaDB
# 2018.09.18
 - 페이지 구성 및 DataBase 연동
 - 수정할 부분
    - 뒤로가기 버튼 구현 (2018.09.19 수정)
    - 한글 입력 오류 (2018.09.19 수정)
# 2018.09.19
 - 수정할 부분
   - 조회수 update (예정)
   - 수정 시 새로 추가되는 부분 수정 (예정)
 - 요구사항 수정
   - 뒤로가기 버튼 구현
   - 한글 입력 수정 
# 2018.09.21
 - 요구사항 수정
    - 게시판 수정 (2018.09.21 수정)
 - 수정할 부분
    - 조회수 update 
# 2018.09.28
 - 요구사항 수정
    - 조회수 증가 
# 2018.10.01
 - 요구사항 수정
    - 페이지 기능 추가 
# Database 구조
  - Create table board ( 
  - id int(11) not null auto_increment,
  - title varchar(255) not null,
  - writer varchar(40) not null,
  - hit int(11) not null default 0,
  - content text,
  - date datetime not null,
  - primary key (id)  );
# 참조
    - https://springframework.guru