# lms-REST-backend
A simple and clean Spring Rest API solution for a Library Management System.

- [x] Spring Web
- [x] Spring Data JPA
- [x] MySQL

## Endpoints

All uris are preceded with `api/`.

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

## ER
![ER design pattern](https://i.ibb.co/8MJQSdm/er.png)