# lms-REST-backend
A simple and clean Spring Rest API solution for a Library Management System.

- [x] Spring Web
- [x] Spring Data JPA
- [x] MySQL

## Endpoints

All uris are preceded with `api/`.
<p align="center">

| Url | GET | POST | PUT | DELETE |
| :---| :---: | :---: | :---: | :---: | 
| /branch | :+1: | :+1: | :-1: | :-1: |
| /branch/{branchId} | :+1: | :-1: | :+1:  | :-1: |
| /branch/{branchId}/loans | :+1: | :-1: | :-1: | :-1: |
| /branch/{branchId}/inventory | :+1: | :-1: | :-1: | :-1: |
| /loan | :+1: | :+1: | :+1: | :-1: |
| /loan/book/{bookId}| :+1: | :-1: | :-1: | :-1: |
| /loan/customer/{cardNo} | :+1: | :-1: | :-1: | :-1: |
| /stock | :+1: | :+1: | :-1: | :-1: |
| /stock/{branchId} | :+1: | :-1: | :-1: | :-1: |
| /stock/{branchId}/{bookId} | :+1: | :-1: | :+1: | :-1: |
| /book | :+1: | :+1: | :-1: | :-1: |
| /book/{bookId} | :+1: | :-1: | :+1: | :-1: |
| /customer | :+1: | :+1: | :-1: | :-1: |
| /customer/{cardNo} | :+1: | :-1: | :+1: | :-1: |
| /author | :+1: | :+1: | :-1: | :-1: |
| /author/{authorId} | :+1: | :-1: | :+1: | :-1: |

</p>

## ER

<p align="center">
  <img src="https://i.ibb.co/kHvWXJN/er.png" alt="er design"/>
</p>

## Docker
https://hub.docker.com/repository/docker/joshuad23/spring-booter